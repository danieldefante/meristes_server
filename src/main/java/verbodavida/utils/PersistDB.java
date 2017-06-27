package verbodavida.utils;

import javax.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class PersistDB {

    public static <T> void persistDB(T entity) throws Exception {
        Session session = null;
        Transaction transaction = null;
        try {

            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(entity);
            transaction.commit();

        } catch (Exception e) {
            transaction.rollback();
            throw e;
        } finally {
            session.clear();
            session.close();
        }

    }

}