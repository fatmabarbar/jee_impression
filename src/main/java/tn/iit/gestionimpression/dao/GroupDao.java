package tn.iit.gestionimpression.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import tn.iit.gestionimpression.models.Groupe;

import java.util.List;

public class GroupDao {

    private static SessionFactory sessionFactory;

    static {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    public Groupe find(Integer id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Groupe.class, id);
        }
    }

    public List<Groupe> findAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Groupe", Groupe.class).list();
        }
    }

    public void save(Groupe groupe) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(groupe);
            transaction.commit();
        }
    }

    public Groupe update(Groupe groupe) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Groupe updatedGroupe = (Groupe) session.merge(groupe);
            transaction.commit();
            return updatedGroupe;
        }
    }

    public void delete(Integer id) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Groupe groupe = session.get(Groupe.class, id);
            if (groupe != null) {
                session.delete(groupe);
            }
            transaction.commit();
        }
    }
}