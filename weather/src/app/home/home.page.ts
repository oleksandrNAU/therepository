import { Component } from '@angular/core';
import { ConexionService } from '../conexion.service';
import { CurrentWeather } from '../current-weather';

@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss'],
})
export class HomePage {
  ciudad:string='';
  lon:number;
  lat:number;
  weather:CurrentWeather;
  constructor(private con:ConexionService) {
    navigator.geolocation.getCurrentPosition(pos => {
      this.lat= pos.coords.latitude;
      this.lon=pos.coords.longitude;
      });
  }
  getTiempo(){
    this.con.getWeather(this.ciudad).subscribe(
      (resultado:CurrentWeather)=>{
        console.log(resultado);
        this.weather=resultado;     
        this.weather.main.temp -=273.15;           
      });
     

}
getTiempo2(){
  this.con.getWeather2(this.lat,this.lon).subscribe(
    (resultado:CurrentWeather)=>{
      console.log(resultado);
      this.weather=resultado;     
      this.weather.main.temp -=273.15;           
    });}

}
