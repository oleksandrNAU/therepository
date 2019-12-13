"use strict";
document.addEventListener("DOMContentLoaded", e=>{
    // document.getElementById("image").addEventListener('change',foto);
   
    let input=document.getElementById("image");
    image.addEventListener('change', event => {
        let file = event.target.files[0];
        let reader = new FileReader();
        if (file) reader.readAsDataURL(file);
        reader.addEventListener('load', a => {
            document.getElementById("imgPreview").src = reader.result;
        });
    });
    const form = document.getElementById('newEvent');
    form.addEventListener('submit', el => {
        
        if (form.name.value!=="") {
            form.name.classList.add("is-valid");
        }
        else{
            form.name.classList.add("is-invalid");
        }
 
              if (form.date.value!=="") {
                form.date.classList.add("is-valid");
            }
            else{
                form.date.classList.add("is-invalid");
            }
     
 
            if (form.description.value!=="") {
                form.description.classList.add("is-valid");
            }
            else{
                form.description.classList.add("is-invalid");
            }
     
            if (form.price.value!=="") {
                form.price.classList.add("is-valid");
              }
              else{
                form.price.classList.add("is-invalid");
              }
              el.preventDefault();
    });
});

// Edita sólo este fichero
// function foto() {
    
// 	let input = document.getElementById("image"); // obtener referencia al input del fichero
// 	let file = input.files[0]; // obtener archivo seleccionado (la foto)
// 	let reader = new FileReader(); // crear un lector de archivo
// 	reader.onload = function () { // cuando ya se ha leido el archivo (la foto)
// 		document.getElementById("imgPreview").src = reader.result; // poner la foto en el preview de foto
// 	};
//     reader.readAsDataURL(file); // inciar la lectura del archivo
    
// };
