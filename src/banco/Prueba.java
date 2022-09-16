/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package banco;

import java.time.LocalDate;

/**
 *
 * @author joans
 */
public class Prueba {
private String fechaRegreso;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int dias=10;
        System.out.println(calcularFechaRegreso(dias));
    }
     public static String calcularFechaRegreso(int cantidadDeDias){
    String fechadeRegreso=String.valueOf( LocalDate.now().plusDays(cantidadDeDias));
    return fechadeRegreso;
    }
}
