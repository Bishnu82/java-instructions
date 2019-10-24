package ui;

import java.util.List;

public interface DAO<T> {
    T get(String userName);
    List<T> getAll();
    boolean add(T t);
    boolean update(T t);
    boolean delete(T t);
}