"use strict"
function pulsa(){
        
        let name = prompt("Pon mensaje premo", "nom");
        let text= document.createTextNode("Tu nombre es "+name);
        let p=document.getElementsByTagName("p")[0];
        if(p.innerText==false){
        p.appendChild(text);}
        else{
          return;
        }
}