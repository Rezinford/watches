package dao;

import models.Country;
import models.Vendor;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static db.dbConnect.getConnection;

public class VendorDAO implements DAO<models.Vendor> {

    final String table = "score.vendor";

    @Override
    public void create(Vendor vendor) {
        final String sqlRequest = "insert into " + table +
                                    " (name , countryId) " +
                                    "values (?, ?)";
        try (final PreparedStatement prepareStatement
                     = getConnection().prepareStatement(sqlRequest, Statement.RETURN_GENERATED_KEYS)) {
            prepareStatement.setString(1, vendor.getName());
            prepareStatement.setInt(2, vendor.getCountry().getId());
            prepareStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Vendor vendor) {
        final String sqlRequest = "update " + table +
                                    " set (name , countryId) " +
                                    "values (?, ?) " +
                                    "where vendor_id = ?";

        try (final PreparedStatement prepareStatement = getConnection().prepareStatement(sqlRequest)) {
            prepareStatement.setString(1, vendor.getName());
            prepareStatement.setInt(2, vendor.getCountry().getId());
            prepareStatement.setInt(3, vendor.getId());
            prepareStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        final String sqlRequest = "delete from " + table + " where vendor_id = ?";
        try (final PreparedStatement prepareStatement = getConnection().prepareStatement(sqlRequest)) {
            prepareStatement.setInt(1, id);
            prepareStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Vendor> getAll() throws SQLException {
        List<Vendor> resultList = new ArrayList<>();
//        final String sqlRequest = "select * from" + table;
        final String sqlRequest = "select * from score.vendor" +
                                    "LEFT JOIN country " +
                                    "ON score.vendor.countryid = score.country.id ";
        try (final PreparedStatement prepareStatement = getConnection().prepareStatement(sqlRequest)) {
            ResultSet rs = prepareStatement.executeQuery(sqlRequest);
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int countryId = rs.getInt("countryId");
                String countryName = rs.getString("name");
                resultList.add(new Vendor(id, name, new Country(countryId, countryName)));
            }
            return resultList;
        }
    }

    @Override
    public Vendor getById(int idNumde) throws SQLException {
//        final String  sqlRequest = "select * from" + table +" where id = ?  LEFT JOIN country on vendor. ";
        final String sqlRequest = "select * from score.vendor" +
                                    "LEFT JOIN country " +
                                    "ON score.vendor.countryid = score.country.id " +
                                    "where id = ?";
        try (final PreparedStatement prepareStatement = getConnection().prepareStatement(sqlRequest)) {
            prepareStatement.setInt(1, idNumde);
            prepareStatement.executeUpdate();
            ResultSet rs = prepareStatement.executeQuery(sqlRequest);
            int id = rs.getInt("id");
            String name = rs.getString("name");
            int countryId = rs.getInt("countryId");
            String countryName = rs.getString("name");
            return new Vendor(id, name, new Country(countryId, countryName));
        }
    }
}

