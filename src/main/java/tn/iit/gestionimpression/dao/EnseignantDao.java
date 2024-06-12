package tn.iit.gestionimpression.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import tn.iit.gestionimpression.models.Enseignant;

import java.util.List;

public class EnseignantDao {

    private static SessionFactory sessionFactory;

    static {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    public Enseignant find(Integer id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Enseignant.class, id);
        }
    }

    public List<Enseignant> findAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("SELECT DISTINCT e FROM Enseignant e JOIN FETCH e.matieres m JOIN FETCH m.demandesTirage", Enseignant.class).list();
        }
    }

    public void save(Enseignant enseignant) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(enseignant);
            transaction.commit();
        }
    }

    public Enseignant update(Enseignant enseignant) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Enseignant updatedEnseignant = (Enseignant) session.merge(enseignant);
            transaction.commit();
            return updatedEnseignant;
        }
    }

    public void delete(Integer id) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Enseignant enseignant = session.get(Enseignant.class, id);
            if (enseignant != null) {
                session.delete(enseignant);
            }
            transaction.commit();
        }
    }

    public Enseignant findByEmail(String email) {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Enseignant e WHERE e.email = :email", Enseignant.class)
                    .setParameter("email", email)
                    .uniqueResult();
        }
    }
}