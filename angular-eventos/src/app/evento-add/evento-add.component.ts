import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { Evento } from '../interfaces/evento';

@Component({
  selector: 'app-evento-add',
  templateUrl: './evento-add.component.html',
  styleUrls: ['./evento-add.component.css']
})
export class EventoAddComponent implements OnInit {
  newEvento: Evento;
  @Output() eventoAdded = new EventEmitter<Evento>();

  constructor() { }

  ngOnInit() {
    this.inicializarEvento();
  }

  addEvento() {
    this.eventoAdded.emit(this.newEvento);
    this.inicializarEvento();
  }

  changeImage(fileInput: HTMLInputElement) {
    if (!fileInput.files || fileInput.files.length === 0) { return; }
    const reader: FileReader = new FileReader();
    reader.readAsDataURL(fileInput.files[0]);
    reader.addEventListener('loadend', e => {
      this.newEvento.image = reader.result as string;
    });
  }

  private inicializarEvento() {
    this.newEvento = {
      title: '',
      description: '',
      image: '',
      price: 0,
      date: ''
    };
  }
}
