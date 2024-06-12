package tn.iit.gestionimpression.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tn.iit.gestionimpression.models.AgentTirage;
import tn.iit.gestionimpression.models.DemandeTirage;
import tn.iit.gestionimpression.services.AgentTirageService;
import tn.iit.gestionimpression.services.DemandeTirageService;

import java.io.IOException;
import java.util.List;

public class AgentTirageServlet extends HttpServlet {

    private AgentTirageService agentTirageService;
    private DemandeTirageService demandeTirageService;

    public AgentTirageServlet() {
        this.agentTirageService = new AgentTirageService();
        this.demandeTirageService = new DemandeTirageService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AgentTirage agentTirage = (AgentTirage) req.getSession().getAttribute("user");
        List<DemandeTirage> demandesTirage = demandeTirageService.findAll();
        req.setAttribute("demandesTirage", demandesTirage);

        // Add the savePath to the request attributes
        String savePath = "/resources";
        req.setAttribute("savePath", savePath);

        req.getRequestDispatcher("/agentTirage.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        Integer id = Integer.parseInt(req.getParameter("id"));

        switch (action) {
            case "resolve":
                DemandeTirage demandeTirage = demandeTirageService.read(id);
                if (demandeTirage != null) {
                    demandeTirage.setResolue(true);
                    demandeTirageService.update(demandeTirage);
                }
                break;
            default:
                resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid action");
                return;
        }

        resp.sendRedirect(req.getContextPath() + "/agentTirage");  // Redirect to the same page to display the updated list of demandesTirage
    }
}