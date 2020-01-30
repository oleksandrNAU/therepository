import { Component, OnInit, OnDestroy } from '@angular/core';
import { IProduct } from '../interfaces/i-product';
import { ProductsService } from '../services/products.service';

@Component({
  selector: 'product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {
  title = 'Mi lista de productos';
  showImage = true;
  headers = {
    description: 'Descripción',
    price: 'Precio',
    available: 'Disponible',
    image: 'Imagen'
  };
  products: IProduct[] = [];

  search = '';

  constructor(private productsService: ProductsService) { }

  ngOnInit() {
    this.productsService.getProducts().subscribe(
      resp => {
        console.log(resp);
        this.products = resp.products;
      }
    );
  }

  mostrarImagenes() {
    this.showImage = !this.showImage;
  }

}

