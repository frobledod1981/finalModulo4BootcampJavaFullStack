package com.frobledo.vistas;

import java.util.Scanner;

import com.frobledo.modelos.Alumno;

public abstract class MenuTemplate {
	
	protected Scanner sc;
	
	 public MenuTemplate() {
	        this.sc = new Scanner(System.in);
	 }
	 
	 private void desplegarMenu() {
		    
	        System.out.println("\n1. Exportar Datos");
	        System.out.println("2. Crear Alumno");
	        System.out.println("3. Agregar Materia");
	        System.out.println("4. Agregar Nota");
	        System.out.println("5. Listar Alumnos");
	        System.out.println("6. Salir");
	        System.out.print("Selección: ");
	    }
	 
	    protected abstract void exportarDatos();
	    
	    protected abstract void crearAlumno();
	    
	    protected abstract void agregarMateria();
	    
	    protected abstract void agregarNotaPasoUno();
	    
	    protected abstract void listarAlumnos();
	    
	    protected abstract void terminarPrograma();
	    
	    public void iniciarMenu() {
	    	
	    	System.out.println("\nBienvenido al Sistema de notas Colegio Latino Americano");
	    	
	    	while(true) {
	    		
	    		desplegarMenu();
	    		
	    	    int opcion = sc.nextInt();
	    	    sc.nextLine();
	    	    
	    	    switch(opcion) {
	    	      case 1:
	    	    	exportarDatos();
	    	      break;
	    	      
	    	      case 2:
	    	    	 crearAlumno();
	    	      break;
	    	      
	    	      case 3:
	    	    	  agregarMateria();
	    	      break;
	    	      
	    	      case 4:
	    	    	  agregarNotaPasoUno();
	    	      break;
	    	      
	    	      case 5:
	    	    	  listarAlumnos();
	    	      break;
	    	      
	    	      case 6:
	    	    	  terminarPrograma();
	    	    	  return;
	    	    	  
	    	      default:
	    	    	  System.out.println("Opcion incorrecta intente nuevamente!!");
	    	     
	    	    }
	    	    
	    		
	    	}
	    }
	 
	


}
