package manager;

import java.util.List;

public interface IManager<T> {
    void add(T t);
    void update(int id, T t);
    void delete(String Phone);
    List<T> getAll();
    int findIndexByPhone(String phone);
    int findIndexById(int id);
}
