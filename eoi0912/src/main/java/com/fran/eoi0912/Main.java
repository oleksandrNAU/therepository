package com.fran.eoi0912;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

// Clase para el tratamiento de ficheros
// Le pongo nombre Main para comprobar que se puede
// y que te puedes llamar a ti mismo
public class Main {

	public static void main(String[] args) throws IOException {

		Main main = new Main();

		// crearFichero();
		// eliminarFichero();
		// leerDirectorio();
		// escribirFicheroJava5();
		// escribirFicheroJava7sinAnaydir();
		// escribirFicheroJava7Anaydiendo();
		// leerBufferedReader();
		// leerFicheroLetraALetra();
		// leerScanner();
		main.guardarFicheroenListaJava8();

	}

	public static void crearFichero() throws IOException {
		File ruta = new File("c:/ficheros");
		File f = new File(ruta, "datos.txt");
		System.out.println(f.getAbsolutePath());
		System.out.println(f.getParent());
		System.out.println(ruta.getAbsolutePath());
		System.out.println(ruta.getParent());
		if (!f.exists()) {
			// se comprueba si el fichero existe o no
			System.out.println("Fichero " + f.getName() + " no existe");
			if (!ruta.exists()) {
				// se comprueba si la ruta existe o no
				System.out.println("El directorio " + ruta.getName() + " no existe");
				if (ruta.mkdir()) {
					// se crea la ruta. Si se ha creado correctamente
					System.out.println("Directorio creado");
					if (f.createNewFile()) {
						// se crea el fichero. Si se ha creado correctamente
						System.out.println("Fichero " + f.getName() + " creado");
					} else {
						System.out.println("No se ha podido crear " + f.getName());
					}
				} else {
					System.out.println("No se ha podido crear " + ruta.getName());
				}
			} else {
				// si la ruta existe creamos el fichero
				if (f.createNewFile()) {
					System.out.println("Fichero " + f.getName() + " creado");
				} else {
					System.out.println("No se ha podido crear " + f.getName());
				}
			}
		} else {
			// el fichero existe. Mostramos el tama�o
			System.out.println("Fichero " + f.getName() + " existe");
			System.out.println("Tama�o " + f.length() + " bytes");
		}
	}

	public static void eliminarFichero() throws IOException {
		Scanner sc = new Scanner(System.in);
		String nombre;
		// Eliminar un fichero
		System.out.println("Introduce el nombre del fichero a eliminar: ");
		nombre = sc.nextLine();
		File ruta = new File("c:/ficheros");
		File f = new File(ruta, nombre);
		if (f.exists()) {
			System.out.println(f.getAbsolutePath());
			if (f.delete()) {
				System.out.println("Fichero eliminado");
			} else {
				System.out.println("No se ha podido eliminar");
			}
		} else {
			System.out.println("El fichero " + f.getAbsolutePath() + " no existe");
		}
		// Cambiar el nombre de un fichero
		String nuevoNombre;
		System.out.println("Introduce el nombre del fichero a renombrar: ");
		nombre = sc.nextLine();
		File f1 = new File(ruta, nombre);
		if (f1.exists()) {
			System.out.println(f1.getAbsolutePath());
			System.out.println("Introduce nuevo nombre: ");
			nuevoNombre = sc.nextLine();
			File f2 = new File(ruta, nuevoNombre);
			if (f1.renameTo(f2)) {
				System.out.println("Se ha cambiado el nombre");
			} else {
				System.out.println("No se ha podido cambiar el nombre");
			}
		} else {
			System.out.println("El fichero " + f1.getAbsolutePath() + " no existe");
		}
	}

	public static void leerDirectorio() throws IOException {
		File directorio = new File(".");
		// directorio actual
		String[] lista = directorio.list();
		for (int i = 0; i < lista.length; i++) {
			System.out.println(lista[i]);
		}
	}

	public static void escribirFicheroJava5() {
		Scanner sc = new Scanner(System.in);
		PrintWriter salida = null;
		try {
			salida = new PrintWriter("c:/ficheros/datos.txt");
			// se crea el fichero
			String cadena;
			System.out.println("Introduce texto. Para acabar introduce la cadena FIN:");
			cadena = sc.nextLine();
			// se introduce por teclado una cadena de texto
			while (!cadena.equalsIgnoreCase("FIN")) {
				salida.println(cadena);
				// se escribe la cadena en el fichero
				cadena = sc.nextLine();
				// se introduce por teclado una cadena de texto
			}
			salida.flush();
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} finally {
			salida.close();
		}

	}

	public static void escribirFicheroJava7sinAnaydir() {
		Scanner sc = new Scanner(System.in);
		String cadena;
		try (PrintWriter salida = new PrintWriter("c:/ficheros/datos.txt")) {
			System.out.println("Introduce texto. Para acabar introduce la cadena FIN:");
			cadena = sc.nextLine();
			while (!cadena.equalsIgnoreCase("FIN")) {
				salida.println(cadena);
				cadena = sc.nextLine();
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void escribirFicheroJava7Anaydiendo() {
		Scanner sc = new Scanner(System.in);
		String cadena;
		try (FileWriter fw = new FileWriter("c:/ficheros/datos.txt", true); PrintWriter salida = new PrintWriter(fw)) {
			System.out.println("Introduce texto. Para acabar introduce la cadena FIN:");
			cadena = sc.nextLine();
			while (!cadena.equalsIgnoreCase("FIN")) {
				salida.println(cadena);
				cadena = sc.nextLine();
			}
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
	}

	public static void leerBufferedReader() {
		FileReader fr = null;
		try {
			fr = new FileReader("c:/ficheros/datos.txt");
			BufferedReader entrada = new BufferedReader(fr);
			String cadena = entrada.readLine();
			// se lee la primera l�nea del fichero
			while (cadena != null) {
				// mientras no se llegue al final del fichero
				System.out.println(cadena);
				// se nuestra por pantalla
				cadena = entrada.readLine();
				// se lee la siguiente l�nea del fichero
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (fr != null) {
					fr.close();
				}
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}

	}

	public static void leerFicheroLetraALetra() {
		FileReader fr = null;
		try {
			fr = new FileReader("c:/ficheros/datos.txt");
			BufferedReader entrada = new BufferedReader(fr);
			int car = entrada.read();
			// se lee el primer car�cter del fichero
			while (car != -1) {
				// mientras no se llegue al final del fichero
				System.out.print((char) car);
				// se nuestra por pantalla
				car = entrada.read();
				// se lee el siguiente car�cter del fichero
			}
			entrada.close();
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (fr != null) {
					fr.close();
				}
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public static void leerScanner() {
		File f = new File("c:/ficheros/datos.txt");
		String cadena;
		Scanner entrada = null;
		try {
			entrada = new Scanner(f);
			// se crea un Scanner asociado al fichero
			while (entrada.hasNext()) {
				// mientras no se alcance el final del fichero
				cadena = entrada.nextLine();
				// se lee una l�nea del fichero
				System.out.println(cadena);
				// se muestra por pantalla
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} finally {
			entrada.close();
		}
	}

	/**
	 * Dado un fichero devuelve un ArrayList donde cada linea es un elemento en
	 * Java7
	 * 
	 * @return
	 */
	public static ArrayList<String> guardarFicheroenListaJava7() {

		ArrayList<String> ficherodevuelto = new ArrayList();
		FileReader fr = null;
		try {
			fr = new FileReader("c:/ficheros/datos.txt");
			BufferedReader entrada = new BufferedReader(fr);
			String cadena = entrada.readLine();
			// se lee la primera  linea del fichero
			while (cadena != null) {

				ficherodevuelto.add(cadena);

				cadena = entrada.readLine();
				// se lee la siguiente  linea del fichero
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (fr != null) {
					fr.close();
				}
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}

		return ficherodevuelto;

	}

	private void guardarFicheroenListaJava8() {
		try {
			List<String> lines = Files.readAllLines(Paths.get("C:/ficheros/datos.txt"), Charset.defaultCharset());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void modificarFicheroenListaJava8() {

		try {
			List<String> lines = Files.readAllLines(Paths.get("C:/ficheros/datos.txt"), Charset.defaultCharset());
			lines.add("Fran es un crack");
			Files.write(Paths.get("C:/ficheros/modificado.txt"), lines);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
