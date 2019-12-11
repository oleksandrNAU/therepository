'use strict';

/**
 * Apartado 1
 * Realiza los siguientes pasos (muestra por consola el resultado después de aplicar cada uno):
 * - Crea un array con 4 elementos
 * - Concatena 2 elementos más al final y 2 al principio
 * - Elimina las posiciones de la 3 a la 5 (incluida)
 * - Inserta 2 elementos más entre el penúltimo y el último
 * - Muestra el array del paso anterior, pero con los elementos separados por "==>"
 */

console.log('--------------- APARTADO 1 -----------------');
let a=Array("A","B","C","D");
console.log("Array original: "+a.join());
let b=Array("AA","BB");
let c=Array("E","F");
let d=b.concat(a);
let e=d.concat(c);// tambien se podía hacer con .push es decir a.push("AA","BB")
console.log("Array concatenado:   "+e.join());
e.splice(3,3);// perfecto
console.log("Array depúes de eliminar:  "+e.join());
e.splice(e.length-1,0,"X","Y");//bien se podia tmb con solo -1
console.log("Array con elementos en medio:  "+e.join());
console.log("Array con elementos en medio:  "+e.join("==>"));// perfecto

/**
 * Apartado 2
 * Crea una función que reciba 2 parámetros. El primero será el nombre de una persona,
 * y el segundo serán los trabajos que ha realizado esa persona (usa rest para agruparlos en un array).
 * Posible llamada -> printTrabajos("Pepe", "Albañil", "Programador", "Buscador de tesoros")
 * La función simplemente mostrará por consola el nombre y los trabajos recorriéndolos con un for..of
 */

console.log('--------------- APARTADO 2 -----------------');

function ejercicio2(nombre,...trabajos){
    console.log(nombre);
    
    for(let trabajo of trabajos){
    console.log("\t"+trabajo);//para tabular y que quede mas bonito
    
}
}
ejercicio2("Pepe","Bailador","Programador","Escritor","Abogado");
ejercicio2("Ivan","Mamporrero","Astronauta","Escritor","Abogado");
/**
 * Apartado 3
 * A partir del siguiente array que contiene productos con mensajes sobre los mismos:
 * - Filtra los mensajes que empiecen por ERROR (usa el método startsWith).
 * - Después recórrelos y mételos en un objeto Map cuya clave sea el nombre del producto
 * y cuyo valor sea un array con los mensajes de error asociados al producto.
 * - Recorre el objeto Map mostrando, para cada producto, que errores tiene asociados.
 */

console.log('--------------- APARTADO 3 -----------------');

let mensajes = [
    ['Silla', 'ERROR: Stock no coincide'],
    ['Mesa', 'Pedido de 2 unidades'],
    ['Silla', 'ERROR: El precio no puede ser menor a 1'],
    ['Mesa', 'ERROR: No se pueden enviar 0 unidades'],
    ['Cama', 'ERROR: El fabricante no tiene ese modelo'],
    ['Silla', 'Se ha borrado el producto de la base de datos']
];
let i=0;
let r=1;
let j=0;
let productos= new Map();
for(i=0;i<mensajes.length;i++){
    for(j=0;j<mensajes[i].length;j++){
        if(mensajes[i][j].toString().startsWith("ERROR")){
  //      console.log(mensajes[i][0]);
        productos.set(r+" "+mensajes[i][0],mensajes[i][j]);
        r++;  }}}
for(let entry of productos) { 

           console.log(entry.join(": "));    
        } 

console.log('--------------- APARTADO 3 SOLUCIÓN-----------------');
/*De estos arrays internos quedate con los que empiezen po ERROR el forEach le dice que cada elemento es un 
*array, al saber que son dos elemntos mas rápido le pone producto mensaje 
*sino deberia ser array=>{if(...array[0])}.... en cambio pone prod msg para que se vea mas claro
*
*/
let msgMap= new Map();
mensajes.filter(m=> m[1].startsWith("ERROR")).forEach(([prod,msg])=>{
    if(!msgMap.has(prod)){
        msgMap.set(prod,[msg]);
    } else{
        msgMap.get(prod).push(msg);
    }
});
for(let entr of msgMap){
    console.log(entr.join("=> "));  
}


/**
 * Apartado 4
 * Crea una función calcule el área de un triángulo. Esta función recibirá 3 parámetros:
 * 2 lados del triángulo, y el ańgulo entre ellos (en grados).
 * Para calcular el área con estos datos debemos aplicar la fórmula: (1/2)*lado1*lado2*seno(ángulo).
 * Debes tener en cuenta que para aplicar la fórmula, el ángulo debe estar en radianes. Para pasarlo
 * a radianes lo multiplicamos por PI y dividimos entre 180.
 */

console.log('--------------- APARTADO 4 -----------------');
function ejercicio4(lado1,lado2,angulo){
    if(isNaN(lado1) || isNaN(lado2)|| isNaN(angulo) || angulo>=360 || angulo<0){
            console.error("Introduzca los datos correctos...");
            return;
    }
    let angulor=angulo*Math.PI/180;
    let area=1/2*lado1*lado2*Math.sin(angulor);
    console.log("Las medidas de su triángulo son:\n  lado1 \t"+lado1+"\n  lado2 \t"+lado2+"\n  ángulo \t"+ angulo+"º\nEl área de su triángulo es: "+area);
}
ejercicio4(1,2,89);
ejercicio4(1,2,890);
ejercicio4("uu",2,89);
ejercicio4(10,22,50);
/**
 * Apartado 5
 * Crea una función que reciba una cadena con una fecha en formato "YYYY-MM-DD". Muestra la fecha (ej: 2019-02-28) con
 * el siguiente formato: Jueves, 28 de Febrero de 2019.
 * Debes formatear la fecha usando los métodos de la clase Date para obtener, día de la semana, día del mes, mes, y año.
 * No puedes usar librerías como moment.js para ayudarte.
 * Para mostrar el nombre del mes o del día de la semana, puedes crearte un array que los contenga (los días de la semana empiezan por domingo -> 0)
 * Métodos de la clase Date: https://www.w3schools.com/jsref/jsref_obj_date.asp
 * Llama a la función varias veces.
 */

console.log('--------------- APARTADO 5 -----------------');

function ejercicio5(fecha){
    let date= new Date(fecha);
    let dias=[ "Lunes","Martes","Miércoles","Jueves","Viernes","Sábado","Domingo"];
    let meses=["Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"];
    console.log(dias[date.getDay()]+", "+date.getDate()+" de "+meses[date.getMonth()]+" de "+date.getFullYear());
}
ejercicio5("2019-01-21");
ejercicio5("2019/01/28");