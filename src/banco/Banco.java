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
    protected static ArrayList<Cuenta> cuentas = new ArrayList<>();
    protected static ArrayList<Transferencia> transferencia = new ArrayList<>();

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
                String Ccliente= leer.nextLine();
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
        double m = 0, monto;//almacena saldo
        String cuenta;
        switch (transaccion) {
            case 1:
                System.out.println("\nIngrese la cuenta");
                cuenta = leer.next();
                System.out.println("\nIngrese el monto");
                monto = leer.nextDouble();
                deposito(cuenta, monto, c, m);
                menuPrincipal();
            case 2:
                System.out.println("\nIngrese la cuenta");
                cuenta = leer.next();
                System.out.println("\nIngrese el monto");
                monto = leer.nextDouble();
                retiro(cuenta, c, monto, m);
                menuPrincipal();
            case 3:
                submenuTrasferencia();
                menuPrincipal();
        }
    }

    private static void submenuTrasferencia() {
        String Cuenta1, Cuenta2;
        Scanner leer = new Scanner(System.in);
        System.out.println("Cuenta 1");
        Cuenta1 = leer.nextLine();
        System.out.println("Cuenta 2");
        Cuenta2 = leer.nextLine();
        if (buscarCuentaPos(Cuenta1) == null || buscarCuentaPos(Cuenta2) == null) {
            System.out.println("Cuentas no encontrada");
        } else {
            transferencia(buscarCuentaPos(Cuenta1), buscarCuentaPos(Cuenta2));
        }
    }

    // Menu que nuestra las opciones de la cuenta
    public static void menuCuentas() {
        Scanner leer = new Scanner(System.in);
        System.out.println("\nDigite una opcion\n1- Crear nueva cuenta\n2- Buscar cuenta\n3- Eliminar Cuenta\n4- Menu Principal");
        int op = leer.nextInt();
        switch (op) {
            case 1 -> {
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
    public static void buscarCuenta() {
        Scanner leer = new Scanner(System.in);
        System.out.println("\nDigite el numero de cuenta que quiere buscar");
        String cuenta = leer.next();

        int pos = -1;
        for (int i = 0; i < cuentas.size(); i++) {
            if (cuentas.get(i).getNumeroCuenta().equals(cuenta)) {
                pos = i;
            }
        }
        if (pos != -1) {
            System.out.println("\n*** CUENTA ENCONTRADA ***" + cuentas.get(pos) + "\nPosicion : " + pos + "\n************************\n");

        } else {
            System.out.println("\nLa cuenta digitada no existe en la base de datos\n\n");
        }

    }

    public static Cuenta buscarCuentaPos(String numdeCuenta) {
        for (Cuenta cuent : cuentas) {
            if (cuent.getNumeroCuenta().equals(numdeCuenta)) {
                System.out.println("Esta cuenta si existe: ");
                System.out.println(cuent);
                return cuent;

            } else {
                System.out.println("Esa cuenta no existe "+numdeCuenta);

            }

        }
        return null;

    }

    //Metodo para eliminar cuenta
    public static void eliminarCuenta() {
        Scanner leer = new Scanner(System.in);
        System.out.println("\nIngrese la cuenta que desea eliminar ");
        String cuenta = leer.next();
        int pos = -1;
        for (int i = 0; i < cuentas.size(); i++) {
            if (cuentas.get(i).getNumeroCuenta().equals(cuenta)) {
                if (cuentas.get(i).getSaldo() == 0) {// revisa si la cuenta solicitada esta en cero 
                    pos = i;
                    cuentas.remove(pos);
                }
            }
        }
        if (pos != -1) {
            System.out.println("\n** CUENTA ELIMINADA ** \n");
        } else {
            System.out.println("\nLa cuenta no se puede eliminar porque no esta en cero o no existe\n");
        }
    }

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

    public static void deposito(String cuenta, double monto, Cuenta c, double m) {
        int pos = -1;
        for (int i = 0; i < cuentas.size(); i++) {

            if (cuentas.get(i).getNumeroCuenta().equals(cuenta)) {
                pos = i;
                m = cuentas.get(pos).getSaldo();// obtenemos saldo de la cuenta
//                        depo.deposito(c, monto);

//                        depo.setCuenta(c.getNumeroCuenta());
//                        cuentas.set(pos, c);
                c.setSaldo(m + monto);
                c.setNumeroCuenta(cuenta);
                cuentas.set(pos, c);
            }
        }
        if (pos != -1) {
            System.out.println("\n==========Retiro exitoso===========");
            System.out.println("\nMonto Depositado: " + monto);
            System.out.println("\n============Informacion de Cuenta==============");
            System.out.println(cuentas.get(pos));
            System.out.println("====================================");
        } else {
            System.out.println("La cuenta digitada no existe en la base de datos");
        }
    }

    public static void cuentaDolares(long dig16, double saldo) {
        Scanner leer = new Scanner(System.in);
        System.out.println("Escriba la cedula del cliente");
        String cliente = leer.nextLine();
        if (buscarCliente(cliente)) {

            Cuenta dolares = new Cuenta();
            Random rd = new Random();
            dig16 = rd.nextLong(9000000000000000L) + 1000000000000000L;
            String nCuenta = String.valueOf("CR" + dig16);
            dolares.setNumeroCuenta(nCuenta);
            System.out.println("\nIngrese el monto inicial de la cuenta");
            saldo = leer.nextDouble();
            dolares.setSaldo(saldo);
            dolares.setCedulaDueño(cliente);
            cuentas.add(dolares);
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
            Cuenta colones = new Cuenta();
            Random rc = new Random();
            dig16 = rc.nextLong(9000000000000000L) + 1000000000000000L;
            String cColones = String.valueOf("CR" + dig16);
            colones.setNumeroCuenta(cColones);
            System.out.println("\nIngrese el monto inicial de la cuenta");
            saldo = leer.nextDouble();
            colones.setCedulaDueño(cliente);
            colones.setSaldo(saldo);
            cuentas.add(colones);
            System.out.println("**********Cuenta Creada***********");
            System.out.println("Numero Cuenta = " + colones.getNumeroCuenta());
            System.out.println("Saldo Disponible = " + colones.getSaldo() + " colones\n");
        } else {
            System.out.println("Cliente no existe, no se le puede abrir cuenta");
        }

    }

    public static void retiro(String cuenta, Cuenta c, double monto, double m) {
        int pos = -1;
        for (int i = 0; i < cuentas.size(); i++) {
            pos = i;
            if (cuentas.get(i).getNumeroCuenta().equals(cuenta)) {
                m = cuentas.get(pos).getSaldo();
                c.setSaldo(m - monto);
                c.setNumeroCuenta(cuenta);
                cuentas.set(pos, c);
            }
        }
        if (pos != -1) {
            System.out.println("\n==========Retiro exitoso===========");
            System.out.println("\nMonto retirado: " + monto);
            System.out.println("\n============Informacion de Cuenta==============");
            System.out.println(cuentas.get(pos));
            System.out.println("====================================");
        } else {
            System.out.println("\nLa cuenta digitada no existe en nuestra base de datos");
        }
    }
    static int contaDeTransferencia = 0;

    public static void transferencia(Cuenta c1, Cuenta c2) {
        System.out.println("Monto a trasferir");
        Scanner leer = new Scanner(System.in);
        double monto = leer.nextDouble();
        contaDeTransferencia++;
        Transferencia t1 = new Transferencia(c1, c2, contaDeTransferencia, c1.getNumeroCuenta() + " / " + c2.numeroCuenta, monto, c1.getSaldo());
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
        menuPrincipal();
    }
}
