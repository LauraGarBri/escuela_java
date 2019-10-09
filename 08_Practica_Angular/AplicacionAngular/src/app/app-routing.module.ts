import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ListadoComponent }  from '../app/listado/listado.component'
import { RegistroComponent } from '../app/registro/registro.component';
import {RegistroRestComponent} from '../app/registro-rest/registro-rest.component';
import { UsuarioDetailComponent }  from '../app/usuario-detail/usuario-detail.component';


const routes: Routes = [
  {path:"listado", component: ListadoComponent},
  //{path: "registro", component: RegistroComponent }
  {path: "registro", component: RegistroRestComponent },
  {path: 'detail/:id', component: UsuarioDetailComponent }
];


@NgModule({
  declarations: [],
  imports: [
    //CommonModule
    RouterModule.forRoot(routes)
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
