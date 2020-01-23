import { Component } from '@angular/core';
import { LoadingController } from '@ionic/angular';
@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss'],
})
export class HomePage {
  reorder: boolean;
  list: any;
  text: string;
  constructor(public loadingController:LoadingController) {
    this.reorder = false;
    this.text = "";
    this.list = localStorage.getItem('places-list');
    if (this.list!=='undefined' && this.list!==null) this.list = JSON.parse(this.list);
    else this.list = [];
  }
  async add(event?) {
    let loading = await this.loadingController.create({duration:30000});
    loading.present();
    let text = this.text, list = this.list, save = this.save;
    this.text = "";
    navigator.geolocation.getCurrentPosition(pos => {
      let url = "https://maps.google.com/maps?&z=15&t=k&q="+pos.coords.latitude+" "+pos.coords.longitude;
      if (event) {
        let reader = new FileReader();
        reader.onload = (data:any) => {
          list.unshift({ name:text, img:data.target.result, url:url });
          loading.dismiss();
          save(list);
        }
        reader.readAsDataURL(event.target.files[0]);
      }
      else {
        (<any>navigator).camera.getPicture(function success(data) { 
          list.unshift({ name:text, img:"data:image/jpeg;base64,"+data, url:url });
          loading.dismiss();
          save(list);
        }, function error(msg) {
          loading.dismiss();
        }, { targetWidth:100, destinationType:(<any>navigator).camera.DestinationType.DATA_URL });
      }
    });
  }
  save(list) {
    localStorage.setItem('places-list', JSON.stringify(list));
    location.href = "index.html";
  }
  delete(item) {
    this.list.splice(item, 1);
    this.save(this.list);
  }
  move(indexes) {
    let item = this.list[indexes.from];
    this.list.splice(indexes.from, 1);
    this.list.splice(indexes.to, 0, item);
    this.save(this.list);
    indexes.complete();
  }
}