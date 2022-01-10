import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  errorInicio:boolean=false;
  loading:boolean=false;
  user:any={};

  constructor() { }

  ngOnInit(): void {
  }
  login(){

  }
  crearCuenta(){
    location.href="/signin";
  }

}
