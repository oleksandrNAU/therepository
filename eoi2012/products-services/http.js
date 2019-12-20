fetch("http://localhost:3000/products")
.then(resp=>{
    console.log(resp.status);
    console.log(resp.ok);
    return resp.json();
    
}).then(json=> console.log(json.products));