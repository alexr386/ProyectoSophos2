package com.app2.backend02.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User implements Serializable {
	
private static final long serialVersionUID = 2L;
	
	@Id
	@Basic(optional = false)
	@Column(name = "correo_user")
	private String correoUser;
	
	@Column(name= "name")
	private String name;
	
	@Column(name= "second_name")
	private String second_name;
	
	@Column(name= "password")
	private String password;
	
	@Column(name= "rol_id_rol")
	private Integer rolIdRol;

	public String getCorreo_user() {
		return correoUser;
	}

	public void setCorreo_user(String correo_user) {
		this.correoUser = correo_user;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSecond_name() {
		return second_name;
	}

	public void setSecond_name(String second_name) {
		this.second_name = second_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getRol_id_rol() {
		return rolIdRol;
	}

	public void setRol_id_rol(Integer rol_id_rol) {
		this.rolIdRol = rol_id_rol;
	}

	
}
