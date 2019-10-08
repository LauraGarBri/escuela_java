import { Injectable } from '@angular/core';
import { Hero } from './model/hero';
import { HEROES } from './model/array-heros';
import { Observable, of } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class HeroRestService {


  urlApiRest = "http://localhost:8084/CRUD_Vista_JSTL/api/heroes";
  httpOptions ={  
    headers: new HttpHeaders({'Content-Type':"application/json"})
  };

  constructor(private httpCli: HttpClient) {

  }

  getHeroes(): Observable<Hero[]> {
    //Aqui no definimos las callback,mejor que las defina donde se necesitan.Devolvemos el 
    //observable para que se pueda gestionar desde fuera del servicio
    return this.httpCli.get<Hero[]>(this.urlApiRest);
  }

  //metodo añadir el nuevo heroe
  add(newhero: Hero):Observable<Hero> {
    return this.httpCli.post<Hero>(this.urlApiRest,newhero,this.httpOptions);
  }
}
