/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package banco;

/**
 *
 * @author Francisco
 */
public class TarjetaCredito extends Tarjeta {

    private String fechaCorte;
    private double saldo;
    private double limite;

    public TarjetaCredito(String fechaCorte, double saldo, double limite, int numeroTarjeta, String cuenta) {
        super(numeroTarjeta, cuenta);
        this.fechaCorte = fechaCorte;
        this.saldo = saldo;
        this.limite = limite;
    }

    
    
}
