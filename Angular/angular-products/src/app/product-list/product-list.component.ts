import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {
  title = 'Mi lista de productos';
  headers = {description: 'Producto', price: 'Precio', available: 'Disponible'};
  constructor() { }

  ngOnInit() {
  }

}


