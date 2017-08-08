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

    public static <T> String insertListEntitys(List<T> listEntitys){
    	String retorno = null;
    	Session session = null;
    	Transaction transaction = null;
    	try {
    		
    		session = HibernateUtil.getSessionFactory().openSession();
    		transaction = session.beginTransaction();
    		
    		for(T entity : listEntitys) {
    			session.save(entity);    			
    		}
    		
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

    public static <T> List<T> findAllEntity(Class<T> clazz, BeanConsultGroup beanConsultGroup) {

		 Session session = null;
		 List<T> resultList = null;
		 
		 try {
		
	        session = HibernateUtil.getSessionFactory().openSession();
	
	        CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<T> criteria = builder.createQuery(clazz);
			
			Root<T> root = criteria.from(clazz);
			
			criteria.select(root);
			
			Query<T> query = session.createQuery(criteria);

			query.setFirstResult(beanConsultGroup.getPageResolver());
			query.setMaxResults(beanConsultGroup.getSize());
			resultList = query.list();
	
		      
		   }catch(Exception e){
				System.out.println("ERROR PersistDB.findAll -> " + e);
		} finally {
			session.clear();
			session.close();
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
		 String retorno = null;
	    	Session session = null;
	        Transaction transaction = null;
	        try {

	            session = HibernateUtil.getSessionFactory().openSession();
	            transaction = session.beginTransaction();
	            session.update(entity);
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

	public static <T> List<T> executeHQL(BeanConsultGroup beanConsultGroup, String sql, List<String> nameParams, List<Object> valueParam) {
		
		Session session = null;
		List<T> list = null;
        try {

            session = HibernateUtil.getSessionFactory().openSession();
            
            Query<T> query = session.createQuery(sql);
            
            int sizeListParams = nameParams.size();
            
			for (int i = 0; i < sizeListParams; i++) {
				
				query.setParameter(nameParams.get(i), valueParam.get(i));
			}
            
			if (beanConsultGroup != null) {
				query.setFirstResult(beanConsultGroup.getPageResolver());
				query.setMaxResults(beanConsultGroup.getSize());
			}

			list = query.list();

        } catch (Exception e) {
            System.out.println("ERROR PersistDB -> " + e);
        } finally {
            session.clear();
            session.close();
        }
		
		return list;
	}

//	public static <T> T executeHQLOneResult(String sql, List<String> nameParams, List<Object> valueParam) {
//		
//		Session session = null;
//		T entity = null;
//		try {
//			
//			session = HibernateUtil.getSessionFactory().openSession();
//			
//			Query<T> query = session.createQuery(sql);
//			
//			int sizeListParams = nameParams.size();
//			
//			for (int i = 0; i < sizeListParams; i++) {
//				
//				query.setParameter(nameParams.get(i), valueParam.get(i));
//			}
//			
//			entity = query.uniqueResult();
//			
//		} catch (Exception e) {
//			System.out.println("ERROR PersistDB -> " + e);
//		} finally {
//			session.clear();
//			session.close();
//		}
//		
//		return entity;
//	}
	
	public static Object executeHQLOneResult(String sql, List<String> namesParamList, List<Object> valuesParamList) {
		
		Session session = null;
		Object respost = null;
		try {
			
			session = HibernateUtil.getSessionFactory().openSession();
			
			Query<?> query = session.createQuery(sql);
			
			if(namesParamList != null){
				
				int sizeListParams = namesParamList.size();
				
				for (int i = 0; i < sizeListParams; i++) {
					
					query.setParameter(namesParamList.get(i), valuesParamList.get(i));
				}
			}
			
			respost = query.uniqueResult();
			
		} catch (Exception e) {
			System.out.println("ERROR PersistDB -> " + e);
		} finally {
			session.clear();
			session.close();
		}
		
		return respost;
	}

	
}


//cascade = {CascadeType.ALL}