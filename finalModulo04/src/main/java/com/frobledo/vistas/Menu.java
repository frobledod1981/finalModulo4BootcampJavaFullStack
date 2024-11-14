package com.frobledo.vistas;

import java.util.List;

import com.frobledo.modelos.Alumno;
import com.frobledo.modelos.Materia;
import com.frobledo.modelos.MateriaEnum;
import com.frobledo.services.AlumnoServicio;
import com.frobledo.services.ArchivoServicio;
import com.frobledo.utilidades.Utilidades;

public class Menu extends MenuTemplate{
	
	private AlumnoServicio alumnoServicio;
	private ArchivoServicio archivoServicio;
	private MateriaEnum materiaEnum;
	private Alumno alumno;
	
	 public Menu() {
	        super();
	        this.alumnoServicio = new AlumnoServicio();
	        this.archivoServicio = new ArchivoServicio();
	    }
	 

	@Override
	protected void exportarDatos() {
		Utilidades.saltosDeLinea();	
		
		Utilidades.mostrarMensaje("Exportando Datos");
		String ruta = "./output/";
		archivoServicio.exportarDatos(alumnoServicio.listarAlumnos(), ruta);
		Utilidades.mostrarMensaje("Datos exportados de Forma Correcta");
		
		Utilidades.nextStep();
		
	}

	@Override
	protected void crearAlumno() {
		
        Utilidades.saltosDeLinea();	
		Utilidades.mostrarMensaje("***Creando Alumno***");
		
		System.out.println("Ingrese el RUT");
		String rut = sc.nextLine();
		
		System.out.println("Ingrese el Nombre");
		String nombre = sc.nextLine();
		
		System.out.println("Ingrese el apellido");
		String apellido = sc.nextLine();
		
		System.out.println("Ingrese la Direccion");
		String direccion = sc.nextLine();
		
		Alumno alumno = new Alumno(Utilidades.quitarEspacios(rut),Utilidades.eliminarCaracteresEspeciales(nombre),
				Utilidades.eliminarCaracteresEspeciales(apellido),Utilidades.eliminarCaracteresEspeciales(direccion));
		
		alumnoServicio.crearAlumno(alumno);
		
		Utilidades.mostrarMensaje("El Alumno fue creado con exito");
		
		Utilidades.nextStep();
		
	} 

	@Override
	protected void agregarMateria() {
		
		Utilidades.saltosDeLinea();	
		Utilidades.mostrarMensaje("***Agregando Materia***");
		
		System.out.println("Indique Rut de Alumno :");
		String rut = sc.nextLine();
		rut = Utilidades.quitarEspacios(rut);
		
		    System.out.println("1. MATEMATICAS");
	        System.out.println("2. LENGUAJE");
	        System.out.println("3. CIENCIA");
	        System.out.println("4. HISTORIA");
	        System.out.print("-----Selecciona una Materia-----");
	        
	        int opcion = sc.nextInt();
	        sc.nextLine();
	        
	        switch(opcion) {
	        case 1 :
	        	materiaEnum = MateriaEnum.MATEMATICAS;
	        	break;
	        	
	        case 2:
	        	materiaEnum = MateriaEnum.LENGUAJE;
	        	break;
	        	
	        case 3:
	        	materiaEnum = MateriaEnum.CIENCIA;
	        	break;
	        	
	        case 4:
	        	materiaEnum = MateriaEnum.HISTORIA;
	        	break;
	        	
	        default:
	        	Utilidades.mostrarMensaje("Opcion no Valida!!");
	        	
	        }
	        Materia materia = new Materia(materiaEnum);
	        alumnoServicio.agregarMateria(rut, materia);
	        
	        Utilidades.mostrarMensaje("Se Agrego La materia Correctamente");
	        
	        Utilidades.nextStep();
	        
	}
	


	@Override
	protected void agregarNotaPasoUno() {

		Utilidades.saltosDeLinea();	
		Utilidades.mostrarMensaje("***Agrege Nota***");
		
		System.out.println("Ingrese el RUT del Alumno");
		String rut = sc.nextLine();
		rut = Utilidades.quitarEspacios(rut);
		
		List<Materia> materias = alumnoServicio.materiasPorAlumno(rut);
		//System.out.println(materias);
		
		if(materias.isEmpty() || materias == null) {
			System.err.println("El Alumno "+ alumno.getNombre() + "del RUT digitado no tiene materias asignadas");
			return;
		}
		
		Utilidades.mostrarMensaje("El alumno Rut :" + rut + " Tiene las siguientes materias");
		for(int i = 0 ; i < materias.size() ; i++) {
			System.out.println((i + 1) + ".-" + materias.get(i).getNombre());
		}
		
		Utilidades.mostrarMensaje("Seleccione Materia : ");
		int posicionMateria = sc.nextInt() - 1;
		sc.nextLine();
		
		if(posicionMateria < materias.size() && posicionMateria >= 0) {
			System.out.println("Ingrese Nota :");
			double nota = sc.nextDouble();
			sc.nextLine();
			
			materias.get(posicionMateria).agregarNota(nota);
			Utilidades.mostrarMensaje("*** Nota Agregada a " + materias.get(posicionMateria).getNombre() + " ***");
			
			Utilidades.nextStep();
		}
	}

	@Override
	protected void listarAlumnos() {
		Utilidades.saltosDeLinea();	
		
		for(Alumno alumno : alumnoServicio.listarAlumnos().values()) {
			    System.out.println("\nDatos Alumno");
	            System.out.println("RUT: " + alumno.getRut());
	            System.out.println("Nombre: " + alumno.getNombre());
	            System.out.println("Apellido: " + alumno.getApellido());
	            System.out.println("Dirección: " + alumno.getDireccion());
	            
	            Utilidades.mostrarMensaje("Materias :");
	            for(Materia materia : alumno.getMaterias()) {
	            	System.out.println(materia.getNombre());
	                System.out.println("Notas:");
	                System.out.println(materia.getNotas());
	            }
		}
		
		Utilidades.nextStep();
		
	}

	@Override
	protected void terminarPrograma() {
		Utilidades.saltosDeLinea();	
		Utilidades.mostrarMensaje("Vuelva Pronto gracias por hacer uso del sistema!!");
		sc.close();
	}

}
