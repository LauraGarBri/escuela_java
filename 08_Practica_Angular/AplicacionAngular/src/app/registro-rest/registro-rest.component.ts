import { Component, OnInit } from '@angular/core';
import { Usuario } from '../model/usuario';
import { Observable } from 'rxjs';
import { RegistroRestService } from '../registro-rest.service';

@Component({
  selector: 'app-registro-rest',
  templateUrl: './registro-rest.component.html',
  styleUrls: ['./registro-rest.component.css']
})
export class RegistroRestComponent implements OnInit {

  usuariosRecibidos: Usuario[];
  //id: string;???????????
  email: string;
  password: string;
  name: string;
  age: string;


  constructor(private usuarioRestSrv: RegistroRestService) { }

  enviar() {
    let nuevoUsuario = new Usuario();
    //nuevoUsuario.id = parseInt(this.id);
    nuevoUsuario.name = this.name;
    this.usuarioRestSrv.add(nuevoUsuario).subscribe((obj) => {
      this.ngOnInit();
    });

  }

  ngOnInit() {
    /*console.log("1.Empezamos a pedir los datos");
    let observableUsuarios: Observable<Usuario[]>;
    observableUsuarios = this.usuarioRestSrv.getUsuarios();
    //La ejecucion continua hasta que el array es recibido
    //Para recibirlo asincronamente nos suscribimos al observable

    let funcionAvisameCuandoLoTengas = (usuariosRec) => {
      this.usuariosRecibidos = usuariosRec
      console.log("3.Hemos recibido los heroes");
    };
    observableUsuarios.subscribe(funcionAvisameCuandoLoTengas);
    console.log("2.Nos hemos suscrito");*/

    //En una sola linea se puede hacer todo lo anterior
     //this.usuarioRestSrv.getUsuarios().subscribe(heroesRec => this.usuariosRecibidos = heroesRec);
     
     this.usuarioRestSrv.getUsuarios().subscribe(
      heroesRec => this.usuariosRecibidos = heroesRec
    ); 
  }

}
