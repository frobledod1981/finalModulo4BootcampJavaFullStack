package com.frobledo.services;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.frobledo.modelos.Alumno;
import com.frobledo.modelos.Materia;

public class ArchivoServicio {
	
	private List<Alumno> alumnosACargar;
	private PromedioServicioImpl promedioServicioImpl;
	
	
	public ArchivoServicio() {
        this.alumnosACargar = new ArrayList<>();
        this.promedioServicioImpl = new PromedioServicioImpl();
    }
	
	public void exportarDatos(Map<String,Alumno> alumnos,String path) {
		try(FileWriter writer = new FileWriter(path + "/promedios.txt")){
			for(Alumno alumno : alumnos.values()) {
				for(Materia materia : alumno.getMaterias()) {
					Double promedio = promedioServicioImpl.calcularPromedio(materia.getNotas());
					writer.write(String.format("Alumno : %s - %s\n", alumno.getRut(),alumno.getNombre()));
					writer.write(String.format("Materia : %s - %s\n", materia.getNombre(),materia.getNotas()));
					writer.write(String.format("Materia : %s - Promedio : %.1f\n", materia.getNombre(),promedio));
				;
							
				}
			}
			
		} catch (IOException e) {
			System.out.println("Error no se pudieron exportar Datos : " + e.getMessage());
		}
	}


	

}
