package tn.iit.gestionimpression.services;

import tn.iit.gestionimpression.dao.DemandeTirageDao;
import tn.iit.gestionimpression.models.DemandeTirage;

import java.util.List;

public class DemandeTirageService {

    private final DemandeTirageDao demandeTirageDao;

    public DemandeTirageService() {
        this.demandeTirageDao = new DemandeTirageDao();
    }

    public DemandeTirage create(DemandeTirage demandeTirage) {
        this.demandeTirageDao.save(demandeTirage);
        return demandeTirage;
    }

    public DemandeTirage read(Integer id) {
        return this.demandeTirageDao.find(id);
    }

    public List<DemandeTirage> findAll() {
        return this.demandeTirageDao.findAll();
    }

    public DemandeTirage update(DemandeTirage demandeTirage) {
        return this.demandeTirageDao.update(demandeTirage);
    }

    public void delete(Integer id) {
        this.demandeTirageDao.delete(id);
    }
}