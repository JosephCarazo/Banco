/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package banco;

/**
 *
 * @author joans
 */
public class Transferencia extends Transaccion {

    public Transferencia(Cuenta c1,Cuenta c2,int id, String cuenta, double monto, double saldoAnterior) {
        super(c1,c2,id, cuenta, monto, saldoAnterior);
    }
 
}
