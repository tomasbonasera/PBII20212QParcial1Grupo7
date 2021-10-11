package parcial1pb2.interfaz;

import java.util.Scanner;

import parcial1pb2.dominio.Admin;
import parcial1pb2.dominio.Ciclista;
import parcial1pb2.dominio.Corredor;
import parcial1pb2.dominio.DistanciaPreferida;
import parcial1pb2.dominio.EstiloPreferido;
import parcial1pb2.dominio.Evento;
import parcial1pb2.dominio.Nadador;
import parcial1pb2.dominio.Socio;
import parcial1pb2.dominio.TipoDeBicicleta;
import parcial1pb2.dominio.TipoDeCompetencia;
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

	// ---------------------REGISTRO-DEL-MENU------------------------------------------------------------

	public static void primerMenu() {
		System.out.println("****************");
		System.out.println("(1) Registrarse");
		System.out.println("(2) Ingresar"); // para ingresar como administrador ingresar
											// Usuario: "admin" Contraseña:"2468"
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
				switch (usuarioAdministrador.buscarPorUsuarioYContrasena(usuarioIngresado, contraseniaIngresada)
						.getTipo()) {
				case ADMIN:
					inMenuAdmin();
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
			if (usuarioAdministrador.verificarUsuarioRepetido(usuario) == false) {
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

			if (usuarioAdministrador.verificarUsuarioRepetido(usuario) == false) {
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
			if (usuarioAdministrador.verificarUsuarioRepetido(usuario) == false) {
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
			break;
		}
		case 'b': {
			eleccion = EstiloPreferido.ESPALDA;
			break;
		}
		case 'c': {
			eleccion = EstiloPreferido.PECHO;
			break;
		}
		case 'd': {
			eleccion = EstiloPreferido.MARIPOSA;
			break;
		}
		}

		return eleccion;

	}

	public static DistanciaPreferida distancia(Character dato) {
		DistanciaPreferida eleccion = null;
		switch (dato) {
		case 'a': {
			eleccion = DistanciaPreferida.CINCO_KM;
			break;
		}
		case 'b': {
			eleccion = DistanciaPreferida.DIEZ_KM;
			break;
		}
		case 'c': {
			eleccion = DistanciaPreferida.CUARENTA_Y_DOS_KM;
			break;
		}
		}

		return eleccion;
	}

	public static TipoDeBicicleta tipoBicicleta(Character dato) {
		TipoDeBicicleta eleccion = null;
		switch (dato) {
		case 'a': {
			eleccion = TipoDeBicicleta.MONTANA;
			break;
		}
		case 'b': {
			eleccion = TipoDeBicicleta.RUTA;
			break;
		}
		case 'c': {
			eleccion = TipoDeBicicleta.TRIATLON;
			break;
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
		if (usuarioAdministrador.verificarUsuarioRepetido(usuario) == false) {
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

	// ---------------------INGRESO-AL-MENU------------------------------------------------------------

	// ---------------------ADMIN------------------------------------------------------------
	public static void inMenuAdmin() {
		Integer opcion = 0;
		do {
			System.out.println("*************************************************");
			System.out.println("(1) Crear evento");
			System.out.println("(2) Eliminar evento");
			System.out.println("(3) Ver lista eventos");
			System.out.println("(4) Buscar participante o veedor de un evento");
			System.out.println("(5) Ver lista de participantes de un evento");
			System.out.println("(6) Ver lista de público de un evento");
			System.out.println("(7) Eliminar participante de un evento");
			System.out.println("(8) Eliminar veedor de un evento");
			System.out.println("(9) Desloguear");
			System.out.println("*************************************************\n");
			opcion = teclado.nextInt();
			switch (opcion) {
			case 1:
				crearEvento();
				break;
			case 2:
				eliminarEvento();
				break;
			case 3:
				verListaEventos();

				break;
			case 4:
				buscarParticipanteOVeedor();
				break;
			case 5:
				mostrarListaParticipantes();
				break;
			case 6:
				verListaPublico();
				break;
			case 7:
				eliminarParticipante();
				break;
			case 8:
				eliminarVeedor();
				break;
			case 9:
				break;
			default:
				System.out.println("Opción inválida");
				break;
			}
		} while (opcion != 9);

	}

	private static void buscarParticipanteOVeedor() {
		System.out.println("Ingrese el código del evento que desea ver");
		Integer codigo = teclado.nextInt();
		if (usuarioAdministrador.buscarEventoPorCodigo(codigo) != null) {
			System.out.println("(1) Buscar participante");
			System.out.println("(2) Buscar veedor");
			Integer eleccion = teclado.nextInt();
			switch (eleccion) {
			case 1:
				System.err.println("Ingrese el Número de socio del particpante a buscar");
				Integer nroSocio = teclado.nextInt();
				if (usuarioAdministrador.buscarEventoPorCodigo(codigo)
						.buscarParticipantePorNumeroDeSocio(nroSocio) != null) {
					System.out.println(usuarioAdministrador.buscarEventoPorCodigo(codigo)
							.buscarParticipantePorNumeroDeSocio(nroSocio).toString());
				} else {
					System.out.println("No se ha encontrado un participante con el número de socio ingresado");
				}
				break;
			case 2:
				System.out.println("Ingrese el DNI del veedor a buscar");
				Integer dni = teclado.nextInt();
				if (usuarioAdministrador.buscarEventoPorCodigo(codigo).buscarVeedorConDni(dni) != null) {
					System.out.println(
							usuarioAdministrador.buscarEventoPorCodigo(codigo).buscarVeedorConDni(dni).toString());
				} else {
					System.out.println("No se ha encontrado un veedor con el DNI ingresado");
				}
				break;
			default:
				System.out.println("Opción inválida");
				break;
			}
		} else {
			System.out.println("No se ha podido encontrar un evento con el código ingresado");
		}
	}

	private static void eliminarVeedor() {
		System.out.println("Ingrese el código del evento que desea ver");
		Integer codigo = teclado.nextInt();
		if (usuarioAdministrador.buscarEventoPorCodigo(codigo) != null) {
			System.out.println("Ingrese el Dni del veedor a elminar");
			Integer nroDni = teclado.nextInt();
			Boolean sePudoRemover = usuarioAdministrador.buscarEventoPorCodigo(codigo).removerVeedorConDni(nroDni);
			if (sePudoRemover) {
				System.out.println("Se ha eliminado correctamente al veedor");
			} else {
				System.out.println("No se ha encontrado un veedor con el número de socio ingresado");
			}
		} else {
			System.out.println("No se ha podido encontrar un evento con el código ingresado");
		}
	}

	private static void eliminarParticipante() {
		System.out.println("Ingrese el código del evento que desea ver");
		Integer codigo = teclado.nextInt();
		if (usuarioAdministrador.buscarEventoPorCodigo(codigo) != null) {
			System.out.println("Ingrese el número de socio del participante a elminar");
			Integer nroSocio = teclado.nextInt();
			Boolean sePudoRemover = usuarioAdministrador.buscarEventoPorCodigo(codigo)
					.removerParticipanteConNroSocio(nroSocio);
			if (sePudoRemover) {
				System.out.println("Se ha eliminado correctamente al participante");
			} else {
				System.out.println("No se ha encontrado un participante con el número de socio ingresado");
			}
		} else {
			System.out.println("No se ha podido encontrar un evento con el código ingresado");
		}
	}

	private static void verListaPublico() {
		System.out.println("Ingrese el código del evento que desea ver");
		Integer codigo = teclado.nextInt();
		if (usuarioAdministrador.buscarEventoPorCodigo(codigo) != null) {
			Veedor[] publicoDelEvento = usuarioAdministrador.buscarEventoPorCodigo(codigo).getPublico();
			System.out.println("Evento nro: " + codigo);
			Boolean hayPublico = false;
			for (int i = 0; i < publicoDelEvento.length; i++) {
				if (publicoDelEvento[i] != null) {
					System.out.println(publicoDelEvento[i].toString());
					hayPublico = true;
				}
			}
			if (hayPublico) {
				System.out.println("No se encontraron veedores en el evento ingresado");
			}
		} else {
			System.out.println("No se ha podido encontrar un evento con el código ingresado");
		}
	}

	private static void mostrarListaParticipantes() {
		System.out.println("Ingrese el código del evento que desea ver");
		Integer codigo = teclado.nextInt();
		if (usuarioAdministrador.buscarEventoPorCodigo(codigo) != null) {
			Socio[] participantesDelEvento = usuarioAdministrador.buscarEventoPorCodigo(codigo).getParticipantes();
			System.out.println("Evento nro: " + codigo);
			Boolean hayParticipantes = false;
			for (int i = 0; i < participantesDelEvento.length; i++) {
				if (participantesDelEvento[i] != null) {
					System.out.println(participantesDelEvento[i].toString());
					hayParticipantes = true;
				}
			}
			if (hayParticipantes) {
				System.out.println("No se encontraron veedores en el evento ingresado");
			}
		} else {
			System.out.println("No se ha podido encontrar un evento con el código ingresado");
		}
	}

	private static void verListaEventos() {
		if (usuarioAdministrador.obtenerCantidadDeEventosExistentes().equals(0)) {
			System.out.println("No se encontraron eventos creados");
		} else {
			Evento[] listaEventos = usuarioAdministrador.obtenerListaDeEventosExistentes();
			for (int i = 0; i < listaEventos.length; i++) {
				System.out.println(listaEventos[i].toString());
			}
		}
	}

	private static void eliminarEvento() {
		System.out.println("Ingrese el código del evento que desea eliminar");
		Integer codigo = teclado.nextInt();
		if (usuarioAdministrador.eliminarEvento(codigo)) {
			System.out.println("Se ha eliminado el evento correctamente");
		} else {
			System.out.println("No se ha podido encontrar un evento con el código ingresado");
		}
	}

	private static void crearEvento() {
		System.out.println("Ingrese el nombre del evento a crear");
		String nombreEventoACrear = teclado.next();
		char tipoCompetencia = ' ';
		Boolean bucleTipoCompetencia = true;
		do {
			System.out.println("Seleccione el tipo de competición del evento");
			System.out.println("(a) Acuatlon");
			System.out.println("(b) Ciclismo");
			System.out.println("(c) Duatlon");
			System.out.println("(d) Natacion");
			System.out.println("(e) Running");
			System.out.println("(f) Triatlon");
			tipoCompetencia = teclado.next().charAt(0);
			if (tipoCompetencia(tipoCompetencia) != null) {
				bucleTipoCompetencia = false;
			} else {
				System.out.println("Opción inválida, vuelva a ingresar una opción");
			}
		} while (bucleTipoCompetencia);
		System.out.println("Ingrese la cantidad de participantes/deportistas del evento");
		Integer cantidadParticipantes = teclado.nextInt();
		System.out.println("Ingrese la cantidad de veedores del evento");
		Integer cantidadVeedores = teclado.nextInt();
		Evento eventoAAnadir = new Evento(nombreEventoACrear, tipoCompetencia(tipoCompetencia), cantidadParticipantes,
				cantidadVeedores);
		Boolean seAgrego = usuarioAdministrador.agregarEvento(eventoAAnadir);
		if (seAgrego) {
			System.out.println("Evento creado exitosamente!");
		} else {
			System.out.println("No se ha podido crear el evento");
		}
	}

	// --------------------------------------------------------------------
	public static TipoDeCompetencia tipoCompetencia(Character dato) {
		TipoDeCompetencia eleccion = null;
		switch (dato) {
		case 'a': {
			eleccion = TipoDeCompetencia.ACUATLON;
		}
		case 'A': {
			eleccion = TipoDeCompetencia.ACUATLON;
			break;
		}
		case 'b': {
			eleccion = TipoDeCompetencia.CICLISMO;
		}
		case 'B': {
			eleccion = TipoDeCompetencia.CICLISMO;
			break;
		}
		case 'c': {
			eleccion = TipoDeCompetencia.DUATLON;
		}
		case 'C': {
			eleccion = TipoDeCompetencia.DUATLON;
			break;
		}
		case 'd': {
			eleccion = TipoDeCompetencia.NATACION;
		}
		case 'D': {
			eleccion = TipoDeCompetencia.NATACION;
			break;
		}
		case 'e': {
			eleccion = TipoDeCompetencia.RUNNING;
		}
		case 'E': {
			eleccion = TipoDeCompetencia.RUNNING;
			break;
		}
		case 'f': {
			eleccion = TipoDeCompetencia.TRIATLON;
		}
		case 'F': {
			eleccion = TipoDeCompetencia.TRIATLON;
			break;
		}
		}

		return eleccion;
	}
}
