package tn.iit.gestionimpression.services;

import tn.iit.gestionimpression.dao.MatiereDao;
import tn.iit.gestionimpression.models.Enseignant;
import tn.iit.gestionimpression.models.Matiere;

import java.util.List;

public class MatiereService {

    private final MatiereDao matiereDao;

    public MatiereService() {
        this.matiereDao = new MatiereDao();
    }

    public Matiere create(Matiere matiere) {
        this.matiereDao.save(matiere);
        return matiere;
    }

    public Matiere read(Integer id) {
        return this.matiereDao.find(id);
    }

    public List<Matiere> readAll() {
        return this.matiereDao.findAll();
    }

    public Matiere update(Matiere matiere) {
        return this.matiereDao.update(matiere);
    }

    public void delete(Integer id) {
        this.matiereDao.delete(id);
    }

    public List<Matiere> findByEnseignant(Enseignant enseignant) {
        return this.matiereDao.findByEnseignant(enseignant);
    }
}