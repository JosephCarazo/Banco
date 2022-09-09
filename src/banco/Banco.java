/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package banco;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author joans
 */
public class Banco {

    private static ArrayList<Cuenta> cuentas = new ArrayList<>();
    private static ArrayList<Cliente> cliente = new ArrayList<>();

    public static void menu() {
        System.out.println("Bienvenido. Seleccione la opcion que desea realizar: \n1- Crear una cuenta\n2- Deposito\n3- Retiro\n4- Transferencia\n5- Salir");
    }

    //metodo para crear cuenta
    public static void crearCuenta() {
        Scanner leer = new Scanner(System.in);
        Cuenta c = new Cuenta();
        Random r = new Random();
        long dig16 = r.nextLong(9000000000000000L) + 1000000000000000L;
        String nCuenta = String.valueOf(dig16);
        c.setNumeroCuenta(nCuenta);
        System.out.println("Ingrese el monto inicial de la cuenta");
        double saldo = leer.nextDouble();
        c.setSaldo(saldo);
        System.out.println("Numero Cuenta= " + c.getNumeroCuenta());
        System.out.println("Saldo Disponible= " + c.getSaldo());
    }

    //ESTE METODO AÑADE UN NUEVO CLIENTE
    public static void nuevoCliente() {
        Cliente cl = new Cliente();
        System.out.println("Por favor, digite los siguientes datos");
        pedirNombre(cl);
        pedirFechaNac(cl);
        pedirNumero(cl);
        pedirCorreo(cl);
        cliente.add(cl);
        System.out.println("Sus datos:\nCedula: " + cl.getCedula() + "\nNombre: " + cl.getNombre() + "\nFecha de nacimiento: " + cl.getFechaNacimiento()
        + "\nTelefono: " + cl.getTelefono() + "\nCorreo: " + cl.getCorreo());
    }

    //ESTE METODO MUESTRA UN MENSAJE DE ERROR
    public static void error() {
        System.out.println("*****  ERROR  ******\nDato no valido\n********************");
    }

    //ESTE METODO SOLICITA LA FECHA EN EL FORMATO ESTABLECIDO
    public static void pedirFechaNac(Cliente cliente) {
        Scanner leer = new Scanner(System.in);
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
        cliente.setFechaNacimiento(diaString + "/" + mesString + "/" + annioString);
    }

    //CON ESTE METODO AÑADIMOS UN NOMBRE
    public static void pedirNombre(Cliente cliente) {
        Scanner leer = new Scanner(System.in);
        System.out.print("Digite su nombre: ");
        String nombre = leer.next();
        System.out.print("Digite su primer apellido: ");
        String apellido1 = leer.next();
        System.out.print("Digite su segundo apellido: ");
        String apellido2 = leer.next();
        String nombreCompleto = nombre + " " + apellido1 + " " + apellido2;
        cliente.setNombre(nombreCompleto);
    }

    //CON ESTE METODO SOLICITAMOS EL NUMERO DE TELEFONO, ESTA INFORMACION ES OPCIONAL
    public static void pedirNumero(Cliente cliente) {
        Scanner leer = new Scanner(System.in);
        System.out.println("\nDigite su numero (Opcional)\nSi desea saltar esta opcion digite 1");
        String numero = leer.next();
        if ("1".equals(numero)) {
            numero = null;
        }
        cliente.setTelefono(numero);
    }

    //CON ESTE METODO SOLICITAMOS EL CORREO ELECTRONICO, ESTA INFORMACION ES OPCIONAL
    public static void pedirCorreo(Cliente cliente) {
        Scanner leer = new Scanner(System.in);
        System.out.println("\nDigite su correo electronico (Opcional)\nSi desea saltar esta opcion digite 1");
        String correo = leer.next();
        if ("1".equals(correo)) {
            correo = null;
        }
        cliente.setCorreo(correo);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);

        System.out.println("*** BIENVENIDO A BANCO UTN ***");
        nuevoCliente();
        menu();
        int opcion = leer.nextInt();
        switch (opcion) {
            case 1:
                crearCuenta();
            case 2:
                //DEPOSITO
            case 3:
                //RETIRO
            case 4:
                //TRANSFERENCIA
            case 5: 
                break;
            default:
                System.out.println("Digite una opcion correcta");
        }
        // Para crear cuenta

    }

}
