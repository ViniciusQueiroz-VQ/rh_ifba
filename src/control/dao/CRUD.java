package control.dao;

import java.util.ArrayList;

public interface CRUD {

    public void create(Object o);
    
    public ArrayList readAll();

    public Object findByPrimaryKey(Object pk);
    
    public void update(Object o);

    public void delete(Object o);

}
