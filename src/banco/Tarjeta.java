/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package banco;

import java.util.Random;

/**
 *
 * @author Francisco
 */
public abstract class Tarjeta {

    protected String numeroTarjeta;
    protected Cuenta cuenta;

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public Tarjeta(String numeroTarjeta, Cuenta cuenta) {
        generarNumeroTarjeta();
        this.cuenta = cuenta;
    }

    public void generarNumeroTarjeta() {
        Random rd = new Random();
        long dig16 = rd.nextLong(9000000000000000L) + 1000000000000000L;
        String numTarjeta = String.valueOf(dig16);
        this.numeroTarjeta = numTarjeta;
    }
}
