package com.oleksandr.eoilambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Hello world!
 *
 */

public class App 
{
	public static ArrayList <User> usuarios;
	 public static void setUp() {
	     usuarios = new ArrayList<>();
	     usuarios.add(new User("Fernando",1));
	     usuarios.add(new User("Fran",2));  
	     usuarios.add(new User("Arturo",3));
	     usuarios.add(new User("Masi",4));
	     usuarios.add(new User("Jose",5));
	     usuarios.add(new User("Masi",6));
	    }
	     
    public static void main( String[] args )
    {
       // ()-> "Mi nombre es";
    	
    	MiNombre miNombreAnonima = new MiNombre() {
    		@Override
    		public String miNombre() {
    			
    			return "Fran anónimo";
    		}
    		
    	};
    	System.out.println(miNombreAnonima.miNombre());
    	
    	//Lo de antes con Lambdas
    	MiNombre miNombreLambda=()->"Fran Lambda"+"hola";
    	System.out.println(miNombreLambda.miNombre());
    	setUp();
		usuarios.stream()
		.filter(e->e.getNombre().length() >=3)
    	.forEach(e->System.out.println(e.getNombre()));
    	
		Stream stream = Stream.of(usuarios);
		usuarios.stream();
		// Líneas equivalentes
		usuarios.stream()
    	.forEach(e->System.out.println(e.getNombre()+ " García"));
		
		//JAVA 8
		List <String> nombre = usuarios.stream().map(e->e.getNombre()).collect(Collectors.toList());
		System.out.println("La cantidad de nombres son: "+nombre.size());
		
		// JAVA 5
		List<String> nombresfor=new ArrayList<>();
		for(User u:usuarios) {
			nombresfor.add(u.getNombre());
			
		}
		//filter
		List<User> usersfiltrados=usuarios.stream()
				.filter(e->e.getNombre().length()>=3)// mas de dos letras
				.filter(e->e.getId()%2==0)//los id pares
				.collect(Collectors.toList());
		imprimirLista(usersfiltrados);
		// Crear lisra  de aquellos nombres que empiezen por F e imprimir
		List<User> userf= usuarios.stream()
				.filter(e->e.getNombre().startsWith("F"))
				.collect(Collectors.toList());
		imprimirLista(userf);
		// se obtiene cantidad
		long nombresconF=usuarios.stream()
		.filter(e->e.getNombre().startsWith("F"))
		.count();
		System.out.println(nombresconF);
		
		//findfirst, devuelve un objeto del conjunto de objetos que le pasamos
		// se puede trabajar con Optional o orelse
		
		Optional<User> primero=usuarios.stream()
				.filter(e->e.getNombre().equals("Masi"))
				.findFirst();
		User primero2=usuarios.stream()
				.filter(e->e.getNombre().equals("Masi"))
				.findFirst()
				.orElse(null);
		System.out.println(primero+"\n"+primero2);
		List<String> cadenas=new ArrayList<String>();
		List<List<String>> listaDeListas= new ArrayList<List<String>>(Arrays.asList(
				new ArrayList<String>(Arrays.asList("Fran","Masi")),
				new ArrayList<String>(Arrays.asList("Masi","Arturo"))
				));
		
		List<String> lista1= new ArrayList<String>();
		lista1.add("Fran");
		lista1.add("Masi");
		List<String> lista2= new ArrayList<String>();
		lista2.add("Masi");
		lista2.add("Arturo");
		List<List<String>> listaDeListas2=
				new ArrayList<List<String>>();
		listaDeListas2.add(lista1);
		listaDeListas2.add(lista2);
		
		List<String> nombres3=listaDeListas2.stream()
				.flatMap(e->e.stream())
				.collect(Collectors.toList());
		System.out.println("Imprimierndo nombres 3:");
		imprimirCadena(nombres3);
		//listaDeListas.add(cadenas); 
		
		//peek
		//Actua como foreach pero no es final 
		
		List<User> user2= usuarios.stream()
				.peek(e->e.setNombre(e.getNombre() + " Apellido"))
				.collect(Collectors.toList());
		System.out.println("Imprimiendo users2: ");
		imprimirLista(user2);
		
		//Skip y Limit
		//Skip salta un número de elementos
		//Limit limita el número de resultados
		String[] abd= {"a","b","c","d","e","f","g","h"};
		List<String> abdfiltrado= Arrays.stream(abd)
				.skip(2)
				.limit(4)
				.collect(Collectors.toList());
		System.out.println("Imprimir abdfiltrado:");
		imprimirCadena(abdfiltrado);
		
		//sorted
		List<User> ordenada1=usuarios.stream()
				.sorted(Comparator.comparing(User::getId))
				.collect(Collectors.toList());
		System.out.println("Imprimir ordenada:");
		imprimirLista(ordenada1);
		List<User> ordenada2=usuarios.stream()
				.sorted(Comparator.comparing(User::getId).reversed())
				.collect(Collectors.toList());
		System.out.println("Imprimir imprimir ordenada al reves:");
		imprimirLista(ordenada2);
		
		//distint
		String[] abcduplicados= {"a","b","c","d","e","f","g","h"};
		List<String> abcfiltrado2=Arrays.stream(abcduplicados)
				.distinct()
				.collect(Collectors.toList());
		System.out.println("Imprimir abcfiltrado2");
		imprimirCadena(abcfiltrado2);
		
		//allMath, anyMatch, noneMatch
		// devuelve valores booleanos, true o false
		
		boolean allMatch=usuarios.stream()
				.map(e->e.getNombre())
				.allMatch(e->e.length()>=3);
		if(allMatch)
			System.out.println("Todos tienen mas de 3 letras");
		else
			System.out.println("No todos tienen mas de 3 letras");
		
		boolean anyMatch=usuarios.stream()
				.map(e->e.getNombre())
				.anyMatch(e->e.length()>=7);
		if(anyMatch)
			System.out.println("Alguno tiene mas de 7 letras");
		else
			System.out.println("ninguno tiene mas de 7 letras");
		
		boolean noneMatch=usuarios.stream()
				.map(e->e.getNombre())
				.noneMatch(e->e.length()>=7);
		if(noneMatch)
			System.out.println("ninguno tiene mas de 7 letras");
		else
			System.out.println("alguno tiene mas de 7 letras");
    }
    
    public static void imprimirLista(List<User> lista) {
    	lista.stream().forEach(e->System.out.println(e));
    	
    }
    public static void imprimirCadena(List<String> lista) {
    	lista.stream().forEach(e->System.out.println(e));
    }
   
}