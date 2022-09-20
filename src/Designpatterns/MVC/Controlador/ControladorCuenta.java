/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Designpatterns.MVC.Controlador;

import DesingPatterns.MVC.Vista.VistaConsolaCuenta;
import banco.Cuenta;

/**
 *
 * @author joans
 */
public class ControladorCuenta {
    private VistaConsolaCuenta vista;
    private Cuenta modelo;

    public void setVista(VistaConsolaCuenta vista) {
        this.vista = vista;
    }

    public void setModelo(Cuenta modelo) {
        this.modelo = modelo;
    }
    
    public void add(){
    
    }
    
}
