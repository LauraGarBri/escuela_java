import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ListadoComponent }  from '../app/listado/listado.component'
import { RegistroComponent } from '../app/registro/registro.component';


const routes: Routes = [
  {path:"listado", component: ListadoComponent},
  { path: "registro", component: RegistroComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
