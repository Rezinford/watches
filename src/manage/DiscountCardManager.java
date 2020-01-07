package manage;

import dao.DAO;
import dao.DAOFactory;
import models.DiscountCard;

import java.util.List;

public class DiscountCardManager implements Manager<DiscountCard> {
    private DAO<DiscountCard> discountCardDAO;

    public DiscountCardManager() {
        discountCardDAO = DAOFactory.getDiscountCardDAO();
    }

    @Override
    public void create(DiscountCard model) {

    }

    @Override
    public void update(DiscountCard model) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<DiscountCard> getAll() {
        return null;
    }
}
