import { Component, OnInit } from '@angular/core';
import { HeroRestService } from '../hero-rest.service';
import { Hero } from '../model/hero';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-hero-rest',
  template: `<h2>LIstado de heroes</h2>
  <ul>
    <li *ngFor = "let hero of heroesRecibidos"> {{hero.id}}-{{hero.name}}</li>
  </ul>`,
  styleUrls: ['./hero-rest.component.css']
})
export class HeroRestComponent implements OnInit {
  heroesRecibidos: Hero[];

  constructor(private heroRestSrv: HeroRestService) { }

  ngOnInit() {
    console.log("1.Empezamos a pedir los datos");
    let observArrayHeroes: Observable<Hero[]>;
    observArrayHeroes = this.heroRestSrv.getHeroes();
    //La ejecucion continua hasta que el array es recibido
    //Para recibirlo asincronamente nos suscribimos al observable

    let funcionAvisameCuandoLoTengas = (heroesRec) =>{
      this.heroesRecibidos = heroesRec
      console.log("3.Hemos recibido los heroes");
    };
    observArrayHeroes.subscribe(funcionAvisameCuandoLoTengas);
    console.log("2.Nos hemos suscrito");
    //En una sola linea se puede hacer todo lo anterior
   // this.heroRestSrv.getHeroes().subscribe(heroesRec => this.heroesRecibidos = heroesRec); 
  }

}