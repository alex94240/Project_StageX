package com.stagex.dao;

import java.beans.IntrospectionException;  
import java.beans.PropertyDescriptor;  
import java.lang.reflect.Field;  
import java.lang.reflect.InvocationTargetException;  
import java.sql.PreparedStatement;  
import java.sql.ResultSet;  
import java.sql.SQLException;  
import java.sql.Timestamp;  
import java.sql.Types;  
import java.util.ArrayList;  
import java.util.Date;  
import java.util.HashMap;  
import java.util.Iterator;  
import java.util.List;  
import java.util.Map;  
import java.util.Set;  
import java.util.Map.Entry;
import com.stagex.dbutil.*;
import com.stagex.annotation.*;
import com.stagex.bean.Student;

public class GenericDaoImpl<T> implements GenericDao<T> {
	
	private static final String TABLE_ALIAS = "t"; 

	@Override
	public void create(T t) throws Exception {
		
		Class<?> clazz = t.getClass();  
        
        String tableName = getTableName(clazz);  
        
        StringBuilder fieldNames = new StringBuilder();     
        List<Object> fieldValues = new ArrayList<Object>(); 
        StringBuilder placeholders = new StringBuilder();  
        Field[] fields = clazz.getDeclaredFields(); 
        
        for (Field field : fields) {  
            PropertyDescriptor pd = new PropertyDescriptor(field.getName(),t.getClass());  
            if (field.isAnnotationPresent(Id.class)) {  
                fieldNames.append(field.getAnnotation(Id.class).value()).append(",");  
                fieldValues.add(pd.getReadMethod().invoke(t));  
            } else if(field.isAnnotationPresent(Column.class)) {  
                fieldNames.append(field.getAnnotation(Column.class).value()).append(",");  
                fieldValues.add(pd.getReadMethod().invoke(t));  
            }  
            placeholders.append("?").append(",");  
        }  
         
        fieldNames.deleteCharAt(fieldNames.length()-1);  
        placeholders.deleteCharAt(placeholders.length()-1);  
          
         
        StringBuilder sql = new StringBuilder("");  
        sql.append("insert into ").append(tableName)  
           .append(" (").append(fieldNames.toString())  
           .append(") values (").append(placeholders).append(")") ; 
        DatabaseConnection dbConn = new DatabaseConnection();
        PreparedStatement ps = dbConn.getConnection().prepareStatement(sql.toString());  
         
        setParameter(fieldValues, ps, false);  
        
        ps.execute();  
        dbConn.close();
          
        System.out.println(sql + "\n" + clazz.getSimpleName() + "create succ");	
	}

	@Override
	public void delete(Object id, Class<T> clazz) throws Exception {

        String tableName = getTableName(clazz);  
 
        String idFieldName = "";  
        boolean flag = false;  
        Field[] fields = clazz.getDeclaredFields(); 
        
        for (Field field : fields) {  
            if(field.isAnnotationPresent(Id.class)) {  
                idFieldName = field.getAnnotation(Id.class).value();  
                flag = true;  
                break;  
            }  
        }  
        
        if (!flag) {  
            System.out.println(clazz.getName() + " object not found id property.");  
        }  
          
        String sql = "delete from " + tableName + " where " + idFieldName + "=?";
        DatabaseConnection dbConn = new DatabaseConnection();
        PreparedStatement ps = dbConn.getConnection().prepareStatement(sql);  
        ps.setObject(1, id);  
  
        ps.execute();  
        dbConn.close();  
          
        System.out.println(sql + "\n" + clazz.getSimpleName() + "delete succ");
	}

	@Override
	public void update(T t) throws Exception {
		Class<?> clazz = t.getClass();  
       
        String tableName = getTableName(clazz);  
        
        List<Object> fieldNames = new ArrayList<Object>();   
        List<Object> fieldValues = new ArrayList<Object>(); 
        List<String> placeholders = new ArrayList<String>();
        String idFieldName = "";  
        Object idFieldValue = "";  
        Field[] fields = clazz.getDeclaredFields();  
        
        
        for (Field field : fields) {  
            PropertyDescriptor pd = new PropertyDescriptor(field.getName(),t.getClass());  
            if (field.isAnnotationPresent(Id.class)) {  
                idFieldName = field.getAnnotation(Id.class).value();  
                idFieldValue = pd.getReadMethod().invoke(t);  
            } else if(field.isAnnotationPresent(Column.class)) {  
                fieldNames.add(field.getAnnotation(Column.class).value());  
                fieldValues.add(pd.getReadMethod().invoke(t));  
                placeholders.add("?");  
            }  
        }  
        
        fieldNames.add(idFieldName);  
        fieldValues.add(idFieldValue);  
        placeholders.add("?");  
          
        
        StringBuilder sql = new StringBuilder("");  
        sql.append("update ").append(tableName).append(" set ");  
        int index = fieldNames.size() - 1;  
        for (int i = 0; i < index; i++) {  
            sql.append(fieldNames.get(i)).append("=").append(placeholders.get(i)).append(",");  
        }  
        sql.deleteCharAt(sql.length()-1).append(" where ").append(fieldNames.get(index)).append("=").append("?");  
          
        
        DatabaseConnection dbConn = new DatabaseConnection();
        PreparedStatement ps = dbConn.getConnection().prepareStatement(sql.toString());  
        setParameter(fieldValues, ps, false);  
           
        ps.execute();  
        dbConn.close();  
          
        System.out.println(sql + "\n" + clazz.getSimpleName() + "update succ"); 
	}

	@Override
	public T find(Object id, Class<T> clazz) throws Exception {
		String idFieldName = "";  
        Field[] fields = clazz.getDeclaredFields();  
        boolean flag = false;  
        for (Field field : fields) {  
            if (field.isAnnotationPresent(Id.class)) {  
                idFieldName = field.getAnnotation(Id.class).value();  
                flag = true;  
                break;  
            }   
        }  
          
        if (!flag) {  
           System.out.println(clazz.getName() + " object not found id property.");  
        }  
            
        Map<String,Object> sqlWhereMap = new HashMap<String, Object>();  
        sqlWhereMap.put(TABLE_ALIAS + "." + idFieldName, id);  
          
        List<T> list = findAllByConditions(sqlWhereMap, clazz);  
        return list.size() > 0 ? list.get(0) : null; 
	}

	@Override
	public List<T> findAllByConditions(Map<String, Object> sqlWhereMap, Class<T> clazz) throws Exception {
		List<T> list = new ArrayList<T>();  
        String tableName = getTableName(clazz);  
        String idFieldName = "";  
        
        StringBuffer fieldNames = new StringBuffer();  
        Field[] fields = clazz.getDeclaredFields();  
        
        for (Field field : fields) {  
            String propertyName = field.getName();  
            if (field.isAnnotationPresent(Id.class)) {  
                idFieldName = field.getAnnotation(Id.class).value();  
                fieldNames.append(TABLE_ALIAS + "." + idFieldName)  
                          .append(" as ").append(propertyName).append(",");  
            } else if (field.isAnnotationPresent(Column.class)) {  
                fieldNames.append(TABLE_ALIAS + "." + field.getAnnotation(Column.class).value())  
                          .append(" as ").append(propertyName).append(",");  
            }  
        }  
        fieldNames.deleteCharAt(fieldNames.length()-1);  
          
        
        String sql = "select " + fieldNames + " from " + tableName + " " + TABLE_ALIAS;  
        PreparedStatement ps = null;  
        List<Object> values = null;  
        if (sqlWhereMap != null) {  
            List<Object> sqlWhereWithValues = getSqlWhereWithValues(sqlWhereMap);  
            if (sqlWhereWithValues != null) {  
                
                String sqlWhere = (String)sqlWhereWithValues.get(0);  
                sql += sqlWhere;  
                
                values = (List<Object>) sqlWhereWithValues.get(1);  
            }  
        }   
          

        DatabaseConnection dbConn = new DatabaseConnection();
        if (values != null) {  
            ps = dbConn.getConnection().prepareStatement(sql);  
            setParameter(values, ps, true);  
        } else {  
            ps = dbConn.getConnection().prepareStatement(sql);  
        }  
          
 
        ResultSet rs = ps.executeQuery();  
        while(rs.next()) {  
            T t = clazz.newInstance();  
            initObject(t, fields, rs);  
            list.add(t);  
        }  

        dbConn.close();  
          
        System.out.println(sql);  
        return list; 
	}

	
	public int createReturnId(T t) throws Exception {
		Class<?> clazz = t.getClass();

		String tableName = getTableName(clazz);
		Map<String,Object> sqlWhereMap = new HashMap<String, Object>();

		StringBuilder fieldNames = new StringBuilder();
		List<Object> fieldValues = new ArrayList<Object>();
		StringBuilder placeholders = new StringBuilder();
		Field[] fields = clazz.getDeclaredFields();

		for (Field field : fields) {
			PropertyDescriptor pd = new PropertyDescriptor(field.getName(), t.getClass());
			if (field.isAnnotationPresent(Id.class)) {
				fieldNames.append(field.getAnnotation(Id.class).value()).append(",");  
                fieldValues.add(pd.getReadMethod().invoke(t));
			} else if (field.isAnnotationPresent(Column.class)) {
				fieldNames.append(field.getAnnotation(Column.class).value()).append(",");
				fieldValues.add(pd.getReadMethod().invoke(t));
				sqlWhereMap.put(field.getAnnotation(Column.class).value(), pd.getReadMethod().invoke(t));
			}
			placeholders.append("?").append(",");
		}

		fieldNames.deleteCharAt(fieldNames.length() - 1);
		placeholders.deleteCharAt(placeholders.length() - 1);

		StringBuilder sql = new StringBuilder("");
		sql.append("insert into ").append(tableName).append(" (").append(fieldNames.toString()).append(") values (")
				.append(placeholders).append(")");
		DatabaseConnection dbConn = new DatabaseConnection();
		PreparedStatement ps = dbConn.getConnection().prepareStatement(sql.toString());

		setParameter(fieldValues, ps, false);

		ps.execute();
		dbConn.close();
		
		int id = -1;
		List<T> list = new ArrayList<T>(); 
        String idFieldName = "";  
         
        
        for (Field field : fields) {  
            String propertyName = field.getName();  
            if (field.isAnnotationPresent(Id.class)) {  
                idFieldName = field.getAnnotation(Id.class).value();  
                fieldNames.append(TABLE_ALIAS + "." + idFieldName)  
                          .append(" as ").append(propertyName).append(",");  
            } else if (field.isAnnotationPresent(Column.class)) {  
                fieldNames.append(TABLE_ALIAS + "." + field.getAnnotation(Column.class).value())  
                          .append(" as ").append(propertyName).append(",");  
            }  
        }  
        fieldNames.deleteCharAt(fieldNames.length()-1);  
          
        
        String sql1 = "select " + idFieldName + " from " + tableName + " " + TABLE_ALIAS;  
        PreparedStatement ps1 = null;  
        List<Object> values = null;  
        if (sqlWhereMap != null) {  
            List<Object> sqlWhereWithValues = getSqlWhereWithValues(sqlWhereMap);  
            if (sqlWhereWithValues != null) {  
                
                String sqlWhere = (String)sqlWhereWithValues.get(0);  
                sql1 += sqlWhere;  
                
                values = (List<Object>) sqlWhereWithValues.get(1);  
            }  
        }   
          

        DatabaseConnection dbConn1 = new DatabaseConnection();
        if (values != null) {  
            ps1 = dbConn1.getConnection().prepareStatement(sql1);  
            setParameter(values, ps1, true);  
        } else {  
            ps1 = dbConn1.getConnection().prepareStatement(sql1);  
        }  
          
 
        ResultSet rs = ps1.executeQuery();  
        if(rs.next()){
        	id = rs.getInt(1);
        }

        dbConn1.close(); 

        System.out.println(sql1);		
		
		System.out.println(sql1 + "\n" + clazz.getSimpleName() + "create without Id succ");
		
		System.out.println("\n ID is " + id);

		return id;
	}
	
	
	
	//private methods
	
	private void initObject(T t, Field[] fields, ResultSet rs)  
            throws SQLException, IntrospectionException,  
            IllegalAccessException, InvocationTargetException {  
        for (Field field : fields) {  
            String propertyName = field.getName();  
            Object paramVal = null;  
            Class<?> clazzField = field.getType();  
            if (clazzField == String.class) {  
                paramVal = rs.getString(propertyName);  
            } else if (clazzField == short.class || clazzField == Short.class) {  
                paramVal = rs.getShort(propertyName);  
            } else if (clazzField == int.class || clazzField == Integer.class) {  
                paramVal = rs.getInt(propertyName);  
            } else if (clazzField == long.class || clazzField == Long.class) {  
                paramVal = rs.getLong(propertyName);  
            } else if (clazzField == float.class || clazzField == Float.class) {  
                paramVal = rs.getFloat(propertyName);  
            } else if (clazzField == double.class || clazzField == Double.class) {  
                paramVal = rs.getDouble(propertyName);  
            } else if (clazzField == boolean.class || clazzField == Boolean.class) {  
                paramVal = rs.getBoolean(propertyName);  
            } else if (clazzField == byte.class || clazzField == Byte.class) {  
                paramVal = rs.getByte(propertyName);  
            } else if (clazzField == char.class || clazzField == Character.class) {  
                paramVal = rs.getCharacterStream(propertyName);  
            } else if (clazzField == Date.class) {  
                paramVal = rs.getTimestamp(propertyName);  
            } else if (clazzField.isArray()) {  
                paramVal = rs.getString(propertyName).split(",");   //ÒÔ¶ººÅ·Ö¸ôµÄ×Ö·û´®  
            }   
            PropertyDescriptor pd = new PropertyDescriptor(propertyName,t.getClass());  
            pd.getWriteMethod().invoke(t, paramVal);  
        }  
    }  
      
    
	
    private List<Object> getSqlWhereWithValues(Map<String,Object> sqlWhereMap) {  
        if (sqlWhereMap.size() <1 ) return null;  
        List<Object> list = new ArrayList<Object>();  
        List<Object> fieldValues = new ArrayList<Object>();  
        StringBuffer sqlWhere = new StringBuffer(" where ");  
        Set<Entry<String, Object>> entrySets = sqlWhereMap.entrySet();  
        for (Iterator<Entry<String, Object>> iteraotr = entrySets.iterator();iteraotr.hasNext();) {  
            Entry<String, Object> entrySet = iteraotr.next();  
            fieldValues.add(entrySet.getValue());  
            Object value = entrySet.getValue();  
            if (value.getClass() == String.class) {  
                sqlWhere.append(entrySet.getKey()).append(" like ").append("?").append(" and ");  
            } else {  
                sqlWhere.append(entrySet.getKey()).append("=").append("?").append(" and ");  
            }  
        }  
        sqlWhere.delete(sqlWhere.lastIndexOf("and"), sqlWhere.length());  
        list.add(sqlWhere.toString());  
        list.add(fieldValues);  
        return list;  
    }  
      
      
    
    private String getTableName(Class<?> clazz){  
        if (clazz.isAnnotationPresent(Entity.class)) {  
            Entity entity = clazz.getAnnotation(Entity.class);  
            return entity.value();  
        } else {  
            System.out.println(clazz.getName() + " is not Entity Annotation.");
            return null;
        }  
    }  
      
    
    
    private void setParameter(List<Object> values, PreparedStatement ps, boolean isSearch)  
            throws SQLException {  
        for (int i = 1; i <= values.size(); i++) {  
            Object fieldValue = values.get(i-1);  
            Class<?> clazzValue = fieldValue.getClass();  
            if (clazzValue == String.class) {  
                if (isSearch)   
                    ps.setString(i, "%" + (String)fieldValue + "%");  
                else  
                    ps.setString(i,(String)fieldValue);  
                      
            } else if (clazzValue == boolean.class || clazzValue == Boolean.class) {  
                ps.setBoolean(i, (Boolean)fieldValue);  
            } else if (clazzValue == byte.class || clazzValue == Byte.class) {  
                ps.setByte(i, (Byte)fieldValue);  
            } else if (clazzValue == char.class || clazzValue == Character.class) {  
                ps.setObject(i, fieldValue,Types.CHAR);  
            } else if (clazzValue == Date.class) {  
                ps.setTimestamp(i, new Timestamp(((Date) fieldValue).getTime()));  
            } else if (clazzValue.isArray()) {  
                Object[] arrayValue = (Object[]) fieldValue;  
                StringBuffer sb = new StringBuffer();  
                for (int j = 0; j < arrayValue.length; j++) {  
                    sb.append(arrayValue[j]).append("¡¢");  
                }  
                ps.setString(i, sb.deleteCharAt(sb.length()-1).toString());  
            } else {  
                ps.setObject(i, fieldValue, Types.NUMERIC);  
            }  
        }  
    }  


}
