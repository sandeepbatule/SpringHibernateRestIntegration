package org.springhibernatemvc.app.entity;

import javax.persistence.Column;  
import javax.persistence.Entity;  
import javax.persistence.GeneratedValue;  
import javax.persistence.GenerationType;  
import javax.persistence.Id;  
import javax.persistence.Table;  
  
@Entity  
@Table(name="admin_detail")  
public class ManagerDetail {  
  
    @Id  
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")  
    private int id;  
      
    @Column(name="email" , unique=true)  
    public String email;  
      
    @Column(name="first_name")  
    public String firstName;  
      
    @Column(name="last_name")  
    public String lastName;  
      
    @Column(name="password")  
    public String password;  
    
    @Column(name="address")  
    public String address;  
    
    @Column(name="dob")  
    public String dob;  
    
    @Column(name="company")  
    public String company;  
      
    public ManagerDetail() { }  


	public ManagerDetail(int id, String email, String firstName, String lastName, String password, String address,
			String dob, String company) {
		super();
		this.id = id;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.address = address;
		this.dob = dob;
		this.company = company;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getDob() {
		return dob;
	}


	public void setDob(String dob) {
		this.dob = dob;
	}


	public String getCompany() {
		return company;
	}


	public void setCompany(String company) {
		this.company = company;
	}


	@Override
	public String toString() {
		return "ManagerDetail [id=" + id + ", email=" + email + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", password=" + password + ", address=" + address + ", dob=" + dob + ", company=" + company
				+ ", getId()=" + getId() + ", getEmail()=" + getEmail() + ", getFirstName()=" + getFirstName()
				+ ", getLastName()=" + getLastName() + ", getPassword()=" + getPassword() + ", getAddress()="
				+ getAddress() + ", getDob()=" + getDob() + ", getCompany()=" + getCompany() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}


}  
