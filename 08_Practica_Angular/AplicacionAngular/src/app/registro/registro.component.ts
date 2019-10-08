import { Component, OnInit } from '@angular/core';
import { Usuario } from '../model/usuario';
import { UsuarioService } from '../usuario.service';

@Component({
  selector: 'app-registro',
  templateUrl: './registro.component.html',
  styleUrls: ['./registro.component.css']
})
export class RegistroComponent implements OnInit {

  newUsuario: Usuario;
  

  constructor(private usuarioSrv: UsuarioService) { }

  ngOnInit() {
    this.newUsuario = new Usuario();
  }

  //Evento onclick
  createUser(): void {
    this.usuarioSrv.add(this.newUsuario);
    // Crear uno nuevo para la siguiente vez
    this.newUsuario = new Usuario();
  }
}
