/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package banco;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author joans
 */
public class Banco {

    private static ArrayList<Cliente> cliente = new ArrayList<>();
    private static int contDepositos;

    protected static ArrayList<Transferencia> transferencia = new ArrayList<>();
    protected static ArrayList<Deposito> depositos = new ArrayList<>();
    protected static ArrayList<Retiro> retiros = new ArrayList<>();

    public static void menuPrincipal() {
        Scanner leer = new Scanner(System.in);
        System.out.println("*** BIENVENIDO A BANCO UTN ***");
        System.out.println("Seleccione un tema");
        System.out.println("1- Cliente \n2- Cuenta\n3- Transacciones\n4- Salir");
        int opcion = leer.nextInt();
        switch (opcion) {
            case 1:
                menuClientes();
                menuPrincipal();
            case 2:
                menuCuentas();
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

    public static void obtenerEdad() {
        Scanner leer = new Scanner(System.in);
        System.out.println("Digite la cedula del cliente al que desea conocer su edad");
        String cedula = leer.next();

        int pos = -1;
        for (int i = 0; i < cliente.size(); i++) {
            if (cliente.get(i).getCedula().equals(cedula)) {
                pos = i;
                DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate fechaNac = LocalDate.parse(cliente.get(i).getFechaNacimiento(), formato);
                LocalDate ahora = LocalDate.now();
                Period periodo = Period.between(fechaNac, ahora);
                System.out.printf("%s anios", periodo.getYears());
                System.out.println("");
            }
        }
        if (pos == -1) {
            System.out.println("El cliente con la cedula " + cedula + " no existe");
        }

    }

    public static void menuClientes() {
        Scanner leer = new Scanner(System.in);
        System.out.println("Digite una opcion\n1- Crear nuevo cliente\n2- Buscar cliente\n3- Saber edad de cliente");
        int op = leer.nextInt();
        switch (op) {
            case 1:
                nuevoCliente();
                menuPrincipal();
            case 2:
                System.out.println("Escriba el numero de cedula del Cliente a buscar");
                String Ccliente = leer.nextLine();
                buscarCliente(Ccliente); //QUE PASO ACA??
                menuPrincipal();
            case 3:
                obtenerEdad();
                menuPrincipal();
        }
    }

    public static void menuTranferencias() {
        Scanner leer = new Scanner(System.in);
        System.out.println("\nDigite que tipo de transaccion desea hacer\n1- Deposito\n2- Retiro\n3- Transferencia\n4- Salir");
        int transaccion = leer.nextInt();
        if (transaccion == 4) {
            menuPrincipal();
        }
        Cuenta c = new Cuenta();

//        Deposito depo=new Deposito(c,1,monto);
        double m = 0;//almacena saldo
        String cuenta,cedula;
        switch (transaccion) {
            case 1:
                System.out.println("\nIngrese la cedula");
                cedula = leer.next();
                System.out.println("\nIngrese la cuenta");
                cuenta = leer.next();
              
                deposito(cedula,cuenta);
                menuPrincipal();
            case 2:
                 System.out.println("\nIngrese la cedula");
                cedula = leer.next();
                System.out.println("\nIngrese la cuenta");
                cuenta = leer.next();
                retiro(cedula,cuenta);
                menuPrincipal();
            case 3:
                subTrasferencia();
                menuPrincipal();
        }
    }

    private static void subTrasferencia() {
        String Cuenta1, Cuenta2;
        Scanner leer = new Scanner(System.in);
        System.out.println("Escriba el numero de cedula de la persona");
        String cliente1 = leer.nextLine();
        System.out.println("Cuenta de " + cliente1);
        Cuenta1 = leer.nextLine();
        System.out.println("Escriba el numero de cedula de la persona a enviar la tranferencia");
        String cliente2 = leer.nextLine();
        System.out.println("Cuenta de " + cliente2);
        Cuenta2 = leer.nextLine();
        if (buscarCliente(cliente1) || buscarCliente(cliente2) || retornarCliente(cliente1) == null || retornarCliente(cliente2) == null) {
            System.out.println("Error");
        } else {
            if (retornarCliente(cliente1).buscarCuentaPos(Cuenta1) == null || retornarCliente(cliente2).buscarCuentaPos(Cuenta2) == null) {
                System.out.println("Cuentas no encontradas");
            } else {
                transferencia(retornarCliente(cliente1).buscarCuentaPos(Cuenta1), retornarCliente(cliente2).buscarCuentaPos(Cuenta2));
            }
        }

    }

    // Menu que nuestra las opciones de la cuenta
    public static void menuCuentas() {
        Scanner leer = new Scanner(System.in);
        System.out.println("\nDigite una opcion\n1- Crear nueva cuenta\n2- Buscar cuenta\n3- Eliminar Cuenta\n4- Menu Principal");
        int op = leer.nextInt();

        switch (op) {
            case 1 -> {
                Cuenta c1= new Cuenta();
                crearCuenta();
                menuPrincipal();
            }
            case 2 -> {
                buscarCuenta();
                menuPrincipal();
            }
            case 3 -> {
                eliminarCuenta();
                menuPrincipal();
            }
            case 4 ->
                menuPrincipal();

            default -> {
                System.out.println("Digite una opcion correcta");
                menuCuentas();
            }

        }
    }

    private static void buscarCuenta() {
        Scanner leer = new Scanner(System.in);
        System.out.println("Escriba la cedula del cliente");
        String cedula = leer.nextLine();
        if (retornarCliente(cedula) != null) {
            System.out.println("Escriba el numero de cuenta");
            String nCuenta = leer.nextLine();
            retornarCliente(cedula).buscarCuentaPos(nCuenta);
        }

    }

    private static void eliminarCuenta() {
        Scanner leer = new Scanner(System.in);
        System.out.println("Escriba la cedula del cliente");
        String cedula = leer.nextLine();
        if (retornarCliente(cedula) != null) {
            System.out.println("Escriba el numero de cuenta");
            String nCuenta = leer.nextLine();
            retornarCliente(cedula).eliminarCuenta();
        }
    }

    //Metodo para crear cuenta y agregar al arraylist
    public static void crearCuenta() {
        Scanner leer = new Scanner(System.in);
        System.out.println("\nDigite una opcion\n1- Crear cuenta Colones\n2- Crear cuenta Dolares\n3- Salir");
        int op = leer.nextInt();
        long dig16 = 0;//Se guarda el numero aleatorio para la cuenta
        double saldo = 0;

        switch (op) {
            case 1:
               
                cuentaColones(dig16, saldo);
                menuPrincipal();
            case 2:
                cuentaDolares(dig16, saldo);
                menuPrincipal();
            case 3:
                menuPrincipal();
                break;
            default:
                System.out.println("Digite una opcion correcta");
                crearCuenta();

        }

    }

    // Metodo para buscar cuenta
    //Metodo para eliminar cuenta
    //ESTE METODO AÑADE UN NUEVO CLIENTE
    public static void nuevoCliente() {
        Cliente cl = new Cliente();
        System.out.println("\nPor favor, digite los siguientes datos");
        pedirCedula(cl);
        rellenarNombre(cl);
        pedirFechaNac(cl);
        pedirNumero(cl);
        pedirCorreo(cl);
        cliente.add(cl);
        System.out.println("\n**********************\nSus datos:\nCedula: " + cl.getCedula() + "\nNombre: " + cl.getNombre()
                + "\nFecha de nacimiento: " + cl.getFechaNacimiento() + "\nTelefono: " + cl.getTelefono() + "\nCorreo: " + cl.getCorreo() + "\n**********************");
    }

    public static void pedirCedula(Cliente cliente) {
        Scanner leer = new Scanner(System.in);
        String cedula;
        do {
            System.out.println("\nDigite el numero de cedula (#0###0###)");
            cedula = leer.nextLine();
        } while (!cliente.validarCedula(cedula));

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
        Random r = new Random();
        String[] Nombre = new String[]{"Hugo", "Martin", "Lucas", "Mateo", "Leo", "Daniel", "Alejandro", "Pablo", "Manuel", "Alvaro", "Adrian", "David", "Mario", "Enzo", "Diego", "Marcos", "Izan", "Javier", "Marco", "Alex", "Bruno", "Oliver", "Miguel", "Thiago", "Antonio"};
        String[] Apellido = new String[]{"Rodriguez", "Vargas", "Jimenez", "Mora", "Rojas", "Gonzalez", "Sanchez", "Hernandez", "Ramirez", "Castro", "Lopez", "Araya", "Solano", "Alvarado", "Chaves", "Perez", "Morales", "Campos", "Quesada", "Gomez", "Arias", "Watson", "Quiros", "Fernandez", "Salazar"};
        String nombreCompleto = Nombre[r.nextInt(Nombre.length)] + " " + Apellido[r.nextInt(Apellido.length)] + " " + Apellido[r.nextInt(Apellido.length)];
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

    public static boolean buscarCliente(String cedula) {
        boolean validacion = false;
        for (Cliente clientes : cliente) {
            if (clientes.getCedula().equals(cedula)) {
                System.out.println("Este cliente si existe: ");
                System.out.println(clientes);
                validacion = true;
            } else {
                System.out.println("Este cliente no existe");
                validacion = false;
            }

        }
        return validacion;
    }

    public static Cliente retornarCliente(String cedula) {
        for (Cliente clientes : cliente) {
            if (clientes.getCedula().equals(cedula)) {
                System.out.println("Este cliente si existe: ");
                System.out.println("");
                System.out.println(clientes);
                return clientes;
            } else {
                System.out.println("Este cliente no existe");

            }

        }
        return null;
    }

    public static void deposito(String cedula,String cuenta) {
        //-------------------------voy por aqui
        contDepositos++;
        Scanner leer = new Scanner(System.in);
        if (retornarCliente(cedula) != null || retornarCliente(cedula).buscarCuentaPos(cuenta) != null) {
            System.out.println("Escriba el monto a depositar");
            double monto = leer.nextDouble();
            Deposito d1 = new Deposito(contDepositos,retornarCliente(cedula).buscarCuentaPos(cuenta),monto);
            depositos.add(d1);
             System.out.println("\n==========Deposito exitoso===========");
            System.out.println(d1.toString());
            System.out.println("====================================");
        }else{
            System.out.println("Error");
        }  
        }
    
        

    // Metodo para generar el numero de cuenta
    public static String generaNumeroCuenta() {
        Random rd = new Random();
        String nCuenta = "";
        long dig16 = rd.nextLong(9000000000000000L) + 1000000000000000L;
        nCuenta = String.valueOf("CR" + dig16);

        return nCuenta;
    }

    public static void cuentaDolares(long dig16, double saldo) {
        Scanner leer = new Scanner(System.in);
        System.out.println("Escriba la cedula del cliente");
        String cliente = leer.nextLine();
        if (buscarCliente(cliente)) {
            System.out.println("\nIngrese el monto inicial de la cuenta");
            saldo = leer.nextDouble();
            String nCuenta = generaNumeroCuenta();
            CuentaDolares dolares = new CuentaDolares(nCuenta, saldo);
            retornarCliente(cliente).setCuentas(dolares);
            

            System.out.println("**********Cuenta Creada***********");
            System.out.println("Numero Cuenta = " + dolares.getNumeroCuenta());
            System.out.println("Saldo Disponible = " + dolares.getSaldo() + " dolares\n");
        } else {
            System.out.println("ERROR");
        }
    }

    public static void cuentaColones(long dig16, double saldo) {
        Scanner leer = new Scanner(System.in);
        System.out.println("Escriba el numero de cédula cliente");
        String cliente = leer.nextLine();
        if (buscarCliente(cliente)) {
            System.out.println("\nIngrese el monto inicial de la cuenta");
            saldo = leer.nextDouble();
            String nCuenta = generaNumeroCuenta();
            CuentaColones colones = new CuentaColones(nCuenta, saldo);
            retornarCliente(cliente).setCuentas(colones);

            System.out.println("**********Cuenta Creada***********");
            System.out.println("Numero Cuenta = " + colones.getNumeroCuenta());
            System.out.println("Saldo Disponible = " + colones.getSaldo() + " colones\n");
        } else {
            System.out.println("Cliente no existe, no se le puede abrir cuenta");
        }

    }

    public static void retiro(String cedula,String cuenta) {
        Scanner leer = new Scanner(System.in);
        if (retornarCliente(cedula) != null || retornarCliente(cedula).buscarCuentaPos(cuenta) != null) {
            System.out.println("Escriba el monto a retirar");
            double monto = leer.nextDouble();
            Retiro r1 = new Retiro(contDepositos,retornarCliente(cedula).buscarCuentaPos(cuenta),monto);
            retiros.add(r1);
             System.out.println("\n==========Retiro exitoso===========");
            System.out.println(r1.toString());
            System.out.println("====================================");
        }else{
            System.out.println("Error");
        }  
    }
    static int contaDeTransferencia = 0;

    public static void transferencia(Cuenta c1, Cuenta c2) {
        System.out.println("Monto a trasferir");
        Scanner leer = new Scanner(System.in);
        double monto = leer.nextDouble();
        contaDeTransferencia++;
        Transferencia t1 = new Transferencia(c1, c2, contaDeTransferencia, monto);
        transferencia.add(t1);
        System.out.println("");
    }

    //ESTE METODO MUESTRA UN MENSAJE DE ERROR
    public static void error() {
        System.out.println("\n*****  ERROR  ******\nDato no valido\n********************");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        menuPrincipal();
    }
}
