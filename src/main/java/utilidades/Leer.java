package utilidades;

import java.io.*;

public class Leer {

	static public String pedirCadena() {
		BufferedReader datoIntro = new BufferedReader(new InputStreamReader(System.in));
		String dato = "";
		boolean error = true;
		while (error) {
			try {
				dato = datoIntro.readLine();
				error = false;
			} catch (IOException e) {
				System.out.println("introduce el dato otra vez : ");
				error = true;
			}
		}
		return dato;
	}

	static public int pedirEnteroValidar() {
		BufferedReader datoIntro = new BufferedReader(new InputStreamReader(System.in));
		int dato = 0;
		boolean error = true;
		while (error) {
			try {
				dato = Integer.parseInt(datoIntro.readLine());
				error = false;
			} catch (IOException e) {
				System.out.println("introduce el dato de nuevo ");
				error = true;
			} catch (NumberFormatException e) {
				System.out.println("El dato no es entero");
				System.out.println("introduce el dato otra vez : ");
				error = true;
			}
		}
		return dato;

	}

	static public double pedirDecimal() {
		BufferedReader datoIntro = new BufferedReader(new InputStreamReader(System.in));
		double dato = 0;
		boolean error = true;
		while (error) {
			try {
				dato = Double.parseDouble(datoIntro.readLine());
				error = false;
			} catch (IOException e) {
				System.out.println("introduce el dato de nuevo : ");
				error = true;
			} catch (NumberFormatException e) {
				System.out.println("El dato no es entero");
				System.out.println("introduce el dato otra vez : ");
				error = true;
			}
		}
		return dato;
	}

	static public float pedirFloat() {
		BufferedReader datoIntro = new BufferedReader(new InputStreamReader(System.in));
		float dato = 0;
		boolean error = true;
		while (error) {
			try {
				dato = Float.parseFloat(datoIntro.readLine());
				error = false;
			} catch (IOException e) {
				System.out.println("introduce el dato de nuevo: ");
				error = true;
			} catch (NumberFormatException e) {
				System.out.println("El dato no es entero");
				System.out.println("introduce el dato otra vez : ");
				error = true;
			}
		}
		return dato;
	}
}