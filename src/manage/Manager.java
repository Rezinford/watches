package manage;


import java.util.List;

public interface Manager<T> {
    boolean create(T model);
    boolean update(T model);
    boolean delete(int id);
    List<T> getAll() ;
}
