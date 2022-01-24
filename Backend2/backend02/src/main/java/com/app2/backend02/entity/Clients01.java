package com.app2.backend02.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="clients01")
public class Clients01 implements Serializable {
	
private static final long serialVersionUID = 3L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id_clients")
	private Integer id_clients;
	
	@Column(name= "type_id")
	private String type_id;
	
	@Column(name= "num_id")
	private String num_id;
	
	@Column(name= "f_name")
	private String f_name;
	
	@Column(name= "s_name")
	private String s_name;
	
	@Column(name= "correo_client")
	private String correoClient;
	
	@Column(name= "date_born")
	private String date_born;
	
	@Column(name= "user_correo_user")
	private String user_correo_user;
	
	@OneToMany (mappedBy = "clients01Id_clients" )
	private List<Saving_accou> saving_accouList;
	
	@OneToMany (mappedBy = "clients01Id_clients" )
	private List<Checking_accou> checking_accouList;

	public Integer getId_clients() {
		return id_clients;
	}

	public void setId_clients(Integer id_clients) {
		this.id_clients = id_clients;
	}

	public String getType_id() {
		return type_id;
	}

	public void setType_id(String type_id) {
		this.type_id = type_id;
	}

	public String getNum_id() {
		return num_id;
	}

	public void setNum_id(String num_id) {
		this.num_id = num_id;
	}

	public String getF_name() {
		return f_name;
	}

	public void setF_name(String f_name) {
		this.f_name = f_name;
	}

	public String getS_name() {
		return s_name;
	}

	public void setS_name(String s_name) {
		this.s_name = s_name;
	}

	public String getCorreo_client() {
		return correoClient;
	}

	public void setCorreo_client(String correo_client) {
		this.correoClient = correo_client;
	}

	public String getDate_born() {
		return date_born;
	}

	public void setDate_born(String date_born) {
		this.date_born = date_born;
	}

	public String getUser_correo_user() {
		return user_correo_user;
	}

	public void setUser_correo_user(String user_correo_user) {
		this.user_correo_user = user_correo_user;
	}

	public List<Saving_accou> getSaving_accouList() {
		return saving_accouList;
	}

	public void setSaving_accouList(List<Saving_accou> saving_accouList) {
		this.saving_accouList = saving_accouList;
	}

	public List<Checking_accou> getChecking_accouList() {
		return checking_accouList;
	}

	public void setChecking_accouList(List<Checking_accou> checking_accouList) {
		this.checking_accouList = checking_accouList;
	}

}
