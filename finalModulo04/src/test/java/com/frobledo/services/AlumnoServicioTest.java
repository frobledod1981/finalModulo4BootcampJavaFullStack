package com.frobledo.services;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.frobledo.modelos.Alumno;
import com.frobledo.modelos.Materia;
import com.frobledo.modelos.MateriaEnum;

class AlumnoServicioTest {
	
	private AlumnoServicio servicio;
	private Map<String,Alumno> listar;
	private Alumno alumno;
	
	
	@BeforeEach public void setUp() {
		servicio = new AlumnoServicio();
		listar = new HashMap<>();
		alumno = new Alumno();
	} 

	@Test
	void crearAlumnoTest() {
		System.out.println("TEST CREAR ALUMNO");
		Alumno alumnoR = new Alumno("11223344", "Fernando", "Robledo", "Direccion");
		servicio.crearAlumno(alumnoR);
		
		if (listar.containsKey(alumnoR.getRut())) {
			System.out.println("El alumno ya existe."); 
		}else { listar.put(alumnoR.getRut(), alumno); 
		   System.out.println("Alumno creado: " + alumnoR.getNombre() +" "+ alumnoR.getApellido()); 
		   
		}
		 System.out.println(servicio.listarAlumnos());
			
		 assertNotNull(alumnoR, "El alumno no debe ser nulo.");
	}
	
	
	//revisar
	@Test
	void  agregarMateriaTest() {
		System.out.println("\n");
		System.out.println("TEST AGREGAR MATERIA");
		alumno = new Alumno("11223344", "Fernando", "Robledo", "Puerto Rata");
		servicio.crearAlumno(alumno);
		
		Materia materia = new Materia(MateriaEnum.LENGUAJE,new ArrayList<>());
		servicio.agregarMateria(alumno.getRut(), materia);
		
		Alumno encontrado = servicio.listarAlumnos().get("11223344");
		System.out.println(encontrado);
		
		assertNotNull(encontrado, "El alumno no debe ser nulo."); 
		assertEquals(1, encontrado.getMaterias().size(), "El alumno debe tener 1 materia.");
		assertEquals(materia, encontrado.getMaterias().get(0), "La materia debe ser LENGUAJE.");
	}

	
	@Test
	void materiasPorAlumnosTest() {
		System.out.println("\n");
		System.out.println("TEST MATERIAS POR ALUMNO");
		List<Materia> materias = new ArrayList<>();
		Materia matematica = new Materia(MateriaEnum.MATEMATICAS, new ArrayList<>());
		Materia lenguaje = new Materia(MateriaEnum.LENGUAJE, new ArrayList<>());
		materias.add(matematica);
		materias.add(lenguaje);
		
		
		Alumno alumno1 = new Alumno("11111111", "Fernando", "Robledo","Puerto Ron");
		alumno1.setMaterias(materias);
		servicio.crearAlumno(alumno1);
		
		List<Materia> materiasAlumno = servicio.materiasPorAlumno(alumno1.getRut());
		
		materiasAlumno.forEach((m)-> {
			System.out.println("Materia: " + m);
		});
		
		assertNotNull(materiasAlumno, "Lista de materias no debe ser NULL."); 
		assertEquals(2, materiasAlumno.size(), "El alumno debe tener 2 materias.");
		assertEquals(matematica, materiasAlumno.get(0), "La primera materia debe ser Matematica.");
		assertEquals(lenguaje, materiasAlumno.get(1), "La segunda materia debe ser Lenguaje.");
		
	}
	
	
	@Test
	void listarAlumnosTest() {
		System.out.println("\n");
		System.out.println("TEST LISTA ALUMNOS");
		List<Materia> materias = new ArrayList<>();
		materias.add(new Materia(MateriaEnum.MATEMATICAS, new ArrayList<>()));
		
		Alumno alumno1 = new Alumno("11111111", "Fernando", "Robledo.", materias); 
		Alumno alumno2 = new Alumno("22222222", "Juan", "Oh.", materias);
		
		servicio.crearAlumno(alumno1);
		servicio.crearAlumno(alumno2);
		
		Map<String, Alumno> listaAlumnos = servicio.listarAlumnos();
		
		listaAlumnos.forEach((key,value)-> {
			System.out.println("Key :" + key + " ,value : " + value);
		});
		
		assertNotNull(listaAlumnos, "La lista de alumnos no debe ser nula.");
		assertEquals(2, listaAlumnos.size(), "La lista de alumnos debe tener 2 elementos.");
		assertEquals(alumno1, listaAlumnos.get("11111111"), "El primer alumno debe coincidir.");
		assertEquals(alumno2, listaAlumnos.get("22222222"), "El segundo alumno debe coincidir.");
	}

}
