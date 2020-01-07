package manage;

import dao.DAO;
import dao.DAOFactory;
import models.order.Order;

import java.util.List;

public class OrderManager  implements Manager<Order>{
    private DAO<Order> orderDAO;

    public OrderManager() {
        orderDAO = DAOFactory.getOrderDAO();
    }

    @Override
    public void create(Order model) {

    }

    @Override
    public void update(Order model) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<Order> getAll() {
        return null;
    }
}
