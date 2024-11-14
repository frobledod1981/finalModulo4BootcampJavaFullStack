package com.frobledo.modelos;

import java.util.ArrayList;
import java.util.List;

public class Alumno {
	
	private String rut;
	
	private String nombre;
	
	private String apellido;
	
	private String direccion;
	
	private Materia materia;
	
	private List<Materia> materias;
	
	public Alumno(String rut, String nombre, String apellido, String direccion) {
        this.rut = rut;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.materias = new ArrayList<>();
    }

	//uso de test
	public Alumno(String rut, String nombre, String apellido,List<Materia> materias) {
		this.rut = rut;
        this.nombre = nombre;
        this.apellido = apellido;
        this.materias = new ArrayList<>();
	}
	
	public Alumno() {
		
	}
	//
	
	public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<Materia> getMaterias() {
        return materias;
    }

    public void setMaterias(List<Materia> materias) {
        this.materias = materias;
    }

    public void agregarMateria(Materia materia) {
        this.materias.add(materia);
    }
    
     
  //uso de test
    public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}
	
	//termino el test

	@Override
    public String toString() {
        return "Alumno{" +
                "rut='" + rut + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", direccion='" + direccion + '\'' +
                ", materias=" + materias +
                '}';
    	
    	
    }
}


