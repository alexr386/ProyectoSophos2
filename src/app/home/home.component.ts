import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { HttpHeaders } from '@angular/common/http';
import { Router } from '@angular/router';


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  user:any={};
  clients:any =[];
  client:any = {};
  crear:boolean = false;
  loading:boolean = false;

  constructor(private http: HttpClient,private router:Router) { }

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
  Listar(){
    this.router.navigate(["listar"]);
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
  agregar(){
    this.crear =!this.crear;
  }
  
  crearClient(){
    let formulario:any = document.getElementById("crear");
    let formularioValido:boolean = formulario.reportValidity();
    if(formularioValido){
      this.loading = true;
      this.clientServicio().subscribe(
        data => this.finalizarCrearClient(data)
      );
    }
  }
  clientServicio(){
    var httpOptions = {
      headers:new HttpHeaders({
        'Content-Type':'application/json'
      })
    }
    return this.http.post<any>("http://localhost:3030/clients01/guardar",this.client,httpOptions);
  }
  finalizarCrearClient(contacto:any){
    if(contacto){
      alert("Cliente creado exitosamente.");  
    }
    this.client = {clientCorreo:this.client.correo_client,saving_accouList:[],checking_accouList:[]};
    this.crear = false;
    this.buscarClients();
  }
  agregarSavingAccou(){
    this.client.saving_accouList.push({});
  }
  borrarSavingAccou(saving_accou:any){
    this.client.saving_accouList.splice(this.client.saving_accouList.indexof(saving_accou),1);
  }
  agregarCheckingAccou(){
    this.client.checking_accouList.push({});
  }
  borrarCheckingAccou(checking_accou:any){
    this.client.checking_accouList.splice(this.client.checking_accouList.indexof(checking_accou),1);
  }
}


