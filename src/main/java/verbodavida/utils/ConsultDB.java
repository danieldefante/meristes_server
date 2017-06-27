package verbodavida.utils;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;


public class ConsultDB {

	public static <T> List<T> findAll(Class<T> clazz) {
		
		EntityManager entityManager = ConnectionDB.createFactory();

		Session session = (Session) entityManager.getDelegate();
		
		try {
			
			Criteria criteria = session.createCriteria(clazz);
			List<T> resultList = criteria.list();
			
//			CriteriaBuilder builder = entityManager.getCriteriaBuilder();
//			
//			CriteriaQuery<T> criteria = builder.createQuery(clazz);
//			
//			
//			Root<T> root = criteria.from(clazz);
//			
//			criteria.select(root);
//			
//			
//			List<T> resultList = session.createQuery(criteria).getResultList();

			
		return resultList;

		} finally {
			session.clear();
			session.close();
		}

	}

	public static <T> List<T> findAttr(Class<T> clazz, String[] nameParams, Object[] params) {
		
		EntityManager entityManager = ConnectionDB.createFactory();
		
		Session session = (Session) entityManager.getDelegate();
		
		try {
			Criteria criteria = session.createCriteria(clazz);
			
			int i = 0;
			for(String name : nameParams){
				criteria.add(Restrictions.eq(name, params[i]));
				i++;
			}
			
			return criteria.list();
			
		} finally {
			session.clear();
			session.close();
		}
		
	}
	

	public static <T> T find(Class<T> clazz, String value) {
		
		EntityManager entityManager = ConnectionDB.createFactory();
		
		Session session = (Session) entityManager.getDelegate();
		
		try {

			return session.get(clazz, value);
			
		} finally {
			session.clear();
			session.close();
		}
		
	}
	
//	public static void main(String[] args) {
//		Pessoa teste = new Pessoa();
//		List<? extends Pessoa> listAll = findAll(teste.getClass());
//		
//		listAll.forEach(aa -> {
//			System.out.println(aa.getNome());
//		});
//		
//	}
//	public static void main(String[] args) {
//		
//		teste find = find(teste.class, "2");
//		
//		System.out.println(find.getNome());
//	}
	
}
