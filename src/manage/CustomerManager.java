package manage;

import dao.DAO;
import dao.DAOFactory;
import models.Customer;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

public class CustomerManager implements Manager<Customer> {
    private DAO<Customer> customerDAO;

    public CustomerManager() {
        customerDAO = DAOFactory.getCustomerDAO();
    }

    @Override
    public boolean create(Customer model) {
      if(model.getName() != null){
          customerDAO.create(model);
          return true;
      }
      return false;
    }

    @Override
    public boolean update(Customer model) {
        if(model.getName() != null){
            customerDAO.update(model);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        if(id>0){
            customerDAO.delete(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Customer> getAll() {
        try {
            return customerDAO.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
}

