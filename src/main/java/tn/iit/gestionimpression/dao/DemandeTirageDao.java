package tn.iit.gestionimpression.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import tn.iit.gestionimpression.models.DemandeTirage;

import java.util.List;

public class DemandeTirageDao {

    private static SessionFactory sessionFactory;

    static {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    public DemandeTirage find(Integer id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(DemandeTirage.class, id);
        }
    }

    public List<DemandeTirage> findAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM DemandeTirage", DemandeTirage.class).list();
        }
    }

    public void save(DemandeTirage demandeTirage) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(demandeTirage);
            transaction.commit();
        }
    }

    public DemandeTirage update(DemandeTirage demandeTirage) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            DemandeTirage updatedDemandeTirage = (DemandeTirage) session.merge(demandeTirage);
            transaction.commit();
            return updatedDemandeTirage;
        }
    }

    public void delete(Integer id) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            DemandeTirage demandeTirage = session.get(DemandeTirage.class, id);
            if (demandeTirage != null) {
                session.delete(demandeTirage);
            }
            transaction.commit();
        }
    }
}