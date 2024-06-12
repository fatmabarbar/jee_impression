package tn.iit.gestionimpression.services;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import tn.iit.gestionimpression.dao.EnseignantDao;
import tn.iit.gestionimpression.models.Enseignant;

import javax.transaction.Transactional;
import java.beans.Transient;
import java.util.List;

public class EnseignantService {

    private final EnseignantDao enseignantDao;

    private static SessionFactory sessionFactory;

    static {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    public EnseignantService() {
        this.enseignantDao = new EnseignantDao();
    }

    public Enseignant create(Enseignant enseignant) {
        this.enseignantDao.save(enseignant);
        return enseignant;
    }

    public Enseignant read(Integer id) {
        return this.enseignantDao.find(id);
    }

    public List<Enseignant> readAll() {
        List<Enseignant> enseignants = this.enseignantDao.findAll();
        for (Enseignant enseignant : enseignants) {
            Hibernate.initialize(enseignant.getMatieres());
        }
        return enseignants;
    }

    public Enseignant update(Enseignant enseignant) {
        return this.enseignantDao.update(enseignant);
    }

    public void delete(Integer id) {
        this.enseignantDao.delete(id);
    }

    public Enseignant findByEmail(String email) {
        return this.enseignantDao.findByEmail(email);
    }

    @Transactional
    public Enseignant getEnseignantWithMatieres(int id) {
        Enseignant enseignant = enseignantDao.find(id);
        Hibernate.initialize(enseignant.getMatieres());
        return enseignant;
    }
}