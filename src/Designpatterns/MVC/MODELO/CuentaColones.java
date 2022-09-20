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
public class CuentaColones extends Cuenta {

    public CuentaColones(String numeroCuenta, double saldo) {
        super(numeroCuenta, saldo);

    }//crear constructor  saldo

    public CuentaColones(String numero) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
