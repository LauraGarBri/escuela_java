import { Component, OnInit } from '@angular/core';
import { Hero } from '../model/hero';
import {HeroService} from "../hero.service";


@Component({
  selector: 'app-new-hero',
  templateUrl: './new-hero.component.html',
  styleUrls: ['./new-hero.component.css']
})
export class NewHeroComponent implements OnInit {
  heroes: Hero;
  

  constructor(private heroSrv: HeroService) { }

  ngOnInit() {
    //this.heroes = this.heroSrv.nuevoHeroe();
  }

  //Evento onclick
  /*nuevoHeroe(): void {
    this.heroSrv.agregarHeroe(this.heroes);
    this.heroes = this.heroSrv.nuevoHeroe();
  }*/
}
