package dao;

import models.Country;
import models.Customer;
import models.DiscountCard;

import java.lang.reflect.Field;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static db.dbConnect.getConnection;

public class CustomerDAO implements DAO<models.Customer> {
    final String table = "score.customer";
    @Override
    public void create(Customer customer) {
        final String sqlRequest = "insert into " + table + " (name, curtNumder) values (?, ?)";
        try (final PreparedStatement prepareStatement
                     = getConnection().prepareStatement(sqlRequest, Statement.RETURN_GENERATED_KEYS)) {
            prepareStatement.setString(1, customer.getName());
            prepareStatement.setInt(2, customer.getDiscountCard().getId());
            prepareStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Customer customer) {
        final String sqlRequest = "update " + table +"set (name, disconnectcard, sumoforders) " +
                                    "values (?, ?, ?) where country_id = ?";
        try (final PreparedStatement prepareStatement = getConnection().prepareStatement(sqlRequest)) {
            prepareStatement.setString(1, customer.getName());
            prepareStatement.setInt(2, customer.getDiscountCard().getId());
            prepareStatement.setDouble(3, customer.getSumOfOrders());
            prepareStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        final String sqlRequest = "delete from " + table +" where customer_id = ?";
        try (final PreparedStatement prepareStatement = getConnection().prepareStatement(sqlRequest)) {
            prepareStatement.setInt(1, id);
            prepareStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Customer> getAll() throws SQLException {
        List<Customer> resultList = new ArrayList<>();
        final String sqlRequest = "select * from" + table +
                " left join score.dscountCurd " +
                "ON countryid = country.id";
        try (final PreparedStatement prepareStatement = getConnection().prepareStatement(sqlRequest)) {
            ResultSet rs = prepareStatement.executeQuery(sqlRequest);
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int cartNumber = rs.getInt("discountcardId");
                int sumOfOrders = rs.getInt("sumoforders");
                int discountCardId = rs.getInt("id");
                int discountCardNumber = rs.getInt("number");
                int discountCardDiscount = rs.getInt("discount");
                resultList.add(new Customer(id, name, new DiscountCard(discountCardId,discountCardNumber, discountCardDiscount), sumOfOrders));

            }
            return resultList;
        }
    }

    @Override
    public Customer getById(int idNumder) throws SQLException {
        final String sqlRequest = "select * from" + table +
                                    " left join score.dscountCurd " +
                                    "ON countryid = country.id"+
                                    " where id = ?";
        try (final PreparedStatement prepareStatement = getConnection().prepareStatement(sqlRequest)) {
            prepareStatement.setInt(1, idNumder);
            prepareStatement.executeUpdate();
            ResultSet rs = prepareStatement.executeQuery(sqlRequest);
            int id = rs.getInt("id");
            String name = rs.getString("name");
            int cartNumber = rs.getInt("discountcardId");
            int sumOfOrders = rs.getInt("sumoforders");
            int discountCardId = rs.getInt("id");
            int discountCardNumber = rs.getInt("number");
            int discountCardDiscount = rs.getInt("discount");
            return new Customer(id, name, new DiscountCard(discountCardId,discountCardNumber, discountCardDiscount), sumOfOrders);
        }
    }
}

