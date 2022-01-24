import { Component, OnInit } from '@angular/core';
import { Client } from '../Modelo/Client';

@Component({
  selector: 'app-show-products',
  templateUrl: './show-products.component.html',
  styleUrls: ['./show-products.component.css']
})
export class ShowProductsComponent implements OnInit {

  client:any = {};
  constructor() { }

  ngOnInit(): void {
  }
  logout(){
    localStorage.removeItem("user");
    alert("Sesión cerrada exitosamente");
    location.href ='/';
  }
  regresar(){
    location.href = "listar";
  }
  operacion(client:Client){

  }
}
