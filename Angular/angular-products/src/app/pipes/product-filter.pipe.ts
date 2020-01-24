import { Pipe, PipeTransform } from '@angular/core';
import { IProduct } from '../interfaces/i-product';
@Pipe({
  name: 'productFilter'
})
export class ProductFilterPipe implements PipeTransform {

  transform(products: IProduct[], search: string): any {
    if (search !== '') {
      return products.filter(p => p.description.toLocaleLowerCase().includes(
        search.toLocaleLowerCase()
      ));
    }

    return products;
  }

}
