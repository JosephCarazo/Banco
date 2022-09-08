/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package banco;

/**
 *
 * @author Francisco
 */
public class Tarjeta {
    private int numeroTarjeta;
    private String cuenta;

    public int getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(int numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public Tarjeta(int numeroTarjeta, String cuenta) {
        this.numeroTarjeta = numeroTarjeta;
        this.cuenta = cuenta;
    }
    
     
    
}
