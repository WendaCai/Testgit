package com.spark.ex.hibernatepojo;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="ers_users")
public class ERS_Users {
	@Id
	@Column(name="ERS_USER_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="ERS_USERNAME", unique = true)
	String username;
	
	@Column(name="ERS_PASSWORD")
	String password;
	
	@Column(name="USER_FIRST_NAME")
	String first_name;
	
	@Column(name="USER_LAST_NAME")
	String last_name;
	
	@Column(name="USER_EMAIL", unique = true)
	String email;
	

//	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@Column(name="ROLE_ID")
//	@GeneratedValue(strategy=GenerationType.AUTO)
	ERS_User_Roles role_id;
	

	public ERS_Users() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public ERS_User_Roles getRole_id() {
		return role_id;
	}

	public void setRole_id(ERS_User_Roles role_id) {
		this.role_id = role_id;
	}

	@Override
	public String toString() {
		return "ERS_Users [id=" + id + ", username=" + username + ", password=" + password + ", first_name="
				+ first_name + ", last_name=" + last_name + ", email=" + email + ", role_id=" + role_id + "]";
	}






}
