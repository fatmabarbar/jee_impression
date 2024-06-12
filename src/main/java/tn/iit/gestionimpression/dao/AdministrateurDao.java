package tn.iit.gestionimpression.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import tn.iit.gestionimpression.models.Administrateur;

import java.util.List;

public class AdministrateurDao {

    private static SessionFactory sessionFactory;

    static {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    public Administrateur find(Integer id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Administrateur.class, id);
        }
    }

    public List<Administrateur> findAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Administrateur", Administrateur.class).list();
        }
    }

    public void save(Administrateur administrateur) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(administrateur);
            transaction.commit();
        }
    }

    public Administrateur update(Administrateur administrateur) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Administrateur updatedAdministrateur = (Administrateur) session.merge(administrateur);
            transaction.commit();
            return updatedAdministrateur;
        }
    }

    public void delete(Integer id) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Administrateur administrateur = session.get(Administrateur.class, id);
            if (administrateur != null) {
                session.delete(administrateur);
            }
            transaction.commit();
        }
    }

    public Administrateur findByEmail(String email) {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Administrateur a WHERE a.email = :email", Administrateur.class)
                    .setParameter("email", email)
                    .uniqueResult();
        }
    }
}