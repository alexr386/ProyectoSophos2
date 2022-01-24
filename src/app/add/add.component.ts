import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { HttpHeaders } from '@angular/common/http';

@Component({
  selector: 'app-add',
  templateUrl: './add.component.html',
  styleUrls: ['./add.component.css']
})
export class AddComponent implements OnInit {

  user:any={};
  clients:any =[];
  client:any = {};
  crear:boolean = false;
  loading:boolean = false;

  constructor(private http: HttpClient, private router:Router) { }

  ngOnInit(): void {
    this.user = JSON.stringify(localStorage.getItem('user'));
    if(!this.user){
      location.href ='/';
    }
    else{
      this.client = {correoClient:this.client.correo_client,saving_accouList:[],checking_accouList:[]};
      this.buscarClients();
    }
  }
  buscarClients(){
    this.loading = true;
    this.buscarClientsService().subscribe(
      (response:any)=>this.llenarClients(response)
    );
  }
  buscarClientsService():Observable<any>{
    return this.http.get<any>("http://localhost:3030/clients01/buscar/correo_user/" + this.user.correo_user).pipe(
      catchError(e=>"Error")
    )
  }
  llenarClients(clients:any){
    this.clients = clients;
    this.loading = false;
  }
  agregar(){
    this.crear =!this.crear;
  }
  Listar(){
    this.router.navigate(["listar"]);
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
    if(this.client){
      alert("Cliente creado exitosamente.");  
    }
    this.client = {clientCorreo:this.client,saving_accouList:[],checking_accouList:[]};
    this.crear = false;
    this.buscarClients();
  }

}
