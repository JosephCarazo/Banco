/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package banco;

/**
 *
 * @author Francisco
 */
public class TarjetaDebito extends Tarjeta {

    public TarjetaDebito(Cuenta cuenta) {
        super(cuenta);
        this.generarNumeroTarjeta();
    }

    @Override
    public void generarNumeroTarjeta() {
        super.generarNumeroTarjeta();
    }

}
