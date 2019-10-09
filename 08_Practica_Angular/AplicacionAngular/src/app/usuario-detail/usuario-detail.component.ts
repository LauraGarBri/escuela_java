import { Component, OnInit, Input } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Usuario } from '../model/usuario';
import { UsuarioService } from '../usuario.service';
import { Location } from '@angular/common';

@Component({
  selector: 'app-usuario-detail',
  templateUrl: './usuario-detail.component.html',
  styleUrls: ['./usuario-detail.component.css']
})
export class UsuarioDetailComponent implements OnInit {

   //Esta propiedad viene de algun componente externo
   @Input() usuario: Usuario; //Declaramos hero 


   constructor(private route: ActivatedRoute,
     private usuarioSrv: UsuarioService,
     private location: Location) { }
 
   ngOnInit(): void {
     this.getUsuario();
   }
   getUsuario(): void {
     // Cogemos el id del parámetro de la url   /detail/:id
     const id = this.route.snapshot.paramMap.get('id');  
     this.usuario = this.usuarioSrv.getUsuario(parseInt(id));
   }

}
