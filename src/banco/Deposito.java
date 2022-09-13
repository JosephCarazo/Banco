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

    private String cuentaDestino;

    public Deposito(String cuentaDestino, String cuenta, double monto) {
        super(cuenta, monto);
        this.cuentaDestino = cuentaDestino;
    }

    

}
