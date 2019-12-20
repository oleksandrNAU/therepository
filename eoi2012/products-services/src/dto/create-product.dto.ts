import { IsString, IsBase64 } from 'class-validator';

export class CreateProductDto {
    @IsString()
    readonly name: string;

    @IsString()
    readonly description: string;

    @IsString()
    photo: string;
}