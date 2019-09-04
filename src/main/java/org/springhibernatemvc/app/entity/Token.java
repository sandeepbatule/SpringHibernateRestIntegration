package org.springhibernatemvc.app.entity;

import javax.persistence.Column;  
import javax.persistence.Entity;  
import javax.persistence.GeneratedValue;  
import javax.persistence.GenerationType;  
import javax.persistence.Id;  
import javax.persistence.Table;  
  
@Entity  
@Table(name="Token")  
public class Token {  
      
    @Id  
    @GeneratedValue(strategy = GenerationType.IDENTITY)  
    @Column(name="token_id")  
    private int tokenID;  
      
    @Column(name="user_id" , unique=true)  
    private int userID;  
       
    @Column(name="authenticationToken")  
    private String authenticationToken;  
      
    @Column(name="secretKey")  
    private String secretKey;  
      
    @Column(name="email")  
    private String email;  
      
    public Token() { }  
  
    public Token(int tokenID, int userID, String authenticationToken, String secretKey, String email) {  
        super();  
        this.tokenID = tokenID;  
        this.userID = userID;  
        this.authenticationToken = authenticationToken;  
        this.secretKey = secretKey;  
        this.email = email;  
    }  
  
    public int getTokenID() {  
        return tokenID;  
    }  
  
    public void setTokenID(int tokenID) {  
        this.tokenID = tokenID;  
    }  
  
    public int getUserID() {  
        return userID;  
    }  
  
    public void setUserID(int userID) {  
        this.userID = userID;  
    }  
  
    public String getAuthenticationToken() {  
        return authenticationToken;  
    }  
  
    public void setAuthenticationToken(String authenticationToken) {  
        this.authenticationToken = authenticationToken;  
    }  
  
    public String getSecretKey() {  
        return secretKey;  
    }  
  
    public void setSecretKey(String secretKey) {  
        this.secretKey = secretKey;  
    }  
  
    public String getEmail() {  
        return email;  
    }  
  
    public void setEmail(String email) {  
        this.email = email;  
    }  
  
    @Override  
    public String toString() {  
        return "Token [tokenID=" + tokenID + ", userID=" + userID + ", authenticationToken=" + authenticationToken  
                + ", secretKey=" + secretKey + ", emailId=" + email + "]";  
    }  
  
      
}  
