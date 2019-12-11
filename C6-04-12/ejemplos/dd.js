"use strict";
let li=document.getElementById("lista").firstElementChild;
while(li !==null){
    console.log(li);
    li=li.nextElementSibling;// recorriendo iterador
}