import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

const URL:string='http://api.openweathermap.org/data/2.5/';
const KEY:string='9a392945804efd9f8c9a2f6313199ed6';
@Injectable({
  providedIn: 'root'
})
export class ConexionService {

  
  constructor(private http: HttpClient) {
    
   }

  getWeather(ciudad:string){
  
  
    return  this.http.get(URL+'weather?q='+ciudad+'&appid='+KEY);
  }
  getWeather2(lat:number,lon:number){
  
  return  this.http.get(URL+'weather?lat='+lat+'&lon='+lon+'&appid='+KEY);}
 
}
