package com.frobledo.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.frobledo.modelos.Alumno;
import com.frobledo.modelos.Materia;

public class AlumnoServicio {
	
	private Map<String,Alumno> listaAlumnos;
	
	 public AlumnoServicio() {
	        this.listaAlumnos = new HashMap<>();
	 }
	 
	 public void crearAlumno(Alumno alumno) {
		 listaAlumnos.put(alumno.getRut(), alumno);
	 }
	 
	 public void agregarMateria(String rutAlumno,Materia materia) {
		 Alumno alumno = listaAlumnos.get(rutAlumno);
		 if(alumno != null) {
			 alumno.agregarMateria(materia);
		 }
		 
	 }
	 
	 public List<Materia> materiasPorAlumno(String rutAlumno){
		 Alumno alumno = listaAlumnos.get(rutAlumno);
		 if(alumno != null) {
			 return  alumno.getMaterias(); 
		 }
		 return null;
	 }
	 
	 public Map<String,Alumno> listarAlumnos(){
		 return listaAlumnos;
	 }

}
