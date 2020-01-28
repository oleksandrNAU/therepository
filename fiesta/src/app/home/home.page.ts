import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss'],
})
export class HomePage {
 private nombre:string;
 private apellidos:string;
  private edad:string;
  private traes:string;
  constructor( private http:HttpClient) {}
  enviar(){
    console.log("hi");
    this.http.get('https://www.cursojava2019.best/formulario.php?nombre='
    +this.nombre+'&apellidos='+this.apellidos+'&edad='+this.edad+'&traes='+this.traes).subscribe((res:any) => {
      console.log("Devolu"+res);
    }); 
  }
}
