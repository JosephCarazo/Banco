/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Designpatterns.MVC.Controlador;

import Designpatterns.MVC.MODELO.Cuenta;
import Designpatterns.MVC.MODELO.DataBase;
import DesingPatterns.MVC.Vista.VistaConsolaCuenta;


/**
 *
 * @author joans
 */
public class ControladorCuenta {
    private VistaConsolaCuenta vista;
    private Cuenta modelo;
    private DataBase tabla;

    public void setVista(VistaConsolaCuenta vista) {
        this.vista = vista;
    }

    public void setModelo(Cuenta modelo) {
        this.modelo = modelo;
    }

    public ControladorCuenta(VistaConsolaCuenta vista, Cuenta modelo, DataBase tabla) {
        this.vista = vista;
        this.modelo = modelo;
        this.tabla = tabla;
    }
    
    public void agregar(){
    if (tabla.Buscar(modelo.getNumeroCuenta())==null){
        tabla.add(modelo);
    }
    }
    
    public void buscar(){
    
    }
    
}
