import { Injectable } from '@angular/core';
import { Hero } from './model/hero';
import { HEROES } from './model/array-heros';
import { Observable, of } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class HeroRestService {

  arrayheroe: Hero[];
  urlApiRest = "http://localhost:8084/CRUD_Vista_JSTL/api/heroes";

  constructor(private httpCli: HttpClient) {
    this.arrayheroe = HEROES;
  }

  getHeroes(): Observable<Hero[]> {
    //Aqui no definimos las callback,mejor que las defina donde se necesitan.Devolvemos el 
    //observable para que se pueda gestionar desde fuera del servicio
    return this.httpCli.get<Hero[]>(this.urlApiRest);
  }

  //metodo añadir el nuevo heroe
  add(newhero: Hero) {
    this.arrayheroe.push(newhero);
  }

  getHero(id: number): Hero {

    let hero = this.arrayheroe.find(hero => hero.id === id);
    return hero;

  }
}
