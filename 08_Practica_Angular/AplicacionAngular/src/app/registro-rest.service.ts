import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Usuario } from './model/usuario';
import { UsuarioDetailComponent } from './usuario-detail/usuario-detail.component';
import { catchError, map, tap } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class RegistroRestService {

  urlApiRest = "http://localhost:8084/CRUD_Vista_JSTL/api/users";
  httpOptions ={  
    headers: new HttpHeaders({'Content-Type':"application/json"})
  };


  userList: Usuario[];
  constructor(private httpCli: HttpClient) {
    this.getUsersList();
  }



  getUsuarios(): Observable<Usuario[]> {
    let observResp = this.httpCli.get<Usuario[]>(this.urlApiRest);
    return observResp;
  }
  // metodo añadir el nuevo user

  getUsersList(): Usuario[] {
    return this.userList;
  }

  

  //metodo añadir el nuevo usuario
  add(newUsuario: Usuario):Observable<Usuario> {
    return this.httpCli.post<Usuario>(this.urlApiRest,newUsuario,this.httpOptions);
  }

  //metodo para modificar usuario
  update(usuario: Usuario):Observable<Usuario> {
    return this.httpCli.put<Usuario>(this.urlApiRest,usuario,this.httpOptions);
  }

  //metodo para eliminar usuario
  delete(usuario : Usuario): Observable<Usuario> {
    this.httpOptions['body'] = usuario;
    return this.httpCli.delete<Usuario>(this.urlApiRest,this.httpOptions)
  }

  
}