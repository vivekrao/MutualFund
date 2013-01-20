package dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateBaseDao {

	private final SessionFactory sessionFactory = buildSessionFactory();

	private SessionFactory buildSessionFactory() {
		try {
			return new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public SessionFactory getSessionFactory() {
    	return sessionFactory;
    }
	
	public boolean save(Object obj){  
        Session session = null;  
        Transaction trans = null;  
        try{  
            session = getSessionFactory().openSession();  
            trans = session.beginTransaction();  
            session.save(obj);  
            trans.commit();  
            return true;  
        }catch(HibernateException e){  
            if(null != trans)  
                trans.rollback();  
            e.printStackTrace();  
        }finally{  
            if(null != session)  
                session.close();  
        }  
        return false;  
    }  
      
    public boolean delete(Object obj){  
        Session session = null;  
        Transaction trans = null;  
        try{  
            session = getSessionFactory().openSession();  
            trans = session.beginTransaction();  
            session.delete(obj);  
            trans.commit();  
            return true;  
        }catch(HibernateException e){  
            if(null != trans)  
                trans.rollback();  
            e.printStackTrace();  
        }finally{  
            if(null != session)  
                session.close();  
        }  
        return false;  
    }  
      
    public boolean update(Object obj){  
        Session session = null;  
        Transaction trans = null;  
        try{  
            session = getSessionFactory().openSession();  
            trans = session.beginTransaction();  
            session.update(obj);  
            trans.commit();  
            return true;  
        }catch(HibernateException e){  
            if(null != trans)  
                trans.rollback();  
            e.printStackTrace();  
        }finally{  
            if(null != session)  
                session.close();  
        }  
        return false;  
    }
    
    @SuppressWarnings("unchecked")
	public List<Object> findByHQL(String hql){  
        Session session = null;  
        Transaction trans = null;  
        try{  
            session = getSessionFactory().openSession();  
            trans = session.beginTransaction(); 
            Query query = session.createQuery(hql);
            List<Object> result = query.list();  
            trans.commit();  
            return result;  
        }catch(HibernateException e){  
            if(null != trans)  
                trans.rollback();  
            e.printStackTrace();  
        }finally{  
            if(null != session)  
                session.close();  
        }  
        return null;  
    }
    
    @SuppressWarnings("rawtypes")  
    public Object get(Class clazz,Serializable id){  
        Session session = null;  
        Object obj = null;  
        try{  
            session = getSessionFactory().openSession();  
            obj = session.get(clazz,id);  
        }catch(HibernateException e){  
            e.printStackTrace();  
        }finally{  
            if(null != session)  
                session.close();  
        }  
        return obj;  
    }
}
