package com.frobledo.services;

import java.util.List;

public class PromedioServicioImpl {
	
	public double calcularPromedio(List<Double> notas) {
		double suma = 0;
		
		if(notas.isEmpty() || notas == null) {
			throw new IllegalArgumentException("La lista de notas no puede estar vacía.");
			//return 0.0;
			
		}
		
		for(Double nota : notas) {
			suma += nota;
		}
		
		return Math.round((suma / notas.size()) * 10.0) / 10.0;
	}

}
