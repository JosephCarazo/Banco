/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Designpatterns.MVC.Controlador;

import DesingPatterns.MVC.Vista.VistaConsolaCuenta;

/**
 *
 * @author joans
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        VistaConsolaCuenta vista = new VistaConsolaCuenta();
        vista.agregar();
        vista.agregar();    
        vista.agregar();
    }
    
}
