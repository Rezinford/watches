package manage;

import dao.DAO;
import dao.DAOFactory;
import models.watch.Watch;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

public class WatchManager implements Manager<Watch> {
    private DAO<Watch> watchDAO;

    public WatchManager() {
        watchDAO = DAOFactory.getWatchDAO();
    }

    @Override
    public boolean create(Watch model) {
        if(model.getVendor() != null){
            watchDAO.create(model);
            return true;
        }
        return false;
    }

    @Override
    public boolean update(Watch model) {
        if(model.getVendor() != null){
            watchDAO.update(model);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        if(id>0){
            watchDAO.delete(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Watch> getAll() {
        try {
            return watchDAO.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
}
