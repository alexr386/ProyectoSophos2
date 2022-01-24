import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Client } from '../Modelo/Client';
import { ServiceService } from '../Service/service.service';

@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.css']
})
export class EditComponent implements OnInit {

  client:Client = new Client();
  constructor(private router:Router, private service:ServiceService) { }

  ngOnInit() {
    this.Editar();
  }

  logout(){
    localStorage.removeItem("user");
    alert("Sesión cerrada exitosamente");
    location.href ='/';
  }
  regresar(){
    location.href = "listar";
  }
  Editar(){
    let id_clients=localStorage.getItem("id_clients");
    this.service.getClientId(+"id_clients")
    .subscribe(data=> {
      this.client=data;
    })

  }
  Actualizar(client:Client){
    this.service.updateClient(client)
    .subscribe(data=>{
      this.client=data;
      alert("Se Actualizo con Exito...!!!");
      this.router.navigate(["listar"]);
    })
  }
}
