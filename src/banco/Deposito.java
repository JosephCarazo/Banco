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

    

    public Deposito(int id,Cuenta c,String cuentaDestino, double monto) {
        super(c,id,cuentaDestino, monto);
        c.setSaldo(c.getSaldo()+monto);
    }

    

}
