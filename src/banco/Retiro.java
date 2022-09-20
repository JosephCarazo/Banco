/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package banco;

/**
 *
 * @author joans
 */
public class Retiro extends Transaccion {

    public Retiro(int id, Cuenta c, double monto) {
        super(c, id, monto);
        c.setSaldo(c.getSaldo() - monto);

    }

}
