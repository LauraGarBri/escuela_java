import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Usuario } from './model/usuario';

@Injectable({
  providedIn: 'root'
})
export class RegistroRestService {

  urlApiRest = "http://localhost:8084/CRUD_Vista_JSTL/api/users";
  httpOptions ={  
    headers: new HttpHeaders({'Content-Type':"application/json"})
  };

  constructor(private httpCli: HttpClient) {

  }

  getUsuarios(): Observable<Usuario[]> {
    //Aqui no definimos las callback,mejor que las defina donde se necesitan.Devolvemos el 
    //observable para que se pueda gestionar desde fuera del servicio
    return this.httpCli.get<Usuario[]>(this.urlApiRest);
  }

  //metodo añadir el nuevo heroe
  add(newUsuario: Usuario):Observable<Usuario> {
    return this.httpCli.post<Usuario>(this.urlApiRest,newUsuario,this.httpOptions);
  }
}