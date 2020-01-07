package manage;

import dao.DAO;
import dao.DAOFactory;
import models.Vendor;

import java.util.List;

public class VendorManager  implements Manager<Vendor> {
    private DAO<Vendor> vendorDAO;

    public VendorManager() {
        vendorDAO = DAOFactory.getVendorsDAO();
    }

    @Override
    public void create(Vendor model) {

    }

    @Override
    public void update(Vendor model) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<Vendor> getAll() {
        return null;
    }
}
