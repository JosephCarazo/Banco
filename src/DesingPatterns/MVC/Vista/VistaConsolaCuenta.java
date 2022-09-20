/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DesingPatterns.MVC.Vista;

import Designpatterns.MVC.Controlador.ControladorCuenta;
import Designpatterns.MVC.MODELO.Cuenta;
import Designpatterns.MVC.MODELO.CuentaColones;
import Designpatterns.MVC.MODELO.CuentaDolares;
import java.util.Scanner;

/**
 *
 * @author joans
 */
public class VistaConsolaCuenta {
    private ControladorCuenta controlCuenta;
    
    public void agregar(){
     Scanner leer = new Scanner(System.in);
        System.out.println("Ingrese el numero de cuenta");
     String numero = leer.nextLine();
       System.out.println("Ingrese el saldo");
     double saldo = leer.nextDouble();
     System.out.println("1 para cuentaEncolones");
     System.out.println("2 para cuentaEncolones");
     int tipo = leer.nextInt();
     Cuenta cuenta;
     if (tipo==1){
     cuenta = new CuentaColones(numero,saldo);
     }else{
     cuenta = new CuentaDolares(numero,saldo);
     }
     controlCuenta.setModelo(cuenta);
     controlCuenta.agregar();
    }
    public void buscar(){
    Scanner leer = new Scanner(System.in);
        System.out.println("Ingrese el numero de cuenta");
     String numero = leer.nextLine();
  
     Cuenta cuenta=new CuentaColones(numero);
     controlCuenta.setModelo(cuenta);
     controlCuenta.buscar();
     
    }
}
