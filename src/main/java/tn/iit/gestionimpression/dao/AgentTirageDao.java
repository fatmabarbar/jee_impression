package tn.iit.gestionimpression.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import tn.iit.gestionimpression.models.AgentTirage;

import java.util.List;

public class AgentTirageDao {

    private static SessionFactory sessionFactory;

    static {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    public AgentTirage find(Integer id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(AgentTirage.class, id);
        }
    }

    public List<AgentTirage> findAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("SELECT DISTINCT a FROM AgentTirage a", AgentTirage.class).list();
        }
    }

    public void save(AgentTirage agentTirage) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(agentTirage);
            transaction.commit();
        }
    }

    public AgentTirage update(AgentTirage agentTirage) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            AgentTirage updatedAgentTirage = (AgentTirage) session.merge(agentTirage);
            transaction.commit();
            return updatedAgentTirage;
        }
    }

    public void delete(Integer id) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            AgentTirage agentTirage = session.get(AgentTirage.class, id);
            if (agentTirage != null) {
                session.delete(agentTirage);
            }
            transaction.commit();
        }
    }

    public AgentTirage findByEmail(String email) {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM AgentTirage a WHERE a.email = :email", AgentTirage.class)
                    .setParameter("email", email)
                    .uniqueResult();
        }
    }
}