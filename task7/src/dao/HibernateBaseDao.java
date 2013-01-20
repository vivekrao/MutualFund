package dao;

import java.io.Serializable;
import java.util.List;

public interface HibernateBaseDao {
	public boolean save(Object obj);
	public boolean delete(Object obj);
	public boolean update(Object obj);
	public List<Object> findByHQL(String hql);
	@SuppressWarnings("rawtypes")
	public Object get(Class clazz,Serializable id);
}
