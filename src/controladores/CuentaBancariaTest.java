package controladores;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

class CuentaBancariaTest {

	@Test
	void cuentaBloqueadaTest() {
		CuentaBancaria cb = new CuentaBancaria("Alex", 100);
		cb.setBloqueada(true);
		assertFalse(cb.ingresar(10));
		cb.setBloqueada(false);
		assertTrue(cb.ingresar(10));
		assertTrue(cb.ingresar(-10));
	}
	
	@Test
	void cuentaRetirarTest() {
		CuentaBancaria cb = new CuentaBancaria("Alex", 100);
		cb.setBloqueada(true);
		assertFalse(cb.retirar(10));
		cb.setBloqueada(false);
		assertFalse(cb.retirar(0));
		assertFalse(cb.retirar(-1));
		assertTrue(cb.retirar(90));
		assertFalse(cb.retirar(180));
	}
	
	@Test
	void cuentaTransferenciaTest() {
		CuentaBancaria cb = new CuentaBancaria("Alex", 100);
		assertFalse(cb.transferir(null, 10));
		assertFalse(cb.transferir(cb, 150));
		assertFalse(cb.transferir(cb, -1));
		assertFalse(cb.transferir(cb, 0));
		assertFalse(cb.transferir(cb, 100));
		cb.setBloqueada(true);
		assertFalse(cb.transferir(null, 10));
		assertFalse(cb.transferir(cb, 150));
		assertFalse(cb.transferir(cb, -1));
		assertFalse(cb.transferir(cb, 0));
		assertFalse(cb.transferir(cb, 100));
		cb.setBloqueada(false);
		assertTrue(cb.transferir(cb, 50));
		
	}

	@Test
	void cuentaInteresesTest() {
		CuentaBancaria cb = new CuentaBancaria("Alex", 100);
		assertEquals(50,0, cb.calcularInteres(50));
		assertEquals(0,0, cb.calcularInteres(0));
	}
	
}
