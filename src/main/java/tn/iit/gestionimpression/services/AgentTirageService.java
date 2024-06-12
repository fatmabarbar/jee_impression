package tn.iit.gestionimpression.services;

import org.hibernate.Hibernate;
import tn.iit.gestionimpression.dao.AgentTirageDao;
import tn.iit.gestionimpression.models.AgentTirage;

import java.util.List;

public class AgentTirageService {

    private final AgentTirageDao agentTirageDao;

    public AgentTirageService() {
        this.agentTirageDao = new AgentTirageDao();
    }

    public AgentTirage create(AgentTirage agentTirage) {
        this.agentTirageDao.save(agentTirage);
        return agentTirage;
    }

    public AgentTirage read(Integer id) {
        return this.agentTirageDao.find(id);
    }

    public List<AgentTirage> readAll() {
        List<AgentTirage> agentTirages = this.agentTirageDao.findAll();
        for (AgentTirage agentTirage : agentTirages) {
            Hibernate.initialize(agentTirage.getDemandesTirage());
        }
        return agentTirages;
    }

    public AgentTirage update(AgentTirage agentTirage) {
        return this.agentTirageDao.update(agentTirage);
    }

    public void delete(Integer id) {
        this.agentTirageDao.delete(id);
    }

    public AgentTirage findByEmail(String email) {
        return this.agentTirageDao.findByEmail(email);
    }
}