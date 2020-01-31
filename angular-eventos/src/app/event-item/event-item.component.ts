import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { Evento } from '../interfaces/evento';
import { EventosService } from '../services/eventos.service';

@Component({
  selector: 'app-evento-item',
  templateUrl: './event-item.component.html',
  styleUrls: ['./event-item.component.css']
})
export class EventoItemComponent implements OnInit {
  @Input() evento: Evento;
  @Output() deleted = new EventEmitter<void>();

  constructor(private eventosService: EventosService) { }

  ngOnInit() {
  }

  deleteEvento() {
    this.eventosService.deleteEvento(this.evento.id).subscribe(
      () => this.deleted.emit(),
      error => console.log(error)
    );
  }
}
