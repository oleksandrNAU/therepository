package com.oleksandr.eoi0212;
import java.util.Scanner;
/**
 * Hello world!
 * @author Oleksandr Naumov
 */

public class App 
{     
	
	
	public static void main( String[] args )
	{	
		ejercicio7();
	}
	public static void ejercicio2() {
		
    	@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
        System.out.println("introduzca un número");
        int nu = sc.nextInt();
        System.out.println("El número tiene   "+Integer.toString(nu).length()+"   cifras");
	}
	public static void ejercicio2b() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Introduzca un número");
		System.out.println("La cantidad de cifras es: "+sc.nextLine().length());
	}
	public static void ejercicio7() {
	Scanner sc = new Scanner(System.in);
	int z=0;
	int z2=1;
	int suma=0;

	System.out.println("Introduce el primer número:");
	int n=sc.nextInt();
	System.out.println("La serie es: \n1");
	while(n!=1) {
	    suma=z+z2;
	    z=z2;
	    z2=suma;
		n--;
		System.out.println(suma);
	}
	}
  
}
