import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Client } from '../Modelo/Client';
import { ServiceService } from '../Service/service.service';
import { HttpClient } from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';



@Component({
  selector: 'app-listar',
  templateUrl: './listar.component.html',
  styleUrls: ['./listar.component.css']
})
export class ListarComponent implements OnInit {

  user:any={};
  clients:any =[];
  client:any = {};
  crear:boolean = false;
  loading:boolean = false;
  
  
  
  constructor(private http: HttpClient, private router:Router, private service:ServiceService) { }

  ngOnInit(): void {
    this.user = JSON.stringify(localStorage.getItem('user'));
    if(!this.user){
      location.href ='/';
    }
    else{
      this.client = {correoClient:this.client.correoClient,saving_accouList:[],checking_accouList:[]};
      this.buscarClients();
    }
  }

  logout(){
    localStorage.removeItem("user");
    alert("Sesión cerrada exitosamente");
    location.href ='/';
  }
  buscarClients(){
    this.loading = true;
    this.buscarClientsService().subscribe(
      (response:any)=>this.llenarClients(response)
    );
  }
  buscarClientsService():Observable<any>{
    return this.http.get<any>("http://localhost:3030/clients01/buscar");
  }
  llenarClients(clients:any){
    this.clients = clients;
    this.loading = false;
  }
  ShowProducts(client:Client): void {
    localStorage.setItem("id_clients",client.id_clients.toString());
    this.router.navigate(["show-products"]);
  }
  Editar(client:Client): void {
    localStorage.setItem("id_clients",client.id_clients.toString());
    this.router.navigate(["edit"]);
  }
  Delete(client:Client){
    this.service.deleteClient(client)
    .subscribe((data: any)=>{
      this.clients=this.clients.filter((c: Client)=>c!==client);
      alert("Cliente eliminado...");
    });
  }
  regresar(){
    location.href = "home";
  }
}

