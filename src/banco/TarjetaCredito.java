/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package banco;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Francisco
 */
public class TarjetaCredito extends Tarjeta {

    private Date fechaCorte;
    private double saldo;
    private double limite;

    public Date getFechaCorte() {
        return fechaCorte;
    }

    public void setFechaCorte(Date fechaCorte) {
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

    public TarjetaCredito(Date fechaCorte, double saldo, double limite, String numeroTarjeta, String cuenta) {
        super(numeroTarjeta, cuenta);
        this.fechaCorte = fechaCorte;
        this.saldo = saldo;
        this.limite = limite;
    }

    public static Date obtenerFechaAcutal() {
        Date fecha = new Date();
        return fecha;
    }

    public Date calcularFechaCorte(int dias) {
        if (dias == 0) {
            return obtenerFechaAcutal();
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(obtenerFechaAcutal());
        calendar.add(Calendar.DATE, dias);
        return this.fechaCorte =  calendar.getTime();
    }
}
