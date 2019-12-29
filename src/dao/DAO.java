package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public interface DAO<T> {
    T create(T model);
    boolean update(T model);
    boolean delete(int id);
    List<T> getAll();
    T getById(int id);

}
