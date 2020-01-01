package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public interface DAO<T> {
    void create(T model);
    void update(T model);
    void delete(int id);
    List<T> getAll() throws SQLException;
    T getById(int id) throws SQLException;

}
