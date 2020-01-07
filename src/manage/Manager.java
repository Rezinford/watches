package manage;


import java.util.List;

public interface Manager<T> {
    void create(T model);
    void update(T model);
    void delete(int id);
    List<T> getAll() ;
}
