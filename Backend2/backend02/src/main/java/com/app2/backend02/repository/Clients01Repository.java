package com.app2.backend02.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app2.backend02.entity.Clients01;



@Repository("clients01Repository")
public interface Clients01Repository extends JpaRepository <Clients01, Serializable> {
	
	public List<Clients01>findByCorreoClient(String correo_client);
	
	

}