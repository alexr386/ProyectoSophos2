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
@Table(name="saving_accou")
public class Saving_accou implements Serializable {
	
private static final long serialVersionUID = 4L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id_saving_accou")
	private Integer id_saving_accou;
	
	@Column(name= "num_saving_accou")
	private Integer num_saving_accou;
	
	@Column(name= "type_saving_accou")
	private String type_saving_accou;
	
	@Column(name= "open_date_saving")
	private String open_date_saving;
	
	@Column(name= "status_saving_accou")
	private String status_saving_accou;
	
	@Column(name= "balance_saving_accou")
	private double balance_saving_accou;
	
	@Column(name= "clients01_id_clients")
	private double clients01Id_clients;

	public Integer getId_saving_accou() {
		return id_saving_accou;
	}

	public void setId_saving_accou(Integer id_saving_accou) {
		this.id_saving_accou = id_saving_accou;
	}

	public Integer getNum_saving_accou() {
		return num_saving_accou;
	}

	public void setNum_saving_accou(Integer num_saving_accou) {
		this.num_saving_accou = num_saving_accou;
	}

	public String getType_saving_accou() {
		return type_saving_accou;
	}

	public void setType_saving_accou(String type_saving_accou) {
		this.type_saving_accou = type_saving_accou;
	}

	public String getOpen_date_saving() {
		return open_date_saving;
	}

	public void setOpen_date_saving(String open_date_saving) {
		this.open_date_saving = open_date_saving;
	}

	public String getStatus_saving_accou() {
		return status_saving_accou;
	}

	public void setStatus_saving_accou(String status_saving_accou) {
		this.status_saving_accou = status_saving_accou;
	}

	public double getBalance_saving_accou() {
		return balance_saving_accou;
	}

	public void setBalance_saving_accou(double balance_saving_accou) {
		this.balance_saving_accou = balance_saving_accou;
	}

	public double getClients01Id_clients() {
		return clients01Id_clients;
	}

	public void setClients01Id_clients(double clients01Id_clients) {
		this.clients01Id_clients = clients01Id_clients;
	}

	
}
