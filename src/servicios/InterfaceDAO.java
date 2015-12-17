package servicios;

import java.util.List;

public interface InterfaceDAO<T> {
    public void insert(T t);
    public void update(T t);
    public void eliminar(Object id);
    public List<T> findAll();
    public T find(Object id);
    public List<T> findByQuery(T t);
}
