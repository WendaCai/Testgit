package com.spark.ex.hibernatepojo;


import javax.persistence.Basic;
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

@Table(name="ers_reimbursement")

public class ERS_Reimbursement {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="REIMB_ID")
	int reimb_id;
	
	@Column(name="REIMB_AMOUNT",nullable = false)
	double amount;	
	
	@Basic
	@Column(name="REIMB_SUBMITTED", nullable = false)
	private java.time.LocalDateTime submittedTime;

	@Basic
	@Column(name="REIMB_RESOLVED")
	private java.time.LocalDateTime resolvedTime;
	
	@Column(name="REIMB_DESCRIPTION")
	String description;
	
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@GeneratedValue(strategy=GenerationType.AUTO)
	@JoinColumn(name="ERS_USER_ID", nullable = false)
	ERS_Users author;

//	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
//	@GeneratedValue(strategy=GenerationType.AUTO)
//	@JoinColumn(name="ERS_USER_ID")
@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
@JoinColumn(name="REIMB_RESOLVER", nullable = false)
//	ERS_Users resolver;
		ERS_Users user;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@GeneratedValue(strategy=GenerationType.AUTO)
	@JoinColumn(name="REIMB_STATUS_ID", nullable = false)
	ERS_Reimbursement_Status reimbursement_status;

	public ERS_Reimbursement_Status getReimbursement_status() {
		return reimbursement_status;
	}

	public void setReimbursement_status(ERS_Reimbursement_Status reimbursement_status) {
		this.reimbursement_status = reimbursement_status;
	}



	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@GeneratedValue(strategy=GenerationType.AUTO)
	@JoinColumn(name="REIMB_TYPE_ID", nullable = false)
	ERS_Reimbursement_Type reimbursement_type;

	public ERS_Users getAuthor() {
		return author;
	}

	public void setAuthor(ERS_Users author) {
		this.author = author;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public java.time.LocalDateTime getSubmittedTime() {
		return submittedTime;
	}

	public void setSubmittedTime(java.time.LocalDateTime submittedTime) {
		this.submittedTime = submittedTime;
	}

	public java.time.LocalDateTime getResolvedTime() {
		return resolvedTime;
	}

	public void setResolvedTime(java.time.LocalDateTime resolvedTime) {
		this.resolvedTime = resolvedTime;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getReimb_id() {
		return reimb_id;
	}

	public void setReimb_id(int reimb_id) {
		this.reimb_id = reimb_id;
	}

	public ERS_Users getUser() {
		return user;
	}

	public void setUser(ERS_Users user) {
		this.user = user;
	}

	public ERS_Reimbursement_Type getReimbursement_type() {
		return reimbursement_type;
	}

	public void setReimbursement_type(ERS_Reimbursement_Type reimbursement_type) {
		this.reimbursement_type = reimbursement_type;
	}

	@Override
	public String toString() {
		return "ERS_Reimbursement [reimb_id=" + reimb_id + ", amount=" + amount + ", submittedTime=" + submittedTime
				+ ", resolvedTime=" + resolvedTime + ", description=" + description + ", author=" + author + ", user="
				+ user + ", reimbursement_status=" + reimbursement_status + ", reimbursement_type=" + reimbursement_type
				+ "]";
	}










}
