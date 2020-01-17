import { Component, OnInit } from '@angular/core';
import { IProduct } from '../interfaces/i-product';

@Component({
  selector: 'product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {
  title = 'Mi lista de productos';
  headers = {description: 'Producto', price: 'Precio', available: 'Disponible'};
  products: IProduct[] = [{
    id: 1,
    description: 'SSD hard drive',
    available: new Date('2016-10-03'),
    price: 75,
    imageUrl: 'assets/ssd.jpg',
    rating: 5
  }, {
    id: 2,
    description: 'LGA1151 Motherboard',
    available: new Date('2016-09-15'),
    price: 96.95,
    imageUrl: 'assets/motherboard.jpg',
    rating: 4
  }];
  constructor() { }

  ngOnInit() {
  }

}


