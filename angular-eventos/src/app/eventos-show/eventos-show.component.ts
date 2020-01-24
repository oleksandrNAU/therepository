import { Component, OnInit } from '@angular/core';
import { Evento } from '../interfaces/evento';

@Component({
  selector: 'app-eventos-show',
  templateUrl: './eventos-show.component.html',
  styleUrls: ['./eventos-show.component.css']
})
export class EventosShowComponent implements OnInit {
  eventos: Evento[] = [
    {
      title: 'Evento 1',
      description: 'Buen evento prem',
      date: '2020-05-16',
      image: '',
      price: 250
    }, {
      title: 'Evento 2',
      description: 'Me quiero ir a casa',
      date: '2020-03-09',
      image: '',
      price: 603
    }
  ];

  constructor() { }

  ngOnInit() {
  }

}

