/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package banco;

import java.time.LocalDateTime;

/**
 *
 * @author joans
 */
public abstract class Transaccion {

    protected int id;
    protected String cuenta;
    protected double monto;
    protected double saldoAnterior;
    protected double saldoFinal;
    protected String fechaHora;

    //ESTE CONSTRUCTOR SE UTILIZA PARA TRANSFERENCIA ENTRE CUENTAS(POR ELLOS DOS CUENTAS)
    public Transaccion(Cuenta c1, Cuenta c2, int id, String cuenta, double monto, double saldoAnterior) {
        this.id = id;
        this.cuenta = cuenta;
        this.monto = monto;
        this.saldoAnterior = saldoAnterior;
        this.fechaHora = String.valueOf(LocalDateTime.now());

    }

    //ESTE CONSTRUCTOR ES PARA RETIROS Y DEPOSITO
    public Transaccion(Cuenta c1, int id, double monto) {
        this.id = id;
        this.cuenta=c1.getNumeroCuenta();
        this.monto = monto;
        this.saldoAnterior =c1.getSaldo();
        this.fechaHora = String.valueOf(LocalDateTime.now());

    }

}
