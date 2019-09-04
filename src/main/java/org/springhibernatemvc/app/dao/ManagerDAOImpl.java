package org.springhibernatemvc.app.dao;

import java.util.List;  
import org.hibernate.Session;  
import org.hibernate.SessionFactory;  
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Repository;
import org.springhibernatemvc.app.entity.ManagerDetail;  
 
  
@Repository("ManagerDAO")  
public class ManagerDAOImpl implements ManagerDAO {  
  
    // Autowired SessionFactory Object So that we can get session object used for interaction with Database.  
    @Autowired  
    private SessionFactory sessionFactory;  
          
    /* 
     * Register Manager Details.  
    */  
    public int saveManagerDetail(ManagerDetail managerDetail) {  
          
        Session session = null;  
        try  
        {  
            session = sessionFactory.getCurrentSession();  
              
            int id = (Integer) session.save(managerDetail);  
            return id;  
        }  
        catch(Exception exception)  
        {  
            System.out.println("Excecption while saving manager Details : " + exception.getMessage());  
            return 0;  
        }  
        finally  
        {  
            session.flush();  
        }  
    }  
  
    public int managerLogin(String emailId, String password) {  
          
    	Session session = null;  
        try  
        {  
            session = sessionFactory.getCurrentSession();  
              
            Query query = session.createQuery("from ManagerDetail where email=:emailId and password=:password");  
            query.setParameter("emailId", emailId);  
            query.setParameter("password", password);  
            List<ManagerDetail> list = query.list();  
              
            int size = list.size();  
            if(size == 1)  
            {  
                return list.get(0).getId();  
            }  
            else  
            {  
                return -1;  
            }  
        }  
        catch(Exception exception)  
        {  
            System.out.println("Excecption while saving admin Details : " + exception.getMessage());  
            return 0;  
        }  
        finally  
        {  
            session.flush();  
        } 
        
    }  
  
      
    public List<ManagerDetail> getManagerData() {  
        Session session = null;  
        try  
        {  
            session = sessionFactory.getCurrentSession();  
              
            Query<ManagerDetail> query = session.createQuery("from ManagerDetail");  
            List<ManagerDetail> list = query.list();  
              
            if(list.size() > 0)  
            {  
                return list;  
            }  
            else  
            {  
                return null;  
            }  
              
        }  
        catch(Exception exception)  
        {  
            System.out.println("Excecption while saving manager Details : " + exception.getMessage());  
            return null;  
        }  
        finally  
        {  
            session.flush();  
        }  
          
    }  
  
      
}  
