/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package verbodavida.utils;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


/**
 *
 * @author daniel
 */
public class FactoryGeneric {

    
    public static <T> String insertDB(T... entitys) {
        
//
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            
            Transaction transaction = session.beginTransaction();

            for(T entity : entitys){
                
                session.save(entity);
            }
      
            transaction.commit();
            return "success";
        } catch (Exception e) {
            
            if(session.getTransaction() != null){
                session.getTransaction().rollback();
                System.out.println(e.getMessage());
            }
            return "error";
        }finally{
            session.clear();
            session.close();
        }
    }
 
    
}
