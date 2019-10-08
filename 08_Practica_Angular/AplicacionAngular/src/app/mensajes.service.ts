import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class MensajesService {

  mensajes: string[] = []; //new Array

  add(mensaje: string ):void{
    this.mensajes.push(mensaje);
  }
  clear(): void{
    this.mensajes = [];
  }
}
