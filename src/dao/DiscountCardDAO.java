package dao;

import models.DiscountCard;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static db.dbConnect.getConnection;

public class DiscountCardDAO implements DAO<models.DiscountCard> {
  final String table = "score.discountCard";
    @Override
    public void create(DiscountCard discountCard) {
        final String sqlRequest = "insert into " + table + " (number, discount) values (?, ?)";
        try (final PreparedStatement prepareStatement
                     = getConnection().prepareStatement(sqlRequest, Statement.RETURN_GENERATED_KEYS)) {
            prepareStatement.setInt(1,discountCard.getNumber());
            prepareStatement.setInt(2,discountCard.getDiscount());
            prepareStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(DiscountCard discountCard) {
        final String sqlRequest = "update " + table +"set (number, discount) values (?, ?) where country_id = ?";

        try (final PreparedStatement prepareStatement = getConnection().prepareStatement(sqlRequest)) {
            prepareStatement.setString(1, discountCard.getName());
            prepareStatement.setInt(2, discountCard.getId());
            prepareStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        final String sqlRequest = "delete from " + table +" where country_id = ?";
        try (final PreparedStatement prepareStatement = getConnection().prepareStatement(sqlRequest)) {
            prepareStatement.setInt(1, id);
            prepareStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<DiscountCard> getAll() throws SQLException {
        List<DiscountCard> resultList = new ArrayList<>();
        final String sqlRequest = "select * from" + table;
        try (final PreparedStatement prepareStatement = getConnection().prepareStatement(sqlRequest)) {
                ResultSet rs = prepareStatement.executeQuery(sqlRequest);
                while (rs.next()){
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    resultList.add(new DiscountCard(id, name));
                }
                return resultList;
        }
    }

    @Override
    public Country getById(int idNumde)  throws SQLException {
        final String  sqlRequest = "select * from" + table +" where id = ?";
        try (final PreparedStatement prepareStatement = getConnection().prepareStatement(sqlRequest)) {
            prepareStatement.setInt(1, idNumde);
            prepareStatement.executeUpdate();
            ResultSet rs = prepareStatement.executeQuery(sqlRequest);
            int id = rs.getInt("id");
            String name = rs.getString("name");
            return new Country(id, name);
        }
    }
}
}
