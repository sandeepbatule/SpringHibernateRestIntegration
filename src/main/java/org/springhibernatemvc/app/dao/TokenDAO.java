package org.springhibernatemvc.app.dao;

public interface TokenDAO {  
    
    public void saveUserEmail(String email , int adminId);  
      
    public boolean updateToken(String email , String authenticationToken , String secretKey);  
      
    public int getTokenDetail(String email );  
  
    public int tokenAuthentication(String token , int emailId);  
  
} 
