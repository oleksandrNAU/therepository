"use strict";
//SIETE
function siete(){
    document.getElementById("intro").value+="7";
    
}
function seis(){
    document.getElementById("intro").value+="6";
    
}
function cinco(){
    document.getElementById("intro").value+="5";
    
}
function cuatro(){
    document.getElementById("intro").value+="4";
    
}
function tres(){
    document.getElementById("intro").value+="3";
    
}
function dos(){
    document.getElementById("intro").value+="2";
    
}
function uno(){
    document.getElementById("intro").value+="1";
    
}
function cero(){
    document.getElementById("intro").value+="0";
    
}function ocho(){
    document.getElementById("intro").value+="8";
    
}
function nueve(){
    document.getElementById("intro").value+="9";
    
}
function multi(){
    document.getElementById("intro").value+="*";
    
}function divi(){
    document.getElementById("intro").value+="/";
    
}
function punt(){
    document.getElementById("intro").value+=".";
    
}
function mas(){
    document.getElementById("intro").value+="+";
    
}
function menos(){
    document.getElementById("intro").value+="-";
    
}
function evalu(){
    let ev= document.getElementById("intro").value;
    
    document.getElementById("intro").value=eval(ev);
}
function del(){
    document.getElementById("intro").value="";
}
function borrar(){
    let texto=document.getElementById("intro");
    texto.value=texto.value.substring(0, texto.value.length - 1);

}
function sin(){
    document.getElementById("intro").value=Math.sin(document.getElementById("intro").value);
    
}
function cos(){
    document.getElementById("intro").value=Math.cos(document.getElementById("intro").value);
    
}