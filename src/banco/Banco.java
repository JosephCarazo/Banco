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

    public static void menuPrincipal() {
        Scanner leer = new Scanner(System.in);
        System.out.println("*** BIENVENIDO A BANCO UTN ***");
        System.out.println("Seleccione un tema");
        System.out.println("1- Cliente \n2- Cuenta\n3- Transacciones\n4- Salir");
        int opcion = leer.nextInt();
        switch (opcion) {
            case 1:
                menuClientes();
            case 2:
                crearCuenta();
                menuPrincipal();
            case 3:
                menuTranferencias();
                menuPrincipal();
            case 4:
                break;
            default:
                System.out.println("Digite una opcion correcta");
                menuPrincipal();
        }
    }

    public static void menuClientes() {
        Scanner leer = new Scanner(System.in);
        System.out.println("Digite una opcion\n1- Crear nuevo cliente\n2- Buscar cliente");
        int op = leer.nextInt();
        switch (op) {
            case 1:
                nuevoCliente();
                menuPrincipal();
            case 2:
                System.out.println("Digite la cedula del cliente que desea buscar");
                int cedula = leer.nextInt();
                buscarCliente();
                menuPrincipal();
        }
    }

    public static void menuTranferencias() {
        Scanner leer = new Scanner(System.in);
        System.out.println("Digite que tipo de transaccion desea hacer\n1- Deposito\n2- Retiro\n3- Transferencia\n4- Salir");
        int transaccion = leer.nextInt();
        switch (transaccion) {
            case 1:
            //DEPOSITO
            case 2:
            //RETIRO
            case 3:
            //TRANSFERENCIA
            case 4:
                menuPrincipal();
        }
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
        pedirCedula(cl);
        pedirFechaNac(cl);
        pedirNumero(cl);
        pedirCorreo(cl);
        cliente.add(cl);
        System.out.println("**********************\nSus datos:\nCedula: " + cl.getCedula() + "\nNombre: " + cl.getNombre()
                + "\nFecha de nacimiento: " + cl.getFechaNacimiento() + "\nTelefono: " + cl.getTelefono() + "\nCorreo: " + cl.getCorreo() + "\n**********************");
    }
    
public static void pedirCedula(Cliente cliente){
    Scanner leer = new Scanner(System.in);
    String cedula;
    do{
        System.out.println("Digite el número de cedula (#0###0###)");
    cedula= leer.nextLine();
    }while(cliente.validarCedula(cedula));
 rellenarNombre(cliente);
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
    public static void rellenarNombre(Cliente cliente) {
        Random r= new Random();
        String[] Nombre = new String[]{"Hugo", "Martín", "Lucas", "Mateo", "Leo", "Daniel", "Alejandro", "Pablo", "Manuel", "Álvaro", "Adrián", "David", "Mario", "Enzo", "Diego", "Marcos", "Izan", "Javier", "Marco", "Álex", "Bruno", "Oliver", "Miguel", "Thiago", "Antonio"};
        String[] Apellido = new String[]{"Rodríguez", "Vargas", "Jiménez", "Mora", "Rojas", "González", "Sánchez", "Hernández", "Ramírez", "Castro", "López", "Araya", "Solano", "Alvarado", "Chaves", "Pérez", "Morales", "Campos", "Quesada", "Gómez", "Arias", "Zúñiga", "Quiros", "Fernández", "Salazar"};
        String nombreCompleto = r.nextInt(Nombre.length) + " " + r.nextInt(Apellido.length) + " " + r.nextInt(Apellido.length);
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

    public static boolean buscarCliente() {
boolean encontrado=false;
        Scanner leer = new Scanner(System.in);
       int cedula=leer.nextInt();
       Cliente busqueda= new Cliente(cedula);
for (int x = 0; x < cliente.size(); x++) {
  Cliente p = cliente.get(x);
  String ced1= String.valueOf(p.getCedula());
  if (ced1.equals(busqueda.getCedula())) {
      encontrado = true;
      System.out.println("Posicion de la lista "+ x);
      break; // Terminar ciclo
  } 
    }
return encontrado;
    }
    //ESTE METODO MUESTRA UN MENSAJE DE ERROR
    public static void error() {
        System.out.println("*****  ERROR  ******\nDato no valido\n********************");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        menuPrincipal();
    }
}
