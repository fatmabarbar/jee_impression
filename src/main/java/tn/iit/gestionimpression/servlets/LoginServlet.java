package tn.iit.gestionimpression.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import tn.iit.gestionimpression.models.Administrateur;
import tn.iit.gestionimpression.models.AgentTirage;
import tn.iit.gestionimpression.models.Enseignant;
import tn.iit.gestionimpression.services.AdministrateurService;
import tn.iit.gestionimpression.services.AgentTirageService;
import tn.iit.gestionimpression.services.EnseignantService;

import java.io.IOException;

public class LoginServlet extends HttpServlet {

    private AdministrateurService administrateurService = new AdministrateurService();
    private EnseignantService enseignantService = new EnseignantService();
    private AgentTirageService agentTirageService = new AgentTirageService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        Administrateur administrateur = administrateurService.findByEmail(email);
        Enseignant enseignant = enseignantService.findByEmail(email);
        AgentTirage agentTirage = agentTirageService.findByEmail(email);

        if (administrateur != null && administrateur.getMotDePasse().equals(password)) {
            req.getSession().setAttribute("user", administrateur);
            resp.sendRedirect(req.getContextPath() + "/administrateur");
        } else if (enseignant != null && enseignant.getMotDePasse().equals(password)) {
            req.getSession().setAttribute("user", enseignant);
            resp.sendRedirect(req.getContextPath() + "/enseignant");
        } else if (agentTirage != null && agentTirage.getMotDePasse().equals(password)) {
            req.getSession().setAttribute("user", agentTirage);
            resp.sendRedirect(req.getContextPath() + "/agentTirage");
        } else {
            req.setAttribute("error", "Invalid email or password");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
    }
}