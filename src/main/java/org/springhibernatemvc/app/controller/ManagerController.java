package org.springhibernatemvc.app.controller;

import java.util.List;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.http.HttpHeaders;  
import org.springframework.http.HttpStatus;  
import org.springframework.http.ResponseEntity;  
import org.springframework.web.bind.annotation.CrossOrigin;  
import org.springframework.web.bind.annotation.GetMapping;  
import org.springframework.web.bind.annotation.PathVariable;  
import org.springframework.web.bind.annotation.PostMapping;  
import org.springframework.web.bind.annotation.RequestBody;  
import org.springframework.web.bind.annotation.RequestHeader;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RestController;
import org.springhibernatemvc.app.entity.ManagerDetail;
import org.springhibernatemvc.app.generateToken.GenerateToken;
import org.springhibernatemvc.app.service.ManagerService;
import org.springhibernatemvc.app.service.TokenService;  
  
  
@RestController  
@RequestMapping("/api")  
@CrossOrigin("*")  
public class ManagerController {  
      
    @Autowired  
    private ManagerService managerService;  
      
    @Autowired  
    private TokenService tokenService;  
      
    GenerateToken generateToken = new GenerateToken();  
      
    @PostMapping("/saveManager")  
    public int saveManagerDetail(@RequestBody ManagerDetail managerDetail) {  
        return managerService.saveManagerDetail(managerDetail);  
    }  
      
    @PostMapping("/login")  
    public ResponseEntity<Integer> login(@RequestBody ManagerDetail managerDetail)  
    {  
        int status;  
        HttpHeaders httpHeader = null;  
      
        // Authenticate User.  
        status = managerService.managerLogin(managerDetail.getEmail(), managerDetail.getPassword());  
          System.out.println("status:"+status);
        /* 
         * If User is authenticated then Do Authorization Task. 
         */  
        if (status > 0)   
        {  
            /* 
             * Generate token. 
             */  
            String tokenData[] = generateToken.createJWT(managerDetail.getEmail(), "Assignment", "JWT Token", 43200000);  
              
            // get Token.  
            String token = tokenData[0];  
              
            System.out.println("Authorization :: " + token);  
  
            // Create the Header Object  
            httpHeader = new HttpHeaders();  
  
            // Add token to the Header.  
            httpHeader.add("Authorization", token);  
  
            // Check if token is already exist.  
            long isUserEmailExists = tokenService.getTokenDetail(managerDetail.getEmail());  
              
            /* 
             * If token exist then update Token else create and insert the token. 
             */  
            if (isUserEmailExists > 0)   
            {  
                tokenService.updateToken(managerDetail.getEmail(), token, tokenData[1]);  
            }   
            else   
            {  
                tokenService.saveUserEmail(managerDetail.getEmail(), status);  
                tokenService.updateToken(managerDetail.getEmail(), token, tokenData[1]);  
            }  
  
            return new ResponseEntity<Integer>(status, httpHeader, HttpStatus.OK);  
        }   
          
        // if not authenticated return  status what we get.  
        else   
        {  
            return new ResponseEntity<Integer>(status, httpHeader, HttpStatus.OK);  
        }  
          
  
    }  
      
      
    @GetMapping("/getManagerData/{id}")  
    public List<ManagerDetail> getManagerData(@PathVariable int id, @RequestHeader("Authorization") String authorizationToken)  
    {  
        String token[] = authorizationToken.split(" ");  
        int result = tokenService.tokenAuthentication(token[1], id);  
          
        if (result > 0) {  
            return managerService.getManagerData();  
        } else {  
            return null;  
        }  
    }  
      
}  
