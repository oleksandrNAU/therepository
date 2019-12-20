class User {
    constructor(name) {
        this.name = name;    }
        sayHello() {
            console.log('Hola, soy ${this.name}');    }
            sayType() {console.log("Soy un usuario"); 
           }
        }
class Admin extends User {
    constructor(name) {
        super(name); // Llamamos al constructor de User    
    }
    sayType() { // Método sobrescrito
        super.sayType(); // Llamamos a User.sayType (método del padre)
        console.log("Pero también un admin");    }}
        let admin = newAdmin("Anthony");
        admin.sayHello(); // Prints "Hola, soy Anthony"
        admin.sayType(); // Imprime "Soy un usuario" y "Pero también un admi