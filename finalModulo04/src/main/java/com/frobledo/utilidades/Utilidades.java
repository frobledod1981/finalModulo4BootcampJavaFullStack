package com.frobledo.utilidades;

import java.awt.Robot;
import java.awt.event.KeyEvent;

public class Utilidades {

	public static void limpiarPantalla() {
        for (int i = 0; i < 8; i++) {
            System.out.println();
        }
    }
	
	@SuppressWarnings("resource")
	public static void nextStep(){
        try{
            System.out.println("Presione enter para continuar...");
            new java.util.Scanner(System.in).nextLine();

            Robot limpiar = new Robot();
            limpiar.keyPress(KeyEvent.VK_CONTROL);
            limpiar.keyPress(KeyEvent.VK_L);
            limpiar.keyRelease(KeyEvent.VK_CONTROL);
            limpiar.keyRelease(KeyEvent.VK_L);
            
        }  catch (Exception e) {
            System.out.println("Error al limpiar la pantalla"+e.getMessage());
        }
    }
	

    public static void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
    
    public static String eliminarCaracteresEspeciales(String texto) {
        // Regex que permite solo letras, números y espacios
        return texto.replaceAll("[^a-zA-Z0-9 ]", "");
    }
    
    public static String quitarEspacios(String texto) {
        return texto.trim();
    }
    
    public static void saltosDeLinea() {
    	System.out.println();
    	System.out.println();
    }
}
