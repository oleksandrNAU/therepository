import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';

const URL: string= "https://lookformedical.com/mobile/";
@Injectable({
  providedIn: 'root'
})
export class ConexionService {

  constructor(private http: HttpClient) { }
  getLook(busqueda:string,sel:any){
    console.log(URL+'getdefinitions.php?lang='+sel+'&q='+busqueda);
return this.http.get(URL+ 'getdefinitions.php?lang='+sel+'&q='+busqueda);

  }
}
