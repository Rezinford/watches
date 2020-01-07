package dao;

import models.Country;
import models.Vendor;
import models.watch.Watch;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static db.dbConnect.getConnection;
import static models.watch.WatchType.ANALOG;

public class WatchDAO implements DAO<models.watch.Watch> {
    final String table = "score.watch";
    @Override
    public void create(Watch model) {
        final String sqlRequest = "insert into " + table + " (type, price, quantity, vendorid) values (?, ?, ?, ?)";
        try (final PreparedStatement ps
                     = getConnection().prepareStatement(sqlRequest, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, model.getType().ForType());
            ps.setBigDecimal(2, model.getPrice());
            ps.setInt(3, model.getQuantity());
            ps.setInt(4, model.getVendor().getId());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Watch model) {
        final String sqlRequest = "insert into " + table +
                                    " (type, price, quantity, vendorid) " +
                                    "values (?, ?, ?, ?)" +
                                    "where id = ?";
        try (final PreparedStatement ps
                     = getConnection().prepareStatement(sqlRequest, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, model.getType().ForType());
            ps.setBigDecimal(2, model.getPrice());
            ps.setInt(3, model.getQuantity());
            ps.setInt(4, model.getVendor().getId());
            ps.setInt(5, model.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        final String sqlRequest = "delete from " + table + " where id = ?";
        try(final PreparedStatement ps = getConnection().prepareStatement(sqlRequest)){
            ps.setInt(1, id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Watch> getAll() throws SQLException {
        List<Watch> watchesTemp = new ArrayList<>();
        final String sqlRequest = "select*from " + table +
                                    " left join watches.score.vendor " +
                                    "ON watches.score.watch.vendorid = watches.score.vendor.id" +
                                    " left join watches.score.country " +
                                    "ON watches.score.vendor.countryId=watches.score.country.id";
        try(final Statement ps = getConnection().createStatement()){
            ResultSet rs =ps.executeQuery(sqlRequest);
            while (rs.next()){
               int watchId =  rs.getInt("id");
               String type = rs.getString("type");
                BigDecimal price = rs.getBigDecimal("prise");
                int qty = rs.getInt("quality");
                int vendorId = rs.getInt("id");
                String vendorName = rs.getString("name");
                int countryId = rs.getInt("id");
                String countryName = rs.getString("name");
                watchesTemp.add(new Watch(watchId, ANALOG, price,qty, new Vendor(vendorId,vendorName,new Country(countryId, countryName))));
            }
        }
        return watchesTemp;
    }

    @Override
    public Watch getById(int id) {
        final String sqlRequest = "select*from " + table +
                " left join watches.score.vendor " +
                "ON watches.score.watch.vendorid = watches.score.vendor.id" +
                " left join watches.score.country " +
                "ON watches.score.vendor.countryId=watches.score.country.id" +
                " where watches.score.watch.id = ?";
        try (final PreparedStatement ps = getConnection().prepareStatement(sqlRequest)) {
            ResultSet rs = ps.executeQuery(sqlRequest);
            int watchId = rs.getInt("id");
            String type = rs.getString("type");
            BigDecimal price = rs.getBigDecimal("prise");
            int qty = rs.getInt("quality");
            int vendorId = rs.getInt("id");
            String vendorName = rs.getString("name");
            int countryId = rs.getInt("id");
            String countryName = rs.getString("name");
            return new Watch(watchId, ANALOG, price, qty, new Vendor(vendorId, vendorName, new Country(countryId, countryName)));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
