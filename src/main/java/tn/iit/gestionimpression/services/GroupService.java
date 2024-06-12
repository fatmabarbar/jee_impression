package tn.iit.gestionimpression.services;

import tn.iit.gestionimpression.dao.GroupDao;
import tn.iit.gestionimpression.models.Groupe;

import java.util.List;

public class GroupService {

    private final GroupDao groupDao;

    public GroupService() {
        this.groupDao = new GroupDao();
    }

    public Groupe create(Groupe groupe) {
        this.groupDao.save(groupe);
        return groupe;
    }

    public Groupe read(Integer id) {
        return this.groupDao.find(id);
    }

    public List<Groupe> readAll() {
        return this.groupDao.findAll();
    }

    public Groupe update(Groupe groupe) {
        return this.groupDao.update(groupe);
    }

    public void delete(Integer id) {
        this.groupDao.delete(id);
    }
}