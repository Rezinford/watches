package dao;

import models.Country;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static db.DBConnect.getConnection;


public class CountryDAO implements DAO<Country> {
    final String table = "score.country";
    @Override
    public void create(Country country) {
        final String sqlRequest = "insert into " + table + " (name) values (?)";
        try (final PreparedStatement prepareStatement
                     = getConnection().prepareStatement(sqlRequest, Statement.RETURN_GENERATED_KEYS)) {
            prepareStatement.setString(1,country.getName());
            prepareStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Country country) {
        final String sqlRequest = "update " + table +" set name = ? where id = ?";

        try (final PreparedStatement prepareStatement = getConnection().prepareStatement(sqlRequest)) {
            prepareStatement.setString(1, country.getName());
            prepareStatement.setInt(2, country.getId());
            prepareStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        final String sqlRequest = "delete from " + table +" where watches.score.country.id = ?";
        try (final PreparedStatement prepareStatement = getConnection().prepareStatement(sqlRequest)) {
            prepareStatement.setInt(1, id);
            prepareStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Country> getAll() throws SQLException {
        List<Country> resultList = new ArrayList<>();
        final String sqlRequest = "select * from " + table;
        try (final PreparedStatement prepareStatement = getConnection().prepareStatement(sqlRequest)) {
                ResultSet rs = prepareStatement.executeQuery();
                while (rs.next()){
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    resultList.add(new Country(id, name));
                }
                return resultList;
        }
    }

    @Override
    public Country getById(int idNumde)  throws SQLException{
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
