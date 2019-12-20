import { Entity, PrimaryGeneratedColumn, Column } from 'typeorm';

@Entity()
export class Product {
  @PrimaryGeneratedColumn({ unsigned: true })
  id: number;

  @Column('varchar', { length: 200 })
  name: string;

  @Column('varchar', { length: 2000 })
  description: string;

  @Column('varchar', { length: 200 })
  photo: string;
}
