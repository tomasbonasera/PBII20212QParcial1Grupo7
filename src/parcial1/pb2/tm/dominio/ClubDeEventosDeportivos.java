package src.parcial1.pb2.tm.dominio;

import java.util.Scanner;

import enums.parcial1.pb2.tm.dominio.DistanciaPreferida;
import enums.parcial1.pb2.tm.dominio.EstiloPreferido;
import enums.parcial1.pb2.tm.dominio.TipoDeBicicleta;

public class ClubDeEventosDeportivos {

	public static Scanner teclado = new Scanner(System.in);
	public static Administracion administrador = new Administracion();
	public static Boolean bucle1 = true;
	public static Boolean bucle2 = true;
	public static Boolean bucle3 = true;

	public static void main(String[] args) {

		System.out.println("Bienvenidos al Club\n");

		do {
			primerMenu();
		} while (bucle1);

	}

	public static void primerMenu() {
		do {
			System.out.println("****************");
			System.out.println("(1) Registrarse");
			System.out.println("(2) Ingresar");
			System.out.println("****************");
			Integer opciones1 = teclado.nextInt();

			switch (opciones1) {
			case 1:
				do {
					System.out.println("Registrarse como...");
					System.out.println("1) Deportista");
					System.out.println("2) Veedor");
					Integer opciones2 = teclado.nextInt();
					switch (opciones2) {
					case 1:
						bucle2 = false;
						menuDeportista1();

						break;

					case 2:
						bucle2 = false;
						menuVeedor();

						break;

					default:
						System.out.println("opcion incorrecta");
						break;
					}
				} while (bucle2);
				break;

			case 2:
				System.out.println("Ingrese nombre de usuario:");
				String usuarioIngresado = teclado.next();
				System.out.println("Ingrese contraseña:");
				String contraseñaIngresada = teclado.next();

				Boolean ingreso = administrador.VerificarIngreso(usuarioIngresado, contraseñaIngresada);
				if (ingreso == true) {
					System.out.println("se ha ingresado correctamente");
				} else {
					System.out.println("ocurrio un error");
				}
				break;
			default:
				System.out.println("opcion incorrcta");
				break;
			}
		} while (bucle1);
	}

	public static void menuDeportista1() {
		System.out.println("Registrarse como...");
		System.out.println("1. Nadador");
		System.out.println("2. Corredor");
		System.out.println("3. Ciclista");
		Integer opcion3 = teclado.nextInt();
		switch (opcion3) {
		case 1:
			bucle3 = false;
			System.out.println("\nIngrese su nombre:");
			String nombre = teclado.next();
			System.out.println("Ingrese su apellido:");
			String apellido = teclado.next();
			System.out.println("Ingrese un nombre de usuario:");
			String usuario = teclado.next();
			System.out.println("Ingrese una contraseña:");
			String contraseña = teclado.next();
			System.out.println("Ingrese estilo preferiado:");
			System.out.println("a. Croll");
			System.out.println("b. Espalda");
			System.out.println("c. Peccho");
			System.out.println("d. Mariposa");
			Character dato1 = teclado.next().charAt(0);
			Socio nuevoSocioNadador = new Nadador(opcion3, nombre, apellido, usuario, contraseña, estilo(dato1));
			Boolean registro = administrador.realizarRegistroDeUsuario(nuevoSocioNadador);
			if (registro == true) {
				System.out.println("se ha registrado correctamente");
			} else {
				System.out.println("ocurrio un error");
			}
			break;
		case 2:
			System.out.println("\nIngrese su nombre:");
			nombre = teclado.next();
			System.out.println("Ingrese su apellido:");
			apellido = teclado.next();
			System.out.println("Ingrese un nombre de usuario:");
			usuario = teclado.next();
			System.out.println("Ingrese una contraseña:");
			contraseña = teclado.next();
			System.out.println("Ingrese distancia preferiada:");
			System.out.println("a. 5 KM:");
			System.out.println("b. 10 KM");
			System.out.println("c. 42 KM");
			Character dato2 = teclado.next().charAt(0);
			Socio nuevoSocioCorredor = new Corredor(opcion3, nombre, apellido, usuario, contraseña, distancia(dato2));
			registro = administrador.realizarRegistroDeUsuario(nuevoSocioCorredor);
			if (registro == true) {
				System.out.println("se ha registrado correctamente");
			} else {
				System.out.println("ocurrio un error");
			}
			bucle3 = false;
			break;
		case 3:
			bucle3 = false;
			System.out.println("\nIngrese su nombre:");
			nombre = teclado.next();
			System.out.println("Ingrese su apellido:");
			apellido = teclado.next();
			System.out.println("Ingrese un nombre de usuario:");
			usuario = teclado.next();
			System.out.println("Ingrese una contraseña:");
			contraseña = teclado.next();
			System.out.println("Ingrese tipo de bicicleta:");
			System.out.println("a. Montaña");
			System.out.println("b. Ruta");
			System.out.println("c. Triatlon");
			Character dato3 = teclado.next().charAt(0);
			Socio nuevoSocioCiclista = new Ciclista(opcion3, nombre, apellido, usuario, contraseña,
					tipoBicicleta(dato3));
			registro = administrador.realizarRegistroDeUsuario(nuevoSocioCiclista);
			if (registro == true) {
				System.out.println("se ha registrado correctamente");
			} else {
				System.out.println("ocurrio un error");
			}
			break;
		default:
			System.out.println("opcion incorrecta");
			break;
		}
	}

	public static EstiloPreferido estilo(Character dato) {
		EstiloPreferido eleccion = null;
		switch (dato) {
		case 'a': {
			eleccion = EstiloPreferido.CROLL;
		}
		case 'b': {
			eleccion = EstiloPreferido.ESPALDA;
		}
		case 'c': {
			eleccion = EstiloPreferido.PECHO;
		}
		case 'd': {
			eleccion = EstiloPreferido.MARIPOSA;
		}
		}

		return eleccion;

	}

	public static DistanciaPreferida distancia(Character dato) {
		DistanciaPreferida eleccion = null;
		switch (dato) {
		case 'a': {
			eleccion = DistanciaPreferida.CINCO_KM;
		}
		case 'b': {
			eleccion = DistanciaPreferida.DIEZ_KM;
		}
		case 'c': {
			eleccion = DistanciaPreferida.CUARENTA_Y_DOS_KM;
		}
		}

		return eleccion;
	}

	public static TipoDeBicicleta tipoBicicleta(Character dato) {
		TipoDeBicicleta eleccion = null;
		switch (dato) {
		case 'a': {
			eleccion = TipoDeBicicleta.MONTANA;
		}
		case 'b': {
			eleccion = TipoDeBicicleta.RUTA;
		}
		case 'c': {
			eleccion = TipoDeBicicleta.TRIATLON;
		}
		}

		return eleccion;
	}

	public static void menuVeedor() {
		System.out.println("\nIngrese su nombre:");
		String nombre = teclado.next();
		System.out.println("Ingrese su apellido:");
		String apellido = teclado.next();
		System.out.println("Ingrese su DNI:");
		Integer dni = teclado.nextInt();
		System.out.println("Ingrese un nombre de usuario:");
		String usuario = teclado.next();
		System.out.println("Ingrese una contraseña:");
		String contraseña = teclado.next();
		Veedor nuevoVeedor = new Veedor(dni, nombre, apellido, usuario, contraseña);
	}

}
