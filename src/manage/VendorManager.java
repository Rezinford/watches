package manage;

import dao.DAO;
import dao.DAOFactory;
import models.Vendor;
import models.Vendor;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

public class VendorManager  implements Manager<Vendor> {
    private DAO<Vendor> vendorDAO;

    public VendorManager() {
        vendorDAO = DAOFactory.getVendorsDAO();
    }

    @Override
    public boolean create(Vendor model) {
        if(model.getName() != null){
            vendorDAO.create(model);
            return true;
        }
        return false;
    }

    @Override
    public boolean update(Vendor model) {
        if(model.getName() != null){
            vendorDAO.update(model);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        if(id>0){
            vendorDAO.delete(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Vendor> getAll() {
        try {
            return vendorDAO.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
}
