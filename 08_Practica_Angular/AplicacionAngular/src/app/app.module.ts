import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MenuComponent } from './menu/menu.component';
import { MensajesComponent } from './mensajes/mensajes.component';
import { ListadoComponent } from './listado/listado.component';
import { RegistroComponent } from './registro/registro.component';
import { FormsModule } from '@angular/forms';

import { HttpClientModule }    from '@angular/common/http';
import { RegistroRestComponent } from './registro-rest/registro-rest.component';
import { UsuarioDetailComponent } from './usuario-detail/usuario-detail.component';



@NgModule({
  declarations: [
    AppComponent,
    MensajesComponent,
    ListadoComponent,
    RegistroComponent,
    MenuComponent,
    RegistroRestComponent,
    UsuarioDetailComponent

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
