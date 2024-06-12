package tn.iit.gestionimpression.servlets;

import tn.iit.gestionimpression.models.*;
import tn.iit.gestionimpression.services.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

public class InscriptionServlet extends HttpServlet {
    private EnseignantService enseignantService;
    private AgentTirageService agentTirageService;

    public InscriptionServlet() {
        this.enseignantService = new EnseignantService();
        this.agentTirageService = new AgentTirageService();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nom = request.getParameter("nom");
        String email = request.getParameter("email");
        String motDePasse = request.getParameter("motDePasse");
        String role = request.getParameter("role");

        switch (role) {
            case "ENSEIGNANT":
                Enseignant enseignant = new Enseignant();
                enseignant.setNom(nom);
                enseignant.setEmail(email);
                enseignant.setMotDePasse(motDePasse);
                enseignant.setRole(Role.ENSEIGNANT);
                enseignant.setActive(true);
                enseignantService.create(enseignant);
                break;
            case "AGENT_TIRAGE":
                AgentTirage agentTirage = new AgentTirage();
                agentTirage.setNom(nom);
                agentTirage.setEmail(email);
                agentTirage.setMotDePasse(motDePasse);
                agentTirage.setRole(Role.AGENT_TIRAGE);
                agentTirage.setActive(true);
                agentTirageService.create(agentTirage);
                break;
            default:
                throw new IllegalArgumentException("Invalid role: " + role);
        }

        // Redirect to success page
        response.sendRedirect(request.getContextPath() + "/success.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Forward the request to the inscription.jsp view
        RequestDispatcher dispatcher = request.getRequestDispatcher("/inscription.jsp");
        dispatcher.forward(request, response);
    }
}