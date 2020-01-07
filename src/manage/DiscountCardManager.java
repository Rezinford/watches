package manage;

import dao.DAO;
import dao.DAOFactory;
import models.DiscountCard;
import models.DiscountCard;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

public class DiscountCardManager implements Manager<DiscountCard> {
    private DAO<DiscountCard> discountCardDAO;

    public DiscountCardManager() {
        discountCardDAO = DAOFactory.getDiscountCardDAO();
    }

    @Override
    public boolean create(DiscountCard model) {
        if(model.getNumber() >0){
            discountCardDAO.create(model);
            return true;
        }
        return false;
    }

    @Override
    public boolean update(DiscountCard model) {
        if(model.getNumber() >0){
            discountCardDAO.update(model);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        if(id>0){
            discountCardDAO.delete(id);
            return true;
        }
        return false;
    }

    @Override
    public List<DiscountCard> getAll() {
        try {
            return discountCardDAO.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
}
