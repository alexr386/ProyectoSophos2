import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { SigninComponent } from './signin/signin.component';
import { HomeAdminComponent } from './home-admin/home-admin.component';
import { ListarComponent } from './listar/listar.component';
import { ShowProductsComponent } from './show-products/show-products.component';
import { AddComponent } from './add/add.component';
import { EditComponent } from './edit/edit.component';

const routes: Routes = [
  {path:'',component:LoginComponent},
  {path:'home',component:HomeComponent},
  {path:'home-admin',component:HomeAdminComponent},
  {path:'signin',component:SigninComponent},
  {path:'listar',component:ListarComponent},
  {path:'show-products',component:ShowProductsComponent},
  {path:'add',component:AddComponent},
  {path:'edit',component:EditComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
