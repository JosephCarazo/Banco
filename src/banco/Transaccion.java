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

    public Transaccion(int id, String cuenta, double monto, double saldoAnterior) {
        this.id = id;
        this.cuenta = cuenta;
        this.monto = monto;
        this.saldoAnterior = saldoAnterior;
        this.fechaHora="";
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
    
    public void fechaHora(){
        this.fechaHora = String.valueOf(LocalDateTime.now());
    }

    public Transaccion(String cuenta, double monto) {
        generarId();
        fechaHora();
        this.cuenta = cuenta;
        this.monto = monto;
        this.saldoAnterior = saldoFinal + monto;
        this.saldoFinal = saldoFinal - monto;
    }

    @Override
    public String toString() {
        return "Transaccion{" + "id=" + id + ", cuenta=" + cuenta + ", monto=" + monto + ", saldoAnterior=" + saldoAnterior + ", saldoFinal=" + saldoFinal + ", fechaHora=" + fechaHora + '}';
    }

}
