package dao;

import java.util.List;

public class AbstractJDBCDaoImpl<T, > implements DAO {
    @Override
    public Object create(Object model) {
        return null;
    }

    @Override
    public boolean update(Object model) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public List getAll() {
        return null;
    }

    @Override
    public Object getById(int id) {
        return null;
    }
}
