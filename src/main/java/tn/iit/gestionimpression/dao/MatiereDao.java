package tn.iit.gestionimpression.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import tn.iit.gestionimpression.models.Enseignant;
import tn.iit.gestionimpression.models.Matiere;

import java.util.List;

public class MatiereDao {

    private static SessionFactory sessionFactory;

    static {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    public Matiere find(Integer id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Matiere.class, id);
        }
    }

    public List<Matiere> findAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Matiere", Matiere.class).list();
        }
    }

    public void save(Matiere matiere) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(matiere);
            transaction.commit();
        }
    }

    public Matiere update(Matiere matiere) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Matiere updatedMatiere = (Matiere) session.merge(matiere);
            transaction.commit();
            return updatedMatiere;
        }
    }

    public void delete(Integer id) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Matiere matiere = session.get(Matiere.class, id);
            if (matiere != null) {
                session.delete(matiere);
            }
            transaction.commit();
        }
    }

    public List<Matiere> findByEnseignant(Enseignant enseignant) {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Matiere m WHERE m.enseignant = :enseignant", Matiere.class)
                    .setParameter("enseignant", enseignant)
                    .list();
        }
    }
}