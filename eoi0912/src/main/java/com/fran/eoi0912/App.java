package com.fran.eoi0912;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
	static Scanner sc = new Scanner(System.in);
    public static void main( String[] args )
    {
    	// Integer es un Wrapper de int
    	ArrayList<Integer> arraylist = new ArrayList<Integer>();
    	arraylist.add(4);
    	arraylist.add(7);
    	arraylist.add(9);
    	ArrayList<String> lista = new ArrayList<String>();
    	lista.add("1. Insertar");
    	lista.add("2. Borrar");
    	lista.add("3. Actualizar");
    	lista.add("FRan");
    	lista.add("Dani");
    	ejemploArrayList(lista);
    	/*menu(lista);
    	
    	int opcion=0;	
    	
        //sumar(2,3);
        //sumar(7,8,9,10,11);
    	do {
    		menu("Salir","Insertar","Borrar","Actualizar");
    		opcion = sc.nextInt();
    		sc.nextLine();
    	}while(opcion!=0);*/
    	
    }
    
    // Suma una cantidad variable de elementos Integer
    public static int sumar(ArrayList<Integer> numeros) {
    	int resultado=0;
    	for(Integer numero: numeros) {
    		resultado += numero;
    	}
    	return resultado;
    }
    
    // Parámetro variables
    public static void sumar(int... numeros) {
    	int resultado=0;
    	for(int i=0;i<numeros.length;i++) {
    		resultado += numeros[i];
    	}
    	System.out.println("El resultado es: " + resultado);    	
    }
    
    // menú dinámico
    public static void menu(String...strings) {
    	for(int i=0;i<strings.length;i++) {
    		System.out.println((i+1) + ". " + strings[i]);
    	}    	
    }
    
    public static void menu(List<String> lista) {
    	for(String elemento: lista) {
    		System.out.println(elemento);
    	}
    }
    
    public static void ejemploArrayList(ArrayList<String> pruebas) {
    	
    	// Imprime el primer elemento de la lista
    	System.out.println(pruebas.get(0));
    	// Ordenar lista
    	pruebas.sort(null);
    	System.out.println(pruebas.toString());
    	// Ordenar inversamente
    	pruebas.sort(Collections.reverseOrder());	// A efectos de ordenacion
    	System.out.println(pruebas.toString());
    	Collections.reverse(pruebas);	// Le da la vuelta al ArrayList
    	System.out.println(pruebas.toString());
    	
    	// 2 arrayList apuntando a los mismos elementos
    	ArrayList<String> array1 = new ArrayList<String>();
    	ArrayList<String> array2 = array1;
    	
    	array1.add("Fran");
    	array2.add("Dani");
    	System.out.println(array1.toString());
    	System.out.println(array2.toString());
    	
    	// Crear arrayList a partir de otro ArrayList
    	ArrayList<String> array3 = new ArrayList<String>();
    	array3.add("Paco");
    	array3.add("Pepe");
    	ArrayList<String> array4 = new ArrayList<String>(array3);
    	System.out.println(array4);
    	
    	// eliminar objetos, cadenas o posicional
    	array4.remove("Paco");
    	array4.remove(0);
    	System.out.println(array4);
    	
    	// 2 formas de borrar el ArrayList
    	for(int i = 0; i<array3.size();i++) {
    		array3.remove(0);	// Borra un arrayList entero
    	}
    	array3.clear();
    	
    	// 2 formas de hacer lo mismo
    	if(array3.size()==0) {
    		System.out.println("Está vacío");
    	}
    	else {
    		System.out.println("No está vacío");
    	}
    	
    	// operador ternario
    	System.out.println((array3.size()==0)?"Está vacío":"No está vacío");
    	System.out.println(array3.isEmpty()?"Está vacío":"No está vacío");
    	
    	int elementos = array3.isEmpty()?100:array3.size();
    	System.out.println(elementos);
    	
    	System.out.println(array3.isEmpty()?"Ninguno":(array3.size()>0 && array3.size()<6)?"Pocos":"Muchos");
    	
    	
    	boolean encontrado = false;
    	for(String cadena : pruebas) {
    		if(cadena.equalsIgnoreCase("fran")) {
    			System.out.println("hola Fran");
    			encontrado = true;
    		}
    	}
    	if(encontrado==false) {
    		System.out.println("No hay Fran");
    	}
    	
    	
    	   	
    }
    
}
