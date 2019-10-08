import { Injectable } from '@angular/core';
import {Hero} from "./model/hero";
import {HEROES} from "./model/array-heros";
import {MessageService} from "./message.service";

@Injectable({
  providedIn: 'root'
})
export class HeroService {
  private arrayheroe: Hero[];

  constructor(private messageSrv : MessageService) {
    this.arrayheroe = HEROES;
   }

  getHeroes(): Hero[] {
    this.messageSrv.add("HeroService: capturando heroes");
    return this.arrayheroe;
  }

  //metodo añadir el nuevo heroe
  add(newhero: Hero) {
    this.arrayheroe.push(newhero);
  }

  getHero(id: number):Hero {
    
   let hero = this.arrayheroe.find(hero => hero.id ===id);
     return hero;
    
  }
}
