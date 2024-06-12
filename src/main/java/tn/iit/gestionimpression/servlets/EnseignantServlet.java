package tn.iit.gestionimpression.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import tn.iit.gestionimpression.models.DemandeTirage;
import tn.iit.gestionimpression.models.Enseignant;
import tn.iit.gestionimpression.models.Matiere;
import tn.iit.gestionimpression.services.DemandeTirageService;
import tn.iit.gestionimpression.services.EnseignantService;
import tn.iit.gestionimpression.services.MatiereService;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.util.List;

@MultipartConfig
public class EnseignantServlet extends HttpServlet {

    private EnseignantService enseignantService;
    private MatiereService matiereService;
    private DemandeTirageService demandeTirageService;

    public EnseignantServlet() {
        this.enseignantService = new EnseignantService();
        this.matiereService = new MatiereService();
        this.demandeTirageService = new DemandeTirageService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Enseignant enseignant = (Enseignant) req.getSession().getAttribute("user");
        if (enseignant == null) {
            resp.sendRedirect(req.getContextPath() + "/login"); // Redirige vers la page de login si l'utilisateur n'est pas connecté
            return;
        }

        List<Matiere> matieres = matiereService.findByEnseignant(enseignant);
        req.setAttribute("matieres", matieres);
        req.getRequestDispatcher("/enseignant.jsp").forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Enseignant enseignant = (Enseignant) req.getSession().getAttribute("user");
        Matiere matiere = matiereService.read(Integer.parseInt(req.getParameter("matiereId")));
        LocalDateTime dateHeureRetrait = LocalDateTime.parse(req.getParameter("dateHeureRetrait"));
        int nombreCopies = Integer.parseInt(req.getParameter("nombreCopies"));

        Part filePart = req.getPart("document"); // Retrieves <input type="file" name="document">
        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.

        // Define the path where you want to save the file
        String savePath = "C:\\Users\\Lenovo\\eclipse-workspace\\jee\\src\\main\\webapp\\resources";

        // If the directory doesn't exist, create it
        File uploadsDir = new File(savePath);
        if (!uploadsDir.exists()) {
            uploadsDir.mkdirs();
        }

        // Combine the savePath with the file name to get the full path of the file
        File file = new File(savePath, fileName);

        // Write the file
        try (InputStream fileContent = filePart.getInputStream()) {
            Files.copy(fileContent, file.toPath(), StandardCopyOption.REPLACE_EXISTING);
        }

        DemandeTirage demandeTirage = new DemandeTirage();
        demandeTirage.setEnseignant(enseignant);
        demandeTirage.setMatiere(matiere);
        demandeTirage.setDocument(fileName);
        demandeTirage.setNombreCopies(nombreCopies);
        demandeTirage.setDateHeureRetrait(dateHeureRetrait);

        demandeTirageService.create(demandeTirage);

        resp.sendRedirect(req.getContextPath() + "/enseignant");
    }
}