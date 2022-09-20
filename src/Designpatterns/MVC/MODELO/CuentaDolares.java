/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Designpatterns.MVC.MODELO;

import banco.*;

/**
 *
 * @author joans
 */
public class CuentaDolares extends Cuenta {
    private static double tipoCambio;

    public CuentaDolares(String numeroCuenta, double saldo) {
        super(numeroCuenta, saldo);
        tipoCambio=680;
    }
    
    public void RetirarColonesADolares(double saldo){///EN CASO DE RETIRAR COLONES A DOLARES
    double dolares=saldo/tipoCambio;
    restarDolares(dolares);//METODO PRIVADO PARA RESTAR DOLARES 
    }
    public void depositarColonesADolares(double saldo){
    double dolares=saldo/tipoCambio;//CONVIERTE DE COLONES A DOLARES
    sumarDolares(dolares);//METODO PRIVADO PARA SUMAR DOLARES 
    }
    private void restarDolares(double dolares){
    this.saldo-=dolares;
    }
    private void sumarDolares(double dolares){
    this.saldo-=dolares;
    }
    
}
