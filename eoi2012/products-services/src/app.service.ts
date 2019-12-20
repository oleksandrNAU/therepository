import { Injectable } from '@nestjs/common';
import { Repository } from 'typeorm';
import { Product } from 'entity/product.entity';
import { InjectRepository } from '@nestjs/typeorm';
import { CreateProductDto } from 'dto/create-product.dto';
import * as fs from 'fs';
import * as path from 'path';

@Injectable()
export class AppService {
  constructor(@InjectRepository(Product) private readonly productRepo: Repository<Product>) {}

  private saveImage(photo: string): Promise<string> {
    const data = photo.split(',')[1] || photo;
    return new Promise((resolve, reject) => {
      const filePath = path.join('img', `${Date.now()}.png`);
      fs.writeFile(filePath, data, {encoding: 'base64'}, (err) => {
        if (err) reject(err);
        resolve(filePath);
      });
    });
  }

  getProducts(): Promise<Product[]> {
    return this.productRepo.find();
  }

  async insertProduct(prod: CreateProductDto) {
    prod.photo = await this.saveImage(prod.photo);
    return await this.productRepo.save(prod);
  }

  deleteProduct(id) {
    return this.productRepo.delete(id);
  }
}
