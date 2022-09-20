/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package banco;

import java.time.LocalDate;

/**
 *
 * @author Francisco
 */
public class TarjetaCredito extends Tarjeta {

    private String fechaCorte;
    private double saldo;
    private double limite;

    public String getFechaCorte() {
        return fechaCorte;
    }

    public void setFechaCorte(String fechaCorte) {
        this.fechaCorte = fechaCorte;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    public TarjetaCredito(double saldo, double limite, Cuenta cuenta) {
        super(cuenta);
        calcularFechaCorte(30);
        this.generarNumeroTarjeta();
        this.saldo = saldo;
        this.limite = limite;
    }

    public TarjetaCredito() {
        this(0, 0, null);
    }

    @Override
    public void generarNumeroTarjeta() {
        super.generarNumeroTarjeta();
    }

    public void calcularFechaCorte(int cantidadDeDias) {
        String fechaC = String.valueOf(LocalDate.now().plusDays(cantidadDeDias));
        this.fechaCorte = fechaC;
    }

    @Override
    public String toString() {
        return "*** Tarjeta Credito ***" + "\nNumero tarjeta: " + this.numeroTarjeta + "\nCuenta: " + this.cuenta + "\nFecha Corte: " + fechaCorte + "\nSaldo: " + saldo + "\nLimite: " + limite;
    }

}
