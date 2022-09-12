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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public double getSaldoAnterior() {
        return saldoAnterior;
    }

    public void setSaldoAnterior(double saldoAnterior) {
        this.saldoAnterior = saldoAnterior;
    }

    public double getSaldoFinal() {
        return saldoFinal;
    }

    public void setSaldoFinal(double saldoFinal) {
        this.saldoFinal = saldoFinal;
    }

    public String getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(String fechaHora) {
        this.fechaHora = fechaHora;
    }

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

    @Override
    public String toString() {
        return "Transaccion{" + "id=" + id + ", cuenta=" + cuenta + ", monto=" + monto + ", saldoAnterior=" + saldoAnterior + ", saldoFinal=" + saldoFinal + ", fechaHora=" + fechaHora + '}';
    }

}
