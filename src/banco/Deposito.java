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

    public Deposito(Cuenta c1,int id, String cuenta, double monto, double saldoAnterior) {
        super(c1,id, cuenta, monto, saldoAnterior);
        deposito(c1,monto);
    }
     private void deposito(Cuenta c1,double monto){
     c1.setSaldo(monto);
     }
}
