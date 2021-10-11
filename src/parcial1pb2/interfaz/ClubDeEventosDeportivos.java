package parcial1pb2.interfaz;

import java.util.Scanner;

import parcial1pb2.dominio.Admin;
import parcial1pb2.dominio.Ciclista;
import parcial1pb2.dominio.Corredor;
import parcial1pb2.dominio.DistanciaPreferida;
import parcial1pb2.dominio.EstiloPreferido;
import parcial1pb2.dominio.Nadador;
import parcial1pb2.dominio.Socio;
import parcial1pb2.dominio.TipoDeBicicleta;
import parcial1pb2.dominio.TipoUsuario;
import parcial1pb2.dominio.Veedor;

public class ClubDeEventosDeportivos {

	public static Scanner teclado = new Scanner(System.in);
	public static Admin usuarioAdministrador = new Admin();
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
		System.out.println("****************");
		System.out.println("(1) Registrarse");
		System.out.println("(2) Ingresar");
		System.out.println("****************\n");
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
					do {
						menuDeportista1();
					} while (bucle3);

					break;

				case 2:
					bucle2 = false;
					menuVeedor();

					break;

				default:
					System.out.println("opcion incorrecta \n");
					break;
				}
			} while (bucle2);
			break;

		case 2:
			System.out.println("Ingrese nombre de usuario:");
			String usuarioIngresado = teclado.next();
			System.out.println("Ingrese contraseña:");
			String contraseniaIngresada = teclado.next();
			Boolean verificar = usuarioAdministrador.verificarIngresoDeUsuario(usuarioIngresado, contraseniaIngresada);
			if (verificar == true) {
				System.out.println("se ha ingresado correctamente");
				switch (usuarioAdministrador.buscarPorUsuarioYContrasena(usuarioIngresado, contraseniaIngresada).getTipo()) {
				case ADMIN:
					
					break;
				case VEEDOR:
					
					break;
				case DEPORTISTA:
					
					break;
				default:
					break;
				}
			} else {
				System.out.println("ha ocurrido un error");
			}
			break;
		default:
			System.out.println("opcion incorrecta\n");
			break;
		}
	}

	public static void menuDeportista1() {
		System.out.println("Registrarse como...");
		System.out.println("1. Nadador");
		System.out.println("2. Corredor");
		System.out.println("3. Ciclista");
		Integer opcion3 = teclado.nextInt();
		Boolean verificar;
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
			String contrasena = teclado.next();
			System.out.println("Ingrese estilo preferiado:");
			System.out.println("a. Croll");
			System.out.println("b. Espalda");
			System.out.println("c. Peccho");
			System.out.println("d. Mariposa");
			Character dato1 = teclado.next().charAt(0);
			if (usuarioAdministrador.verificarUsuarioRepetido(usuario)==false) {
				Socio nuevoSocioNadador = new Nadador(usuario, contrasena, nombre, apellido, estilo(dato1),
						TipoUsuario.DEPORTISTA);
				verificar = usuarioAdministrador.agregarUsuarioRegistrado(nuevoSocioNadador);
				if (verificar == true) {
					System.out.println("se ha registrado correctamente");
				} else {
					System.out.println("ha ocurrido un error");
				}
				break;
			} else {
				System.out.println("Usuario ya registrado. Use otro usuario para registrarse");
			}
		case 2:
			System.out.println("\nIngrese su nombre:");
			nombre = teclado.next();
			System.out.println("Ingrese su apellido:");
			apellido = teclado.next();
			System.out.println("Ingrese un nombre de usuario:");
			usuario = teclado.next();
			System.out.println("Ingrese una contraseña:");
			contrasena = teclado.next();
			System.out.println("Ingrese distancia preferiada:");
			System.out.println("a. 5 KM:");
			System.out.println("b. 10 KM");
			System.out.println("c. 42 KM");
			Character dato2 = teclado.next().charAt(0);

			if (usuarioAdministrador.verificarUsuarioRepetido(usuario)==false) {
				Socio nuevoSocioCorredor = new Corredor(usuario, contrasena, nombre, apellido, distancia(dato2),
						TipoUsuario.DEPORTISTA);
				verificar = usuarioAdministrador.agregarUsuarioRegistrado(nuevoSocioCorredor);
				if (verificar == true) {
					System.out.println("se ha registrado correctamente");
				} else {
					System.out.println("ha ocurrido un error");
				}
				bucle3 = false;
				break;
			} else {
				System.out.println("Usuario ya registrado. Use otro usuario para registrarse");
			}

		case 3:
			bucle3 = false;
			System.out.println("\nIngrese su nombre:");
			nombre = teclado.next();
			System.out.println("Ingrese su apellido:");
			apellido = teclado.next();
			System.out.println("Ingrese un nombre de usuario:");
			usuario = teclado.next();
			System.out.println("Ingrese una contraseña:");
			contrasena = teclado.next();
			System.out.println("Ingrese tipo de bicicleta:");
			System.out.println("a. Montaña");
			System.out.println("b. Ruta");
			System.out.println("c. Triatlon");
			Character dato3 = teclado.next().charAt(0);
			if (usuarioAdministrador.verificarUsuarioRepetido(usuario)==false) {
				Socio nuevoSocioCiclista = new Ciclista(usuario, contrasena, nombre, apellido, tipoBicicleta(dato3),
						TipoUsuario.DEPORTISTA);
				verificar = usuarioAdministrador.agregarUsuarioRegistrado(nuevoSocioCiclista);
				if (verificar == true) {
					System.out.println("se ha registrado correctamente");
				} else {
					System.out.println("ha ocurrido un error");
				}
			} else {
				System.out.println("Usuario ya registrado. Use otro usuario para registrarse");
			}

			break;
		default:
			System.out.println("opcion incorrecta\\n");
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
		if (usuarioAdministrador.verificarUsuarioRepetido(usuario)==false) {
			Veedor nuevoVeedor = new Veedor(usuario, contraseña, dni, nombre, apellido, TipoUsuario.VEEDOR);
			Boolean verificar = usuarioAdministrador.agregarUsuarioRegistrado(nuevoVeedor);
			if (verificar == true) {
				System.out.println("se ha registrado correctamente");
			} else {
				System.out.println("ha ocurrido un error");
			}
		} else {
			System.out.println("Usuario ya registrado. Use otro usuario para registrarse");
		}
		

	}

}
