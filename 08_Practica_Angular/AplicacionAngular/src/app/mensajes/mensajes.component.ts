import { Component, OnInit } from '@angular/core';
import { MensajesService } from '../mensajes.service';

@Component({
  selector: 'app-mensajes',
  templateUrl: './mensajes.component.html',
  styleUrls: ['./mensajes.component.css']
})
export class MensajesComponent implements OnInit {

  //angular genera el servicio y lo inyecta a nuestro componente
  constructor(private mensajeSrv: MensajesService) { }

  ngOnInit() {
  }

}




