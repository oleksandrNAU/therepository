import { Injectable } from '@angular/core';
import { IProduct } from '../interfaces/i-product';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ResponseProducts, ResponseRating } from '../interfaces/responses';

@Injectable({
  providedIn: 'root'
})
export class ProductsService {

  constructor(private http: HttpClient) { }

  getProducts() {
    return this.http.get<ResponseProducts>('http://arturober.com:5001/products');
  }

  changeRating(id: number, rating: number) {
    return this.http.put<ResponseRating>(`http://arturober.com:5001/products/${id}/rating`, {rating});
  }
}
