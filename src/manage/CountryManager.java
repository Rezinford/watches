package manage;

import dao.DAO;
import dao.DAOFactory;
import models.Country;

import java.util.List;

public class CountryManager implements Manager<Country>{
    private DAO<Country> countryDAO;

    public CountryManager() {
        countryDAO = DAOFactory.getCountriesDAO();
    }

    @Override
    public void create(Country model) {

    }

    @Override
    public void update(Country model) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<Country> getAll() {
        return null;
    }
}
