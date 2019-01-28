package com.spark.ex.launcher;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.spark.ex.hibernatepojo.*;
import com.spark.ex.pojos.User;
import com.spark.ex.util.ConnectionUtil;
import org.hibernate.*;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import org.hibernate.query.NativeQuery;
import org.hibernate.service.ServiceRegistry;

import com.spark.ex.hibernatepojo.ERS_Users;

public class Launcher {
	private static HibernateConfiguration hiberConfig = new HibernateConfiguration();
	SessionFactory sessionFactory = null;

	private SessionFactory hiberSessionFactory(){
		sessionFactory = hiberConfig.getSessionFactory();
		return sessionFactory;
	}
//	static SessionFactory sessionFactory;
	
	public static void main (String args[]) {
//
//		Launcher launcher = new Launcher();
//		sessionFactory = launcher.configureSessionFactory();
//
//		launcher.createUsers();
//
//		for(ERS_Reimbursement r : launcher.getSelectedReimbursement(1)) {
//			System.out.println(r);
//		}
//
//	for(ERS_Reimbursement r : launcher.getSelectedReimbursement(1)) {
//		System.out.println(r);
//	}
//		for(ERS_Reimbursement r : launcher.getAllReimbursement()) {
//			System.out.println(r);
//		}
//
//
//		ERS_User_Roles rolesDemo = new ERS_User_Roles();
//		rolesDemo.setUser_role("Manager");
//		ERS_Users userDemo = new ERS_Users();
//		userDemo.setUsername("wenda");
//		userDemo.setPassword("cai");
//		userDemo.setFirst_name("Not wenda");
//		userDemo.setLast_name("not cai");
//		userDemo.setEmail("demoemail@gmail.com");
//		userDemo.setRole_id(rolesDemo);
//		launcher.createReimb(userDemo, 5034.4, "Some Health thing");
//
//
//
		
	}
	

	private void createReimb(ERS_Users user, Double amount, String type) {
		ERS_Reimbursement ers_reinbursement = new ERS_Reimbursement();
		ers_reinbursement.setAmount(amount);
		ers_reinbursement.setSubmittedTime(java.time.LocalDateTime.now());
		ers_reinbursement.setDescription("Test reinbursement");
		ers_reinbursement.setAuthor(user);
		ers_reinbursement.setReimbursement_status(reimbStatus());
		ers_reinbursement.setReimbursement_type(reimbType(type));
		

	        presist(ers_reinbursement);

		
	}


	private ERS_Reimbursement_Type reimbType(String type) {
		ERS_Reimbursement_Type ers_reimbursement_type= new ERS_Reimbursement_Type();
		ers_reimbursement_type.setType(type);
		presist(ers_reimbursement_type);
		return ers_reimbursement_type;
	}


	private ERS_Reimbursement_Status reimbStatus() {
		ERS_Reimbursement_Status ers_reimbursement_status= new ERS_Reimbursement_Status();
		ers_reimbursement_status.setStatus("Pending");
		presist(ers_reimbursement_status);
		return ers_reimbursement_status;
		
		
	}

	public void presist(Object a) {
		Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        session.save(a);
        tx.commit();
        session.close();
	}
	public void createUsers() {
		  Session session = sessionFactory.openSession();
	        Transaction tx = session.beginTransaction();
		ERS_Reimbursement_Status ers_reimbursement_status= new ERS_Reimbursement_Status();
		ers_reimbursement_status.setStatus("Finished status");
		
		ERS_Reimbursement_Type ers_reimbursement_type= new ERS_Reimbursement_Type();
		ers_reimbursement_type.setType("Finished type");
		
		ERS_User_Roles user_roles = new ERS_User_Roles();
		user_roles.setUser_role("Manager");
		
		ERS_Users user = new ERS_Users();
		user.setUsername("username");
		user.setPassword("password");
		user.setFirst_name("Wenda");
		user.setLast_name("Cai");
		user.setEmail("testemail@gmail.com");
		user.setRole_id(user_roles);
		session.save(user_roles);
		session.save(user);
		
		ERS_Reimbursement ers_reinbursement = new ERS_Reimbursement();
		ers_reinbursement.setAmount(200);
		ers_reinbursement.setSubmittedTime(java.time.LocalDateTime.now());
		ers_reinbursement.setDescription("Test reinbursement");
		ers_reinbursement.setAuthor(user);
		ers_reinbursement.setReimbursement_status(ers_reimbursement_status);
		ers_reinbursement.setReimbursement_type(ers_reimbursement_type);
		

	        
	        session.save(ers_reinbursement);
	        
	      
	        tx.commit();
	        session.close();
	}

	public List<ERS_Reimbursement> getSelectedReimbursement(int id){
		Session session = sessionFactory.openSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		
		CriteriaQuery<ERS_Reimbursement> criteria = builder.createQuery(ERS_Reimbursement.class);
		Root<ERS_Reimbursement> reimbursementRoot = criteria.from(ERS_Reimbursement.class);
		criteria.select(reimbursementRoot).where(builder.equal(reimbursementRoot.get("reimb_id"),id));
		List<ERS_Reimbursement> ers_reimbursement = session.createQuery(criteria).getResultList();
		session.close();
		return ers_reimbursement;
	}
	public List<ERS_Reimbursement> getAllReimbursement(){
		Session session = sessionFactory.openSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		
		CriteriaQuery<ERS_Reimbursement> criteria = builder.createQuery(ERS_Reimbursement.class);
		Root<ERS_Reimbursement> reimbursementRoot = criteria.from(ERS_Reimbursement.class);
		criteria.select(reimbursementRoot).where();
		List<ERS_Reimbursement> ers_reimbursement = session.createQuery(criteria).getResultList();
		
//		Criteria crt;
//		crt= session.createCriteria(ERS_Reimbursement.class);
//		List<ERS_Reimbursement> ers_reimbursement= crt.addOrder(Order.desc("REIMB_SUBMITTED")).list();
		session.close();
		return ers_reimbursement;
		
	}



	 public ERS_Users authUser(ERS_Users authUser) {

			ERS_Users u = getUserbyUsername(authUser.getEmail());
			if (u!= null ) {
				if (u.getPassword().equals(authUser.getPassword())) {
					u.setPassword("");
				}else {
					u = null;
				}
			}

			return u;
		}

	public ERS_Users getUserbyUsername(String authUser) {




		sessionFactory = hiberSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();


//		CriteriaBuilder builder = session.getCriteriaBuilder();

//		System.out.println("inside getuserbyusername3");
//		System.out.println(authUser);
		List<ERS_Users> u = null;
		String hql = "From Users where ERS_EMAIL =: username";
		NativeQuery q = session.createNativeQuery(hql);
		q.setParameter("username", authUser);
		u=q.getResultList();
		ERS_Users users= null;
		if(!u.isEmpty()){
			// ignores multiple results
			users= u.get(0);
		} tx.commit();
		session.close();
		return users;
	}

}
