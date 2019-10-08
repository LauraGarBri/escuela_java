import { Injectable } from '@angular/core';
import { Usuario } from './model/usuario';
import { MensajesService } from './mensajes.service';
import {USUARIOS} from './model/array-usuario';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {

  private arrayUsuario: Usuario[];

  constructor(private mensajeSrv : MensajesService) {
    this.arrayUsuario = USUARIOS;
   }

  getUsuarios(): Usuario[] {
    this.mensajeSrv.add("usuarioService: capturando usuarios");
    return this.arrayUsuario;
  }

  //metodo añadir el nuevo heroe
  add(newUsuario: Usuario) {
    this.arrayUsuario.push(newUsuario);
  }

  getUsuario(id: number):Usuario {
    
   let usuario = this.arrayUsuario.find(usuario => usuario.id ===id);
     return usuario;
    
  }
}
