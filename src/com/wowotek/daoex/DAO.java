
package com.wowotek.daoex;

import java.util.List;

public interface DAO<T> {
    List<T> getAllData();
    
    boolean addData(T t);
    boolean removeData(T t);
    boolean removeData(int id);
    boolean updateData(int id, T t);
    
}
