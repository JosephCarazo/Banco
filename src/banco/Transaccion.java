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

    public Transaccion(Cuenta c,int id, double monto) { //Para deposito y retiro
        this.id = id;
        this.cuenta = c.getNumeroCuenta();
        this.monto = monto;
        this.saldoAnterior = c.getSaldo();
        this.fechaHora=String.valueOf(LocalDateTime.now());
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

    private void generarId() {
        this.id = (int) (Math.random() * 1000000);
    }
    
    

    public Transaccion(Cuenta c1,Cuenta c2,double monto) {
        generarId();
        this.fechaHora = String.valueOf(LocalDateTime.now());
        this.cuenta = c1.getNumeroCuenta();
        this.monto = monto;
        this.saldoAnterior = c1.getSaldo();
        this.saldoFinal = c2.getSaldo()+monto;
    }

    @Override
    public String toString() {
        return "Transaccion{" + " \nId=" + id + "\n Cuenta=" + cuenta + "\n Monto=" + monto + "\n SaldoAnterior=" + saldoAnterior + "\n SaldoFinal=" + saldoFinal + "\n FechaHora=" + fechaHora + '}';
    }

}
