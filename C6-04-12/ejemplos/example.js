document.addEventListener("DOMContentLoaded", e=>{
console.log(document.querySelector("#div1 a").title); // Imprime "hello world"
//  console.log(document.querySelector("#div1 > a").title); // ERROR: No hay un hijo inmediato dentro de <div id="div1"> el cual sea enlace <a>
 console.log(document.querySelector("#div1 > p > a").title); // Imprime "hello world"
 console.log(document.querySelector(".normalLink[title^='bye']").title); // Imprime "bye world" empieza bye
 console.log(document.querySelector(".normalLink[title^='bye'] + a").title); // Imprime "hello again" empieza por bye el siguiente a
 let elems = document.querySelectorAll(".normalLink"); 
 elems.forEach(function(elem) { // Imprime "hello world" y "bye world"
 console.log(elem.title);});
 let elems2 = document.querySelectorAll("a[title^='hello']"); // Atributo title empieza por “hello...” a que empieza su atr por bye
 elems2.forEach(function(elem) { // Imprime "hello world" y "hello again"
 console.log(elem.title);});
 elems2 = document.querySelectorAll("a[title='hello world'] ~ a"); // Hermanos de <a title="hello world">
 elems2.forEach(function(elem) { // Imprime "bye world" y "hello again"
 console.log(elem.title);});});