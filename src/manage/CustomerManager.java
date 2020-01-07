package manage;

import dao.DAO;
import dao.DAOFactory;
import models.Customer;

import java.util.List;

public class CustomerManager implements Manager<Customer> {
    private DAO<Customer> customerDAO;

    public CustomerManager() {
        customerDAO = DAOFactory.getCustomerDAO();
    }

    @Override
    public void create(Customer model) {

    }

    @Override
    public void update(Customer model) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<Customer> getAll() {
        return null;
    }
}

