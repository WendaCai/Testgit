package com.spark.ex.hibernatepojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ers_reimbursement_type")
public class ERS_Reimbursement_Type {

@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name="REIMB_TYPE_ID")
int type_id;

@Column(name="REIMB_TYPES", nullable = false)
String type;

public int getType_id() {
	return type_id;
}

public void setType_id(int type_id) {
	this.type_id = type_id;
}

public String getType() {
	return type;
}

public void setType(String type) {
	this.type = type;
}




}
