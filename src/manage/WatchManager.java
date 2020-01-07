package manage;

import dao.DAO;
import dao.DAOFactory;
import models.watch.Watch;

import java.util.List;

public class WatchManager implements Manager<Watch> {
    private DAO<Watch> watchDAO;

    public WatchManager() {
        watchDAO = DAOFactory.getWatchDAO();
    }

    @Override
    public void create(Watch model) {

    }

    @Override
    public void update(Watch model) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<Watch> getAll() {
        return null;
    }
}
