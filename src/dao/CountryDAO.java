package dao;

import models.Country;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import static db.dbConnect.getConnection;


public class CountryDAO implements DAO<Country> {
    final String table = "score.country";
    @Override
    public Country create(Country country) {
        final String operator = "insert into";
        final String parameter =  "(name)";
        final String values = "values (?)";
        final String verification =  "returning *";
        final String sql =  operator +" "+ table +" "+ parameter +" "+ values +" "+ verification +" "+ ";";
        try (final PreparedStatement prepareStatement
                     = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            prepareStatement.setString(1,country.getName());
            prepareStatement.execute();
            ResultSet rs = prepareStatement.getGeneratedKeys();
            rs.next();
            return new Country(rs.getInt("id"), rs.getString("name"));

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return null;
    }

    @Override
    public boolean update(Country model) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public List<Country> getAll() {
        return null;
    }

    @Override
    public Country getById(int id) {
        return null;
    }
}
