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

    public Retiro(Cuenta c1,int id, String cuenta, double monto, double saldoAnterior) {
        super(c1,id, cuenta, monto, saldoAnterior);
        Retiro(c1,monto);
    }
    private void Retiro(Cuenta c1 ,double monto){
        if(monto>c1.getSaldo()){
            System.out.println("Saldo insuficiente");
        }else{
            c1.setSaldo(c1.getSaldo()-monto);
        }
            
    }
    
   
    
}
