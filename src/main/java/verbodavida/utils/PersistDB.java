package verbodavida.utils;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.hibernate.transform.Transformers;

public class PersistDB {

    public static <T> Long insertEntity(T entity){
        Long retorno = null;
    	Session session = null;
        Transaction transaction = null;
        try {

            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            retorno = (Long) session.save(entity);
            transaction.commit();

        } catch (Exception e) {
            transaction.rollback();
            System.out.println("ERROR PersistDB -> " + e);
        } finally {
            session.clear();
            session.close();
        }
		return retorno;

    }

    public static <T> Boolean insertListEntitys(List<T> listEntitys){
    	Boolean retorno = null;
    	Session session = null;
    	Transaction transaction = null;
    	try {
    		
    		session = HibernateUtil.getSessionFactory().openSession();
    		transaction = session.beginTransaction();
    		
    		for(T entity : listEntitys) {
    			session.save(entity);    			
    		}
    		
    		transaction.commit();
    		retorno = true;
    		
    	} catch (Exception e) {
    		transaction.rollback();
    		retorno = false;
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

	
	public static Boolean deleteEntity(Long id) {
		return null;
	}

	
	public static <T> Boolean updateEntity(T entity) {
		Boolean retorno = null;
	    	Session session = null;
	        Transaction transaction = null;
	        try {

	            session = HibernateUtil.getSessionFactory().openSession();
	            transaction = session.beginTransaction();
	            session.update(entity);
	            transaction.commit();
	            retorno = true;

	        } catch (Exception e) {
	            transaction.rollback();
	            retorno = false;
	            System.out.println("ERROR PersistDB -> " + e);
	        } finally {
	            session.clear();
	            session.close();
	        }
			return retorno;
	}	
	
	
	public static <T> Boolean updateListEntitys(List<T> listEntitys){
		Boolean retorno = null;
    	Session session = null;
    	Transaction transaction = null;
    	try {
    		
    		session = HibernateUtil.getSessionFactory().openSession();
    		transaction = session.beginTransaction();
    		
    		for(T entity : listEntitys) {
    			session.update(entity);    			
    		}
    		
    		transaction.commit();
    		retorno = true;
    		
    	} catch (Exception e) {
    		transaction.rollback();
    		retorno = false;
    		System.out.println("ERROR PersistDB -> " + e);
    	} finally {
    		session.clear();
    		session.close();
    	}
    	return retorno;
    	
    }
	
	
	
	

	public static <T> List<T> executeHQL(Class<T> clazz, BeanConsultGroup beanConsultGroup, String sql, List<String> nameParams, List<Object> valueParam) {
		
		Session session = null;
		List<T> list = null;
        try {

            session = HibernateUtil.getSessionFactory().openSession();
            
            Query<T> query = session.createQuery(sql, clazz);
            
            if (nameParams != null) {
            
            	int sizeListParams = nameParams.size();
				for (int i = 0; i < sizeListParams; i++) {
					
					query.setParameter(nameParams.get(i), valueParam.get(i));
				}
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
	
//	public static <T> List<T> executeSQL(String sql, List<String> nameParams, List<Object> valueParam) {
//		
//		Session session = null;
//		List<T> list = null;
//        try {
//
//            session = HibernateUtil.getSessionFactory().openSession();
//            
//            Query query = session.createNativeQuery(sql);
//            
//            if (nameParams != null) {
//            
//            	int sizeListParams = nameParams.size();
//				for (int i = 0; i < sizeListParams; i++) {
//					
//					query.setParameter(nameParams.get(i), valueParam.get(i));
//				}
//            }
//
//            list = query.list();
//
//        } catch (Exception e) {
//            System.out.println("ERROR PersistDB -> " + e);
//        } finally {
//            session.clear();
//            session.close();
//        }
//		
//		return list;
//	}


	@SuppressWarnings("deprecation")
	public static <T> T executeSQLOneResult(String sql) {	
		
		Session session = null;
		T result = null;
		try {
			
			session = HibernateUtil.getSessionFactory().openSession();
			
			@SuppressWarnings("unchecked")
			Query<T> query = session.createSQLQuery(sql);
			
			result = query.uniqueResult();
			
		} catch (Exception e) {
			System.out.println("ERROR PersistDB -> " + e);
		} finally {
			session.clear();
			session.close();
		}
		
		return result;
	}
	
	@SuppressWarnings("deprecation")
	public static <T> T executeSQLOneResult(Class<T> clazz, String sql) {	
		
		Session session = null;
		T result = null;
		try {
			
			session = HibernateUtil.getSessionFactory().openSession();
			
			@SuppressWarnings("unchecked")
			Query<T> query = session.createSQLQuery(sql).setResultTransformer( Transformers.aliasToBean(clazz));
			
			result = query.setResultTransformer(Transformers.aliasToBean(clazz)).uniqueResult();
			
		} catch (Exception e) {
			System.out.println("ERROR PersistDB -> " + e);
		} finally {
			session.clear();
			session.close();
		}
		
		return result;
	}
	
	@SuppressWarnings("deprecation")
	public static <T> List<T> executeSQL( BeanConsultGroup beanConsultGroup, String sql) {	
		
		Session session = null;
		List<T> list = null;
		try {
			
			session = HibernateUtil.getSessionFactory().openSession();
			
			@SuppressWarnings("unchecked")
			Query<T> query = session.createSQLQuery(sql);
			
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
	
	@SuppressWarnings("deprecation")
	public static <T> List<T> executeSQL(Class<T> clazz, BeanConsultGroup beanConsultGroup, String sql) {	
		
		Session session = null;
		List<T> list = null;
		try {
			
			session = HibernateUtil.getSessionFactory().openSession();
			
			@SuppressWarnings("unchecked")
			Query<T> query = session.createSQLQuery(sql).setResultTransformer( Transformers.aliasToBean(clazz));
			
			if (beanConsultGroup != null) {
				query.setFirstResult(beanConsultGroup.getPageResolver());
				query.setMaxResults(beanConsultGroup.getSize());
			}
			
			list = query.setResultTransformer(Transformers.aliasToBean(clazz)).list();
			
		} catch (Exception e) {
			System.out.println("ERROR PersistDB -> " + e);
		} finally {
			session.clear();
			session.close();
		}
		
		return list;
	}
	
	@SuppressWarnings("deprecation")
	public static <T> T executeSQLOneResult(Class<T> clazz, String sql, List<String> nameParams, List<Object> valueParam) {	
		
		Session session = null;
		T result = null;
		try {
			
			session = HibernateUtil.getSessionFactory().openSession();
			
			@SuppressWarnings("unchecked")
			Query<T> query = session.createSQLQuery(sql).setResultTransformer( Transformers.aliasToBean(clazz));
			
			if (nameParams != null) {
				
				int sizeListParams = nameParams.size();
				for (int i = 0; i < sizeListParams; i++) {
					
					query.setParameter(nameParams.get(i), valueParam.get(i));
				}
			}
			
			result = query.setResultTransformer(Transformers.aliasToBean(clazz)).uniqueResult();
			
		} catch (Exception e) {
			System.out.println("ERROR PersistDB -> " + e);
		} finally {
			session.clear();
			session.close();
		}
		
		return result;
	}

	@SuppressWarnings("deprecation")
	public static <T> T executeSQLOneResult(String sql, List<String> nameParams, List<Object> valueParam) {	
		
		Session session = null;
		T result = null;
		try {
			
			session = HibernateUtil.getSessionFactory().openSession();
			
			@SuppressWarnings("unchecked")
			Query<T> query = session.createSQLQuery(sql);
			
			if (nameParams != null) {
				
				int sizeListParams = nameParams.size();
				for (int i = 0; i < sizeListParams; i++) {
					
					query.setParameter(nameParams.get(i), valueParam.get(i));
				}
			}
			
			result = query.uniqueResult();
			
		} catch (Exception e) {
			System.out.println("ERROR PersistDB -> " + e);
		} finally {
			session.clear();
			session.close();
		}
		
		return result;
	}
	
	@SuppressWarnings("deprecation")
	public static <T> List<T> executeSQL(Class<T> clazz, BeanConsultGroup beanConsultGroup, String sql, List<String> nameParams, List<Object> valueParam) {	
		
		Session session = null;
		List<T> list = null;
        try {
        	
            session = HibernateUtil.getSessionFactory().openSession();
            
            @SuppressWarnings("unchecked")
			Query<T> query = session.createSQLQuery(sql).setResultTransformer( Transformers.aliasToBean(clazz));
            
            if (nameParams != null) {
            
            	int sizeListParams = nameParams.size();
				for (int i = 0; i < sizeListParams; i++) {
					
					query.setParameter(nameParams.get(i), valueParam.get(i));
				}
            }

			if (beanConsultGroup != null) {
				query.setFirstResult(beanConsultGroup.getPageResolver());
				query.setMaxResults(beanConsultGroup.getSize());
			}		
				
			list = query.setResultTransformer(Transformers.aliasToBean(clazz)).list();

        } catch (Exception e) {
            System.out.println("ERROR PersistDB -> " + e);
        } finally {
            session.clear();
            session.close();
        }
		
		return list;
	}

//	public static <T> T executeSQLOneResult (String sql, List<String> nameParams, List<Object> valueParam) {
//		
//		Session session = null;
//		T result = null;
//		
//		try {
//			
//			session = HibernateUtil.getSessionFactory().openSession();
//			
//			Query query = session.createNativeQuery(sql);
//			
//			if (nameParams != null) {
//				
//				int sizeListParams = nameParams.size();
//				for (int i = 0; i < sizeListParams; i++) {
//					
//					query.setParameter(nameParams.get(i), valueParam.get(i));
//				}
//			}
//			
//			result = (T) query.uniqueResult();
//			
//		} catch (Exception e) {
//			System.out.println("ERROR PersistDB -> " + e);
//		} finally {
//			session.clear();
//			session.close();
//		}
//		
//		return result;
//	}
	
	

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
	
	public static <T> T executeHQLOneResult(String sql, List<String> namesParamList, List<Object> valuesParamList) {
		
		Session session = null;
		T respost = null;
		try {
			
			session = HibernateUtil.getSessionFactory().openSession();
			
			Query<?> query = session.createQuery(sql);
			
			if(namesParamList != null){
				
				int sizeListParams = namesParamList.size();
				
				for (int i = 0; i < sizeListParams; i++) {
					
					query.setParameter(namesParamList.get(i), valuesParamList.get(i));
				}
			}
			
			respost = (T) query.uniqueResult();
			
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