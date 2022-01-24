package com.app2.backend02.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="checking_accou")
public class Checking_accou implements Serializable {
	
private static final long serialVersionUID = 5L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id_checking_accou")
	private Integer id_checking_accou;
	
	@Column(name= "num_checking_accou")
	private Integer num_checking_accou;
	
	@Column(name= "type_checking_accou")
	private String type_checking_accou;
	
	@Column(name= "open_date_checking")
	private String open_date_checking;
	
	@Column(name= "status_checking_accou")
	private String status_checking_accou;
	
	@Column(name= "balance_checking_accou")
	private double balance_checking_accou;
	
	@Column(name= "clients01_id_clients")
	private double clients01Id_clients;

	public Integer getId_checking_accou() {
		return id_checking_accou;
	}

	public void setId_checking_accou(Integer id_checking_accou) {
		this.id_checking_accou = id_checking_accou;
	}

	public Integer getNum_checking_accou() {
		return num_checking_accou;
	}

	public void setNum_checking_accou(Integer num_checking_accou) {
		this.num_checking_accou = num_checking_accou;
	}

	public String getType_checking_accou() {
		return type_checking_accou;
	}

	public void setType_checking_accou(String type_checking_accou) {
		this.type_checking_accou = type_checking_accou;
	}

	public String getOpen_date_checking() {
		return open_date_checking;
	}

	public void setOpen_date_checking(String open_date_checking) {
		this.open_date_checking = open_date_checking;
	}

	public String getStatus_checking_accou() {
		return status_checking_accou;
	}

	public void setStatus_checking_accou(String status_checking_accou) {
		this.status_checking_accou = status_checking_accou;
	}

	public double getBalance_checking_accou() {
		return balance_checking_accou;
	}

	public void setBalance_checking_accou(double balance_checking_accou) {
		this.balance_checking_accou = balance_checking_accou;
	}

	public double getClients01Id_clients() {
		return clients01Id_clients;
	}

	public void setClients01Id_clients(double clients01Id_clients) {
		this.clients01Id_clients = clients01Id_clients;
	}
	
	
}
