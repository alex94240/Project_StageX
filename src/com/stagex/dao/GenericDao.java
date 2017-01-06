package com.stagex.dao;

import java.util.List;
import java.util.Map;

public interface GenericDao <T> {
	public void create(T t) throws Exception;  
    
    public void delete(Object id,Class<T> clazz) throws Exception;  
      
    public void update(T t) throws Exception;  
      
    public T find(Object id,Class<T> clazz) throws Exception;  
       
    public List<T> findAllByConditions(Map<String,Object> sqlWhereMap,Class<T> clazz) throws Exception; 

}
