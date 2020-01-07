package manage;

import dao.DAO;
import dao.DAOFactory;
import models.Country;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

public class CountryManager implements Manager<Country>{
    private DAO<Country> countryDAO;

    public CountryManager() {
        countryDAO = DAOFactory.getCountriesDAO();
    }

    @Override
    public boolean create(Country model) {
        if (model.getName() != null){
            countryDAO.create(model);
            return true;
        }
        return false;
    }

    @Override
    public boolean update(Country model) {
        if(model.getName() != null){
            countryDAO.update(model);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        if(id>0) {
            countryDAO.delete(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Country> getAll() {
        try {
            return countryDAO.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
}
