package tn.iit.gestionimpression.services;

import tn.iit.gestionimpression.dao.AdministrateurDao;
import tn.iit.gestionimpression.models.Administrateur;

import java.util.List;

public class AdministrateurService {

    private final AdministrateurDao administrateurDao;

    public AdministrateurService() {
        this.administrateurDao = new AdministrateurDao();
    }

    public Administrateur create(Administrateur administrateur) {
        this.administrateurDao.save(administrateur);
        return administrateur;
    }

    public Administrateur read(Integer id) {
        return this.administrateurDao.find(id);
    }

    public List<Administrateur> readAll() {
        return this.administrateurDao.findAll();
    }

    public Administrateur update(Administrateur administrateur) {
        return this.administrateurDao.update(administrateur);
    }

    public void delete(Integer id) {
        this.administrateurDao.delete(id);
    }

    public Administrateur findByEmail(String email) {
        return this.administrateurDao.findByEmail(email);
    }
}