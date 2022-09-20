/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Designpatterns.MVC.MODELO;

import java.util.ArrayList;

/**
 *
 * @author joans
 */
public class DataBase {
     private ArrayList<Cuenta> cuentas;
     
     public void add(Cuenta cuenta){
     cuentas.add(cuenta);
     }
     public Cuenta Buscar(String numero){
     for (Cuenta cuenta: cuentas){
     if(cuenta.getNumeroCuenta().equals(numero)){
     return cuenta;
     }
     }
     return null;
     }

    public DataBase() {
        this.cuentas = new ArrayList<Cuenta>();
    }
     
}
