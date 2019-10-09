import { Component, OnInit, Input } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Usuario } from '../model/usuario';
import { UsuarioService } from '../usuario.service';
import { Location } from '@angular/common';
import { RegistroRestService } from '../registro-rest.service';

@Component({
  selector: 'app-usuario-detail',
  templateUrl: './usuario-detail.component.html',
  styleUrls: ['./usuario-detail.component.css']
})
export class UsuarioDetailComponent implements OnInit {

  @Input() usuario: Usuario;

  constructor(private route: ActivatedRoute, 
              private userSrv: UsuarioService) { }

  ngOnInit() {
    this.changeUser();
  }

  changeUser(): void {
    // Cogemos el id del parámetro de la url   /detail/:id
    const id = this.route.snapshot.paramMap.get('id');  
    this.usuario = this.userSrv.getUsuario(parseInt(id));
  }

}


/*
@Input() user: User;

  constructor(private route: ActivatedRoute, 
              private userSrv: UserService) { }

  ngOnInit() {
    this.changeUser();
  }

  changeUser(): void {
    // Cogemos el id del parámetro de la url   /detail/:id
    const id = this.route.snapshot.paramMap.get('id');  
    this.user = this.userSrv.getUser(parseInt(id));
  }
}*/
