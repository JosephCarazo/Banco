/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package banco;

/**
 *
 * @author joans
 */
public class Retiro extends Transaccion {

    public Retiro(int id, String cuenta, double monto, double saldoAnterior) {
        super(id, cuenta, monto, saldoAnterior);
        retiro(monto);
    }
    
    private void retiro(double monto){
        if(monto>this.saldoAnterior){
            System.out.println("No tienes sufientes fondos para retirar la cantidad de "+monto);
        }else{
    this.saldoFinal=this.saldoAnterior-monto;
            System.out.println("Retiro exitoso");
        }
    }
    
}
