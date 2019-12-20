import { Get, Controller, Post, Body, ValidationPipe, Request, Param, Delete, HttpCode } from '@nestjs/common';
import { AppService } from './app.service';
import { CreateProductDto } from 'dto/create-product.dto';

@Controller()
export class AppController {
  constructor(private readonly appService: AppService) {}

  @Get()
  root(): string {
    return 'Product services!';
  }

  @Get('products')
  async getProducts() {
    const products = await this.appService.getProducts();
    return {products};
  }

  @Post('products')
  async postProduct(
    @Body(new ValidationPipe({ transform: true })) prodDto: CreateProductDto,
  ) {
    const prod = await this.appService.insertProduct(prodDto);
    return {product: prod};
  }

  @Delete('products/:id')
  @HttpCode(204)
  removeProduct(@Param('id') id) {
    this.appService.deleteProduct(id);
  }
}
