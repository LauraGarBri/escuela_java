import { Component, OnInit, Input } from '@angular/core';
import { Usuario } from '../model/usuario';
import { UsuarioService } from '../usuario.service';
import { RegistroRestService } from '../registro-rest.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-listado',
  templateUrl: './listado.component.html',
  styleUrls: ['./listado.component.css']
})
export class ListadoComponent implements OnInit {

  @Input() usuario: Usuario;
  personasRecibidas: Usuario[];
  listaPersona: Usuario[];
  constructor(private usuariorv: RegistroRestService) { }

  ngOnInit() {
    let obsevArrayPersonas: Observable<Usuario[]>
    this.personasRecibidas = [];
    this.usuariorv.getUsuarios().subscribe(personasRec => {
      this.personasRecibidas = personasRec
    });
    this.getUsuariosFromService();
  }

  getUsuariosFromService(): void {
    this.listaPersona = this.usuariorv.getUsersList();
  }
  save(newUsuario: Usuario): void {
    this.usuariorv.update(newUsuario).subscribe();
  }

  delete(newUsuario: Usuario): void {
    this.usuariorv.delete(newUsuario).subscribe();
  }

}


