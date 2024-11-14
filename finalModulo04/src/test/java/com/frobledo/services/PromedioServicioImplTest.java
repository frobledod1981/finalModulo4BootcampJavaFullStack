package com.frobledo.services;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PromedioServicioImplTest {
	
	private PromedioServicioImpl promedio;
	List<Double> valores;
	
	@BeforeEach public void setUp() {
		promedio = new PromedioServicioImpl(); 
		//valores = new ArrayList<>();
	}
	
	 
	@Test
	void testCalcularPromedio() {
	
	    valores = Arrays.asList(6.5, 6.5, 6.5, 6.5);
		double resultado = promedio.calcularPromedio(valores);
		assertEquals(6.5, resultado, 0.001, "El promedio debe ser 6.5");

	}
	
	
	@Test public void testPromedioListaVacia() { 
		valores = Arrays.asList();
		try {
			promedio.calcularPromedio(valores); 
		    fail("Se esperaba una IllegalArgumentException"); 
		} catch (IllegalArgumentException e) {
			assertEquals("La lista de notas no puede estar vacía.", e.getMessage()); 
			
		} 
	}

	

	@Test public void testPromedioConNull() { 
		valores = new ArrayList<>();
		try {
			promedio.calcularPromedio(valores); 
		    fail("Se esperaba una IllegalArgumentException"); 
		} catch (IllegalArgumentException e) {
			assertEquals("La lista de notas no puede estar vacía.", e.getMessage()); 
			
		} 
	}
}