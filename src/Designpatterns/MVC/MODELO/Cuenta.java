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
public class Cuenta {
   
   protected String numeroCuenta;
   protected double saldo;

    public Cuenta(String numeroCuenta, double saldo) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
    }
    
    public Cuenta(String numeroCuenta){
        this.numeroCuenta=numeroCuenta;
    }

    public Cuenta() {
    }
    
    public String getNumeroCuenta() {
        return numeroCuenta;
    }

//    public void setNumeroCuenta(String numeroCuenta) {
//        this.numeroCuenta = numeroCuenta;
//    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        if (this.saldo < 0) {
            this.saldo = 0;
        }else{
            this.saldo = saldo;
        }
    }

    @Override
    public String toString() {
        return  "\n"+'['+" Numero Cuenta: " + numeroCuenta + ']'+"\n"+  '['+ "Saldo Disponible: " + saldo + ']';
    }
   
  
}