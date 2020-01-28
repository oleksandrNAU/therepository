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
      image: 'assets/evento1.jpeg',
      price: 250
    }, {
      title: 'Evento 2',
      description: 'Me quiero ir a casa',
      date: '2020-03-09',
      image: 'assets/evento2.jpg',
      price: 603
    }
  ];


  search = '';

  newEvento: Evento;


  constructor() { }

  ngOnInit() {
    this.inicializarEvento();
  }
  orderDate() {
    this.eventos.sort((e1, e2) => e1.date.localeCompare(e2.date));
    this.eventos = [...this.eventos];
  }

  orderPrice() {
    this.eventos.sort((e1, e2) => e1.price - e2.price);
    this.eventos = [...this.eventos];
  }

  addEvento() {
    this.eventos.push(this.newEvento);
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

