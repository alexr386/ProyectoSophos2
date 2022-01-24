import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home-admin',
  templateUrl: './home-admin.component.html',
  styleUrls: ['./home-admin.component.css']
})
export class HomeAdminComponent implements OnInit {

  user: any = {};

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
    this.user = JSON.stringify(localStorage.getItem('user'));
    if(!this.user){
      location.href ='/';
    }
    else {
      if(this.user.rol_id_rol == 1){
        location.href = "/home-admin"
      }
    }
  }

  logout(){
    localStorage.removeItem("user");
    alert("Sesión cerrada exitosamente");
    location.href ='/';
  }

}
