package manage;

import dao.DAO;
import dao.DAOFactory;
import models.order.Order;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

public class OrderManager  implements Manager<Order>{
    private DAO<Order> orderDAO;

    public OrderManager() {
        orderDAO = DAOFactory.getOrderDAO();
    }

    @Override
    public boolean create(Order model) {
        if(model.getDate() != null){
            orderDAO.create(model);
            return true;
        }
        return false;
    }

    @Override
    public boolean update(Order model) {
        if(model.getDate() != null){
            orderDAO.update(model);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        if(id>0){
            orderDAO.delete(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Order> getAll() {
        try {
            return orderDAO.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
}
