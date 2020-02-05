import { Component } from '@angular/core';
import { ConexionService } from '../conexion.service';
@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss'],
})
export class HomePage {
  busqueda: string="";
  datos: any=[];
  sel: any="2";
  constructor(private conexion: ConexionService) {}
  search(){
    this.conexion.getLook(this.busqueda,this.sel).subscribe(
      resultado=>{
        console.log(resultado);
        this.datos=resultado;
        
        
      }
    )
  }
}
