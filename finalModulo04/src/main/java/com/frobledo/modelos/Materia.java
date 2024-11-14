package com.frobledo.modelos;

import java.util.ArrayList;
import java.util.List;

public class Materia {
	
	private MateriaEnum nombre;
	
	private List<Double>  notas;
	
	public Materia(MateriaEnum nombre) {
        this.nombre = nombre;
        this.notas = new ArrayList<>();
    }
	
	
	//prueba test
	public Materia(MateriaEnum nombre, ArrayList arrayList) {
		this.nombre = nombre;
		arrayList = new ArrayList<>();
	}
	//

	
	public MateriaEnum getNombre() {
        return nombre;
    }

    public void setNombre(MateriaEnum nombre) {
        this.nombre = nombre;
    }

    public List<Double> getNotas() {
        return notas;
    }

    public void setNotas(List<Double> notas) {
        this.notas = notas;
    }

    public void agregarNota(Double nota) {
        this.notas.add(nota);
    }

    @Override
    public String toString() {
        return "Materia [nombre=" + nombre + ", notas=" + notas + "]";
    }

}
