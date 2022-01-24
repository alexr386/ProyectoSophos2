package com.app2.backend02.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app2.backend02.entity.Checking_accou;
import com.app2.backend02.entity.Clients01;
import com.app2.backend02.entity.Saving_accou;
import com.app2.backend02.repository.Checking_accouRepository;
import com.app2.backend02.repository.Clients01Repository;
import com.app2.backend02.repository.Saving_accouRepository;

/**
 * @author USUARIO
 *
 */
@RestController
@RequestMapping("/clients01")
@CrossOrigin(origins = "http://localhost:4200")
public class Clients01Service {
	
	@Autowired
	Saving_accouRepository saving_accouRepository;
	
	@Autowired
	Checking_accouRepository checking_accouRepository;
	
	@Autowired
	Clients01Repository clients01Repository;
	
	@GetMapping(path ="/buscar")
	public List<Clients01>getAllClients01(){
		return clients01Repository.findAll();
	}
	
	@PostMapping(path = "/guardar")
	public Clients01 saveClients01(@RequestBody Clients01 clients01) {
		
		List<Saving_accou> saving_accouns = clients01.getSaving_accouList();
		List<Checking_accou> checking_accouns = clients01.getChecking_accouList();
		
		clients01.setSaving_accouList(null);
		clients01.setChecking_accouList(null);
		
		clients01 =clients01Repository.save(clients01);
		
		clients01.setSaving_accouList(new LinkedList<>());
		clients01.setChecking_accouList(new LinkedList<>());
		
		if(saving_accouns!=null) {
			for(Saving_accou sa : saving_accouns) {
				sa.setClients01Id_clients(clients01.getId_clients());
				saving_accouRepository.save(sa);
				clients01.getSaving_accouList().add(sa);
			}
		}
		
		if(checking_accouns!=null) {
			for(Checking_accou ca : checking_accouns) {
				ca.setClients01Id_clients(clients01.getId_clients());
				checking_accouRepository.save(ca);
				clients01.getChecking_accouList().add(ca);
			}
		}
		
		
		return clients01;
	}
	
	@PutMapping(path = "/editar/{id_clients}")
	public Clients01 updateClients01(@RequestBody Clients01 clients01,@PathVariable("id_clients") int id_clients) {
		
		List<Saving_accou> saving_accouns = clients01.getSaving_accouList();
		List<Checking_accou> checking_accouns = clients01.getChecking_accouList();
		
		clients01.setSaving_accouList(null);
		clients01.setChecking_accouList(null);
		
		clients01 =clients01Repository.save(clients01);
		
		clients01.setSaving_accouList(new LinkedList<>());
		clients01.setChecking_accouList(new LinkedList<>());
		
		if(saving_accouns!=null) {
			for(Saving_accou sa : saving_accouns) {
				sa.setClients01Id_clients(clients01.getId_clients());
				saving_accouRepository.save(sa);
				clients01.getSaving_accouList().add(sa);
			}
		}
		
		if(checking_accouns!=null) {
			for(Checking_accou ca : checking_accouns) {
				ca.setClients01Id_clients(clients01.getId_clients());
				checking_accouRepository.save(ca);
				clients01.getChecking_accouList().add(ca);
			}
		}
		
		
		return clients01;
	}
	
	
	@DeleteMapping(path ="/eliminar/{id_clients}")
	public void deleteClients01(@PathVariable ("id_clients")Integer id_clients) {
		
		Optional<Clients01> clients01;
		clients01 = clients01Repository.findById(id_clients);
		if (clients01.isPresent()) {
			Clients01 borrar = clients01.get();
			for(Saving_accou sa : borrar.getSaving_accouList()) {
				saving_accouRepository.delete(sa);
			}
			
			for(Checking_accou ca : borrar.getChecking_accouList()) {
				checking_accouRepository.delete(ca);
			}
			clients01Repository.delete(clients01.get());
		}
		
	}
	
	/*@GetMapping(path= "/buscar/correo_user/{user_correo_user}")
	public List<Clients01> findByCorreoClient(@PathVariable("correoClient") String correo_client){
		return clients01Repository.findByCorreoClient(correo_client);
	}*/

}
	

