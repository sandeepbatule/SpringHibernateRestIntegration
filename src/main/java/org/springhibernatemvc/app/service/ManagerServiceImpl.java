package org.springhibernatemvc.app.service;

import java.util.List;  
import javax.transaction.Transactional;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Service;
import org.springhibernatemvc.app.dao.ManagerDAO;
import org.springhibernatemvc.app.entity.ManagerDetail;  
 
  
@Service("managerService")  
public class ManagerServiceImpl implements ManagerService {  
      
    @Autowired  
    private ManagerDAO managerDAO;  
  
    @Transactional  
    public int saveManagerDetail(ManagerDetail managerDetail) {  
        return managerDAO.saveManagerDetail(managerDetail);  
    }  
      
    @Transactional  
    public int managerLogin(String emailId, String password) {  
        return managerDAO.managerLogin(emailId, password);  
    }  
  
    @Transactional  
    public List<ManagerDetail> getManagerData() {  
        return managerDAO.getManagerData();  
    }  
      
      
  
}  
