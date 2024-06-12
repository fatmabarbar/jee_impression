package tn.iit.gestionimpression.servlets;

import jakarta.servlet.annotation.WebServlet;
import tn.iit.gestionimpression.services.AgentTirageService;
import tn.iit.gestionimpression.services.EnseignantService;
import tn.iit.gestionimpression.models.AgentTirage;
import tn.iit.gestionimpression.models.Enseignant;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AdministrateurServlet extends HttpServlet {

    private EnseignantService enseignantService = new EnseignantService();
    private AgentTirageService agentTirageService = new AgentTirageService();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Enseignant> enseignants = enseignantService.readAll();
        List<AgentTirage> agentTirages = agentTirageService.readAll();

        List<Object> users = new ArrayList<>();
        users.addAll(enseignants);
        users.addAll(agentTirages);

        req.setAttribute("users", users);
        req.getRequestDispatcher("/administrateur.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        Integer id = Integer.parseInt(req.getParameter("id"));

        switch (action) {
            case "activate":
                Enseignant enseignant = enseignantService.read(id);
                if (enseignant != null) {
                    enseignant.setActive(true);
                    enseignantService.update(enseignant);
                } else {
                    AgentTirage agentTirage = agentTirageService.read(id);
                    if (agentTirage != null) {
                        agentTirage.setActive(true);
                        agentTirageService.update(agentTirage);
                    }
                }
                break;
            case "deactivate":
                Enseignant enseignantToDeactivate = enseignantService.read(id);
                if (enseignantToDeactivate != null) {
                    enseignantToDeactivate.setActive(false);
                    enseignantService.update(enseignantToDeactivate);
                } else {
                    AgentTirage agentTirageToDeactivate = agentTirageService.read(id);
                    if (agentTirageToDeactivate != null) {
                        agentTirageToDeactivate.setActive(false);
                        agentTirageService.update(agentTirageToDeactivate);
                    }
                }
                break;
            default:
                resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid action");
                return;
        }

        resp.sendRedirect("administrateur");  // Redirect to the same page to display the updated list of users
    }
}