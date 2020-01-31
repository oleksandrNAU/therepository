import { Component, OnInit, Input } from '@angular/core';
import { IProduct } from '../interfaces/i-product';
import { ProductsService } from '../services/products.service';

@Component({
  selector: 'product-item',
  templateUrl: './product-item.component.html',
  styleUrls: ['./product-item.component.css']
})
export class ProductItemComponent implements OnInit {
  @Input() product: IProduct;
  @Input() showImage: boolean;

  constructor(private productsService: ProductsService) { }

  ngOnInit() {
  }

  changeRating(rating: number) {
    this.productsService.changeRating(this.product.id, rating).subscribe(
      resp => this.product.rating = resp.rating);
    }
  }

