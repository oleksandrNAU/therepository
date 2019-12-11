'use strict';
//Window:


// Tamaño total de la ventana (excluye la barra superior del navegador)
console.log(window.outerWidth + " - " + window.outerHeight);
//window.open("https://www.google.com");
// Propiedades de la pantalla
console.log(window.screen.width + " - " + window.screen.height); // Ancho de pantalla y alto
console.log(window.screen.availWidth + " - " + window.screen.availHeight); // Excluye la barra del S.O.
// Propiedades del navegador
console.log(window.navigator.userAgent); // Imprime la información del navegador
window.navigator.geolocation.getCurrentPosition(function(position) {
console.log("Latitude: " + position.coords.latitude + ", Longitude: " + position.coords.longitude);
});
// En las variables globales podemos omitir el objeto window (está implícito)
console.log(history.length); // Número de páginas del history. Lo mismo que window.history.length


//Timers: programación asíncrona

//let timeout = setTimeout(() => console.log(new Date().toString()), 5000); // Se ejecutará en 5 segundos (5000 ms)
//console.log(new Date().toString()); // Imprime inmediatamente la fecha actual
//clearTimeout(timeout); // cancelar timeout

//let num = 1;
//setInterval(() => console.log(num++), 1000); // Imprime un número y lo incrementa cada segundo
//let num = 1;
//let idInterval = setInterval(() => {
//console.log(num++);
  //  if(num > 10) { // Cuando imprimimos 10, paramos el timer para que no se repita más
    //    clearInterval(idInterval);
  //  }
   // }, 1000);


//Objeto location

console.log(location.href); // Imprime la URL actual
console.log(location.host); // Imprime el nombre del servidor (o la IP) como “localhost” 192.168.0.34
console.log(location.port); // Imprime el número del puerto (normalmente 80)
console.log(location.protocol); // Imprime el protocolo usado (http ó https)
//location.reload(); // Recarga la página actual
//location.assign("https://google.com"); // Carga una nueva página. El parámetro es la nueva URL
//location.replace("https://google.com"); // Carga una nueva página sin guardar la actual en el objeto
