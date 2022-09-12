/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package banco;

/**
 *
 * @author joans
 */
public class Deposito extends Transaccion {

    public Deposito(Cuenta c1,int id, double monto) {
        super(c1,id, monto);
        deposito(c1,monto);
    }
     public void deposito(Cuenta c1,double monto){
     c1.setSaldo(c1.getSaldo()+monto);
     }
}
