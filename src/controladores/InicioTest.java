package controladores;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class InicioTest {

	@Test
	void verificarPassNullTest() {
		Inicio i = new Inicio();
		assertEquals("Error: Nulo", i.verificarLongitud(null));
	}
	
	@Test
	void verificarLongitudTest() {
		Inicio i = new Inicio();
		assertEquals("Válido", i.verificarLongitud("123456789"));
		assertEquals("Válido", i.verificarLongitud("12345678"));
		assertEquals("Falla", i.verificarLongitud("1234567"));
	}
	
	

}
