import { Component, OnInit } from '@angular/core';
import { Usuario } from '../model/usuario';
import { UsuarioService } from '../usuario.service';

@Component({
  selector: 'app-listado',
  templateUrl: './listado.component.html',
  styleUrls: ['./listado.component.css']
})
export class ListadoComponent implements OnInit {

  usuarios: Usuario[];
  selectedUsuario: Usuario;

  constructor(private usuarioSrv: UsuarioService) { }

  ngOnInit() {
   //this.heroes = HEROES;
   this.getUsuariosFromService(); //Esto es lo mismo que el metodo de abajo 

  }

  onSelect(usuario: Usuario): void{
    this.selectedUsuario = usuario;
  }

  getUsuariosFromService():void{
    this.usuarios = this.usuarioSrv.getUsuario();
  }

}
