package com.oleksandr.eoi16_12;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Persona vacia=new Persona();
        Persona condatos=new Persona(12,"José","3244532A","Terrorista");
        Persona copia=new Persona(condatos);
        
    }
}
