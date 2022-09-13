    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package banco;

/**
 *
 * @author joans
 */
public class Transferencia extends Transaccion {

    public Transferencia(Cuenta c1, Cuenta c2,int id, String cuenta, double monto, double saldoAnterior) {
        super(id, cuenta, monto, saldoAnterior);
        tranferencia(c1,c2,monto);
    }

    public Transferencia(String cuenta, double monto) {
        super(cuenta, monto);
    }

    public void tranferencia(Cuenta c1, Cuenta c2, double monto){
        if (c1.getSaldo() < monto) {
            System.out.println("Saldo insuficiente");
        }else{
            c2.setSaldo(c2.getSaldo() + monto);
            c1.setSaldo(c1.getSaldo() - monto);
            System.out.println("Transferencia exitosa entre la cuenta "+c1.getNumeroCuenta()+" y la cuenta "+c2.getNumeroCuenta());
}
    }
}
