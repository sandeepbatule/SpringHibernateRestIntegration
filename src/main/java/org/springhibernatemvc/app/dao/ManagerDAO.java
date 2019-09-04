package org.springhibernatemvc.app.dao;

import java.util.List;

import org.springhibernatemvc.app.entity.ManagerDetail;  
 
  
public interface ManagerDAO {  
  
    public int saveManagerDetail(ManagerDetail managerDetail);  
      
    public int managerLogin(String emailId ,String password);  
      
    public List<ManagerDetail> getManagerData();  
}
