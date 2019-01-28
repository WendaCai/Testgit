package com.spark.ex.hibernatepojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ers_reimbursement_status")
public class ERS_Reimbursement_Status {

@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name="REIMB_STATUS_ID")
int status_id;

@Column(name="REIMB_STATUS", nullable = false)
String status;

public int getStatus_id() {
	return status_id;
}

public void setStatus_id(int status_id) {
	this.status_id = status_id;
}

public String getStatus() {
	return status;
}

public void setStatus(String status) {
	this.status = status;
}


}
