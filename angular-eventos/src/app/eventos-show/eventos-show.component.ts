import { Component, OnInit } from '@angular/core';
import { Evento } from '../interfaces/evento';
import { EventosService } from '../services/eventos.service';

@Component({
  selector: 'app-eventos-show',
  templateUrl: './eventos-show.component.html',
  styleUrls: ['./eventos-show.component.css']
})
export class EventosShowComponent implements OnInit {
  eventos: Evento[] = [];

  search = '';

  constructor(private eventosService: EventosService) { }

  ngOnInit() {
    this.eventosService.getEventos().subscribe(
      eventos => this.eventos = eventos,
      error => console.log(error)
    );
  }

  orderDate() {
    this.eventos.sort((e1, e2) => e1.date.localeCompare(e2.date));
    this.eventos = [...this.eventos];
  }

  orderPrice() {
    this.eventos.sort((e1, e2) => e1.price - e2.price);
    this.eventos = [...this.eventos];
  }

  deleteEvento(evento: Evento) {
    this.eventos = this.eventos.filter(ev => evento !== ev);
  }

  addEvento(evento: Evento) {
    this.eventos.push(evento);
  }
}
