import { NgModule } from '@angular/core';
//import { CommonModule } from '@angular/common';
import {RouterModule, Routes} from "@angular/router";
import {HerosListComponent}from "../app/heros-list/heros-list.component";
import {NewHeroComponent} from "../app/new-hero/new-hero.component";
import { DashboardComponent } from './dashboard/dashboard.component';

//Listado de vinculaciones entre URL y component
const routes: Routes = [
  {path:"heroes", component: HerosListComponent},
  {path: "nuevoHero", component: NewHeroComponent },
  {path: "dashboard", component: DashboardComponent },
  {path: '',redirectTo: '/dashboard', pathMatch:'full'}
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
