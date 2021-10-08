package parcial1pb2.dominio;

import static org.junit.Assert.*;

import org.junit.Test;


public class Pruebas {

	@Test
	public void queSePuedaCrearUnEvento() {
		Evento evento1 = new Evento("Evento de prueba", TipoDeCompetencia.CICLISMO, 10, 150);
		final TipoDeCompetencia TIPO_ESPERADO = TipoDeCompetencia.CICLISMO;
		assertEquals (TIPO_ESPERADO, evento1.getTipoDeCompetencia());
	}
	
	@Test
	public void queSePuedaCrearUnParticipanteEIngresarloAlEvento() {
		//Prueba ciclismo + cliclista
		Evento evento1 = new Evento("Evento de prueba", TipoDeCompetencia.CICLISMO, 10, 150);
		Socio socio1 = new Ciclista("asd","123", "Juan", "Martinez", TipoDeBicicleta.RUTA);
		assertNotNull(evento1);
		assertNotNull(socio1);
		assertTrue(evento1.anotarParticipante(socio1));
		
		//Prueba maraton + corredor
		Evento evento2 = new Evento("Maraton 2 km", TipoDeCompetencia.RUNNING, 4, 5);
		Socio socio2 = new Corredor("asd","123", "Juan", "Martinez", DistanciaPreferida.CINCO_KM);
		assertTrue(evento2.anotarParticipante(socio2));
		
		//Prueba natacion + nadador
		Evento evento3 = new Evento("Carrera 3", TipoDeCompetencia.NATACION, 4, 5);
		Socio socio3 = new Nadador("asd1","123", "Juan", "Martinez", EstiloPreferido.CROLL);
		assertTrue(evento3.anotarParticipante(socio3));
		
		//Prueba actuatlon = nadador + corredor
		Evento evento4 = new Evento("Carrera 3", TipoDeCompetencia.ACUATLON, 4, 5);
		Socio socio4 = new Corredor("asd","123", "Juan", "Martinez", DistanciaPreferida.CINCO_KM);
		assertTrue(evento4.anotarParticipante(socio4));
		Socio socio5 = new Nadador("asd1","123", "Juan", "Martinez", EstiloPreferido.CROLL);
		assertTrue(evento4.anotarParticipante(socio5));
		
		//Prueba duatlon = corredor + ciclista
		Evento evento5 = new Evento("Carrera 3", TipoDeCompetencia.DUATLON, 4, 5);
		Socio socio6 = new Corredor("asd","123", "Juan", "Martinez", DistanciaPreferida.CINCO_KM);
		assertTrue(evento5.anotarParticipante(socio6));
		Socio socio7 = new Ciclista("asd","123", "Juan", "Martinez", TipoDeBicicleta.RUTA);
		assertTrue(evento5.anotarParticipante(socio7));
		
		//Prueba triatlon = corredor + cliclista + nadador
		Evento evento6 = new Evento("Juego olimpico", TipoDeCompetencia.TRIATLON, 4, 5);
		Socio socio8 = new Corredor("asd","123", "Juan", "Martinez", DistanciaPreferida.CINCO_KM);
		assertTrue(evento5.anotarParticipante(socio8));
		Socio socio9 = new Ciclista("asd","123", "Juan", "Martinez", TipoDeBicicleta.RUTA);
		assertTrue(evento5.anotarParticipante(socio9));
		Socio socio10 = new Nadador("asd1","123", "Juan", "Martinez", EstiloPreferido.CROLL);
		assertTrue(evento6.anotarParticipante(socio10));
		
	}
	
	@Test
	public void queSePuedaRemoverUnParticipanteIngresado() {
		Evento evento1 = new Evento("Evento de prueba", TipoDeCompetencia.CICLISMO, 10, 150);
		Socio socio1 = new Ciclista("asd","123", "Juan", "Martinez", TipoDeBicicleta.RUTA);
		evento1.anotarParticipante(socio1);
		assertTrue(evento1.removerParticipante(socio1));
	}
	
	@Test
	public void queSePuedaCrearUnVeedorEIngresarloAlEvento() {
		Evento evento1 = new Evento("Evento de prueba", TipoDeCompetencia.CICLISMO, 10, 150);
		Veedor publico1 = new Veedor("asd", "123", 12345678, "Pedro", "Fernandez");
		assertNotNull(publico1);
		assertTrue(evento1.anotarVeedor(publico1));
	}
	
	@Test
	public void queSePuedaRemoverUnVeedorIngresado() {
		Evento evento1 = new Evento("Evento de prueba", TipoDeCompetencia.CICLISMO, 10, 150);
		Veedor publico1 = new Veedor("asd", "123", 12345678, "Pedro", "Fernandez");
		evento1.anotarVeedor(publico1);
		assertTrue(evento1.removerVeedor(publico1));
	}
	
	@Test
	public void queNoSePuedanRegistrarDosVeedoresConElMismoDNI() {
		Evento evento1 = new Evento("Evento de prueba", TipoDeCompetencia.CICLISMO, 10, 150);
		Veedor publico1 = new Veedor("asd", "123", 12345678, "Pedro", "Fernandez");
		Veedor publico2 = new Veedor("asdf", "1234", 12345678, "Martin", "Hernandez");
		assertTrue(evento1.anotarVeedor(publico1));
		//Al tener el mismo DNI, el ingreso no se realiza por lo que da como resultado false, dando verde el test general
		assertFalse(evento1.anotarVeedor(publico2));
	}
	
	@Test
	public void queNoSePuedanAgregarMasParticipantesDeLosPermitidos() {
		Evento evento1 = new Evento("1500 mts estilo libre", TipoDeCompetencia.NATACION, 4, 100);
		Socio socio1 = new Nadador("asd1","123", "Juan", "Martinez", EstiloPreferido.CROLL);
		Socio socio2 = new Nadador("asd2","1234", "Pedro", "Sanchez", EstiloPreferido.ESPALDA);
		Socio socio3 = new Nadador("asd3","12345", "Sergio", "Gonzales", EstiloPreferido.MARIPOSA);
		Socio socio4 = new Nadador("asd4","123456", "Martin", "Juarez", EstiloPreferido.PECHO);
		assertTrue(evento1.anotarParticipante(socio1));
		assertTrue(evento1.anotarParticipante(socio2));
		assertTrue(evento1.anotarParticipante(socio3));
		assertTrue(evento1.anotarParticipante(socio4));
		Socio socio5 = new Nadador("asd5","1234567", "Socio5", "Socio5", EstiloPreferido.CROLL);
		//Al solo poder anotarse 4 participantes, el 5to debería dar falso, dando verde el test general.
		assertFalse(evento1.anotarParticipante(socio5));
	}
	
	@Test
	public void queNoSePuedaAgregarMasPublicoDelPermitido() {
		Evento evento1 = new Evento("Acuatrlon", TipoDeCompetencia.ACUATLON, 4, 5); //4 son los participantes, 5 el publico permitido
		Veedor publico1 = new Veedor("asd1","1", 12345678, "Pedro", "Sanchez");
		Veedor publico2 = new Veedor("asd2","12", 1234567, "Juan", "Juarez");
		Veedor publico3 = new Veedor("asd3","123", 123456, "Sergio", "Fernandez");
		Veedor publico4 = new Veedor("asd4","1234", 12345, "Martin", "Gonzales");
		Veedor publico5 = new Veedor("asd5","12355", 1234, "Alma", "Martinez");
		assertTrue(evento1.anotarVeedor(publico1));
		assertTrue(evento1.anotarVeedor(publico2));
		assertTrue(evento1.anotarVeedor(publico3));
		assertTrue(evento1.anotarVeedor(publico4));
		assertTrue(evento1.anotarVeedor(publico5));
		Veedor publico6 = new Veedor("asd5","12355", 123456789, "Maria", "Hernandez");
		//Al solo poder anotarse 5 veedores, el 6to debería dar falso, dando verde el test general.
		assertFalse(evento1.anotarVeedor(publico6));
	}
	
	@Test
	public void queNoPuedaIngresarUnDeportistaAUnaCompetenciaParaLaQueNoEstaPreparado() {
		Evento evento1 = new Evento("Natacion 500 mts", TipoDeCompetencia.NATACION, 4, 5);
		Socio socio1 = new Ciclista("asd","123", "Juan", "Martinez", TipoDeBicicleta.RUTA);
		assertFalse(evento1.anotarParticipante(socio1));		
	}

}
