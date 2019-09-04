package org.springhibernatemvc.app.service;

import java.util.List;

import org.springhibernatemvc.app.entity.ManagerDetail;  
  
public interface ManagerService {  
  
    public int saveManagerDetail(ManagerDetail managerDetail);  
      
    public int managerLogin(String emailId , String password);  
      
    public List<ManagerDetail> getManagerData();  
}
