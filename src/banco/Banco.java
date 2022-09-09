/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package banco;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author joans
 */
public class Banco {

    ArrayList<Cuenta> cuentas = new ArrayList<>();
    ArrayList<Cliente> cliente = new ArrayList<>();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        Scanner leer = new Scanner(System.in);
//
//        System.out.println("*** BIENVENIDO A BANCO UTN ***");
//        menu();
//        int opcion = leer.nextInt();
//        switch (opcion) {
//            case 1:
//            case 2:
//            case 3:
//            default:
//                System.out.println("Digite una opcion correcta");
//        }
        nuevoCliente();
    }

    public static void menu() {
        System.out.println("Seleccione la opcion que desea realizar: \n1- Crear una cuenta\n2- Deposito\n3- Retiro \n4- Transferencia");
    }

    public static void nuevoCliente() {
        Scanner leer = new Scanner(System.in);
        Cliente cl = new Cliente();
        int dia, mes, annio;
        String diaString = "", mesString = "", annioString = "";
        System.out.println("Por favor, digite los siguientes datos");
        pedirNombre(cl, leer);
//        pedirFechaNac(cl, leer);
//        pedirCorreo(cl, leer);
    }

    public static void error() {
        System.out.println("*****  ERROR  ******\nDato no valido\n********************");
    }

    public static void pedirFechaNac(Cliente cliente, Scanner leer) {
        int dia, mes, annio;
        String diaString = "", mesString = "", annioString = "";
        do {
            System.out.print("Dia de nacimiento(DD): ");
            dia = leer.nextInt();
            if (dia < 1 || dia > 30) {
                error();
            }
            if (dia == 1 || dia == 2 || dia == 3 || dia == 4 || dia == 5 || dia == 6 || dia == 7 || dia == 8 || dia == 9) {
                diaString = "0" + dia;
            } else {
                diaString = String.valueOf(dia);
            }
        } while (dia < 1 || dia > 30);

        do {
            System.out.print("Mes de nacimiento (MM): ");
            mes = leer.nextInt();
            if (mes < 1 || mes > 12) {
                error();
            }
            if (mes == 1 || mes == 2 || mes == 3 || mes == 4 || mes == 5 || mes == 6 || mes == 7 || mes == 8 || mes == 9) {
                mesString = "0" + mes;
            } else {
                mesString = String.valueOf(mes);
            }
        } while (mes < 1 || mes > 12);

        do {
            System.out.print("Annio de nacimiento (YYYY): ");
            annio = leer.nextInt();
            if (annio < 1800 || annio > 2022) {
                error();
            }
            annioString = String.valueOf(annio);
        } while (annio < 1800 || annio > 2022);
        String fechaNac = diaString + "/" + mesString + "/" + annioString;
        cliente.setFechaNacimiento(fechaNac);
    }

    public static void pedirNombre(Cliente cliente, Scanner leer) {
        System.out.print("Digite su nombre: ");
        String nombre = leer.next();
        System.out.print("Digite su primer apellido: ");
        String apellido1 = leer.next();
        System.out.print("Digite su segundo apellido: ");
        String apellido2 = leer.next();
        String nombreCompleto = nombre + " " + apellido1 + " " + apellido2;
        cliente.setNombre(nombreCompleto);
        System.out.println(nombreCompleto);
    }

    public static void pedirNumero(Cliente cliente, Scanner leer) {
        System.out.println("\nDigite su numero (Opcional)\nSi desea saltar esta opcion digite 1");
        String numero = leer.next();
        if (numero == "1") {
            numero = null;
        }
        cliente.setTelefono(numero);
    }

    public static void pedirCorreo(Cliente cliente, Scanner leer) {
        System.out.println("\nDigite su correo electronico (Opcional)\nSi desea saltar esta opcion digite 1");
        String correo = leer.next();
        if (correo == "1") {
            correo = null;
        }
        cliente.setCorreo(correo);
    }
}
