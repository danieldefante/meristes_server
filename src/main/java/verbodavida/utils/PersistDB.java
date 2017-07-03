package verbodavida.utils;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class PersistDB {

    public static <T> String insertEntity(T entity){
        String retorno = null;
    	Session session = null;
        Transaction transaction = null;
        try {

            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(entity);
            transaction.commit();
            retorno = "success";

        } catch (Exception e) {
            transaction.rollback();
            retorno = "error";
            System.out.println("ERROR PersistDB -> " + e);
        } finally {
            session.clear();
            session.close();
        }
		return retorno;

    }

    public static <T> List<T> findAllEntity(Class<T> clazz) {
		
    	 Session session = null;
    	 List<T> resultList = null;
    	 
    	 try {

            session = HibernateUtil.getSessionFactory().openSession();

            CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<T> criteria = builder.createQuery(clazz);
			
			Root<T> root = criteria.from(clazz);
			
			criteria.select(root);
			resultList = session.createQuery(criteria).list();

			
			//Query query = session.createQuery("from " +clazz.getName());
			//List<T> resultList = query.getResultList();
			
           
            
        }catch(Exception e){
			System.out.println("ERROR PersistDB.findAll -> " + e);
		} finally {
//			session.clear();
//			session.close();
		}
         return resultList;

	}

	public static <T> T findEntity(Class<T> clazz, Long id) {
				
		Session session = null;
		T entity = null;
        try {

            session = HibernateUtil.getSessionFactory().openSession();
            entity = session.get(clazz, id);
            
        } catch (Exception e) {
            System.out.println("ERROR PersistDB -> " + e);
        } finally {
            session.clear();
            session.close();
        }
			
	return entity;
		
	}

	public static String deleteEntity(Long id) {
		return null;
	}

	public static <T> String updateEntity(T entity) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	public static <T> T executeQuery(String sql) {

		
		Session session = null;
		T entity = null;
	  	 Transaction tx = null;
        try {

        	session = HibernateUtil.getSessionFactory().openSession();

        	   tx = session.beginTransaction();
        	   
        	Query query = session.createQuery(sql);
        	
        	entity = (T) query.getSingleResult();
            
        } catch (Exception e) {
            System.out.println("ERROR PersistDB -> " + e);
        } finally {
//            session.clear();
//            session.close();
        }
        
		return entity;
		
	}
	
	
}

//            Query query = session.createQuery("select m from Ministerio m where idMinisterio = :id");
//            query.setMaxResults(1);
//            entity = (T) query.uniqueResult();
























//
//
//
//package verbodavida.utils;
//
//import java.util.List;
//
//import javax.persistence.EntityManager;
//
//import org.hibernate.Criteria;
//import org.hibernate.Session;
//import org.hibernate.criterion.Restrictions;
//
//
//public class ConsultDB {
//
//	public static <T> List<T> findAll(Class<T> clazz) {
//		
//		EntityManager entityManager = ConnectionDB.createFactory();
//
//		Session session = (Session) entityManager.getDelegate();
//		
//		try {
//			
//			Criteria criteria = session.createCriteria(clazz);
//			List<T> resultList = criteria.list();
//			
////			CriteriaBuilder builder = entityManager.getCriteriaBuilder();
////			
////			CriteriaQuery<T> criteria = builder.createQuery(clazz);
////			
////			
////			Root<T> root = criteria.from(clazz);
////			
////			criteria.select(root);
////			
////			
////			List<T> resultList = session.createQuery(criteria).getResultList();
//
//			
//		return resultList;
//
//		} finally {
//			session.clear();
//			session.close();
//		}
//
//	}
//
//	public static <T> List<T> findAttr(Class<T> clazz, String[] nameParams, Object[] params) {
//		
//		EntityManager entityManager = ConnectionDB.createFactory();
//		
//		Session session = (Session) entityManager.getDelegate();
//		
//		try {
//			Criteria criteria = session.createCriteria(clazz);
//			
//			int i = 0;
//			for(String name : nameParams){
//				criteria.add(Restrictions.eq(name, params[i]));
//				i++;
//			}
//			
//			return criteria.list();
//			
//		} finally {
//			session.clear();
//			session.close();
//		}
//		
//	}
//	
//
//	public static <T> T find(Class<T> clazz, String value) {
//		
//		EntityManager entityManager = ConnectionDB.createFactory();
//		
//		Session session = (Session) entityManager.getDelegate();
//		
//		try {
//
//			return session.get(clazz, value);
//			
//		} finally {
//			session.clear();
//			session.close();
//		}
//		
//	}
//	
////	public static void main(String[] args) {
////		Pessoa teste = new Pessoa();
////		List<? extends Pessoa> listAll = findAll(teste.getClass());
////		
////		listAll.forEach(aa -> {
////			System.out.println(aa.getNome());
////		});
////		
////	}
////	public static void main(String[] args) {
////		
////		teste find = find(teste.class, "2");
////		
////		System.out.println(find.getNome());
////	}
//	
//}
