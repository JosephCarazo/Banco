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
//                menuPrincipal();
            case 2:
                menuCuentas();
//                menuPrincipal();
            case 3:
                menuTranferencias();
//                menuPrincipal();
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
                String cedula = leer.next();
                buscarCliente(cedula);
                menuPrincipal();
        }
    }

    public static void menuTranferencias() {
        Scanner leer = new Scanner(System.in);
        System.out.println("Digite que tipo de transaccion desea hacer\n1- Deposito\n2- Retiro\n3- Transferencia\n4- Salir");
        int transaccion = leer.nextInt();
        
        Cuenta c=new Cuenta();
        
        System.out.println("Ingrese la cuenta");
        String cuenta=leer.next();
        System.out.println("Ingrese el monto");
        double monto=leer.nextDouble();
//        Deposito depo=new Deposito(c,1,monto);
        double m=0;//almacena saldo
        switch (transaccion) {
            case 1:
                int pos=-1;
                for (int i = 0; i < cuentas.size(); i++) { 
                    if (cuentas.get(i).getNumeroCuenta().equals(cuenta)) { 
                        pos=i;
                        m=cuentas.get(pos).getSaldo();// obtenemos saldo de la cuenta
//                        depo.deposito(c, monto);
                     
//                        depo.setCuenta(c.getNumeroCuenta());
//                        cuentas.set(pos, c);
                      
                        c.setSaldo(m+monto);
                        c.setNumeroCuenta(cuenta);
                        cuentas.set(pos, c);
                        
                    }
                }
                if(pos!=-1){
                   System.out.println("============InfoCuenta==============");
                   System.out.println(cuentas.get(pos));
                   System.out.println("====================================");
                }else{
                    System.out.println("La cuenta digitada no existe en nuestra base de datos");
                }
            //DEPOSITO
                
            case 2:
            //RETIRO
              
            case 3:
            //TRANSFERENCIA
                
            case 4:
                menuPrincipal();
     
        }
    }

    // Menu que nuestra las opciones de la cuenta
    public static void menuCuentas() {
        Scanner leer = new Scanner(System.in);
        System.out.println("Digite una opcion\n1- Crear nueva cuenta\n2- Buscar cuenta\n3- Eliminar Cuenta\n4- Menu Principal");
        int op = leer.nextInt();
        switch (op) {
            case 1:
                crearCuenta();
                menuPrincipal();
                break;
            case 2:
                buscarCuenta();
                menuPrincipal();
                break;
            case 3:
                eliminarCuenta();
                menuPrincipal();
                break;
            case 4:
                menuPrincipal();
                break;
                        
               default:
                System.out.println("Digite una opcion correcta");
                menuCuentas();
                

        }
    }

    //Metodo para crear cuenta y agregar al arraylist
    public static void crearCuenta() {
        Scanner leer = new Scanner(System.in);
        System.out.println("Digite una opcion\n1- Crear cuenta Colones\n2- Crear cuenta Dolares\n3- Salir" );
        int op = leer.nextInt();
        long dig16;//Se guarda el numero aleatorio para la cuenta
        double saldo=0;
        switch (op) {
            case 1:
               
                Cuenta colones = new Cuenta();
                Random rc = new Random();
                dig16 = rc.nextLong(9000000000000000L) + 1000000000000000L;
                String cColones = String.valueOf("CR"+dig16);
                colones.setNumeroCuenta(cColones);
                System.out.println("Ingrese el monto inicial de la cuenta");
                saldo = leer.nextDouble();
                colones.setSaldo(saldo);
                cuentas.add(colones);
                System.out.println("Numero Cuenta= " + colones.getNumeroCuenta());
                System.out.println("Saldo Disponible= " + colones.getSaldo()+" Colones");
                break;
            case 2:
                Cuenta dolares = new Cuenta();
                Random rd = new Random();
                dig16 = rd.nextLong(9000000000000000L) + 1000000000000000L;
                String nCuenta = String.valueOf("CR"+dig16);
                dolares.setNumeroCuenta(nCuenta);
                System.out.println("Ingrese el monto inicial de la cuenta");
                saldo = leer.nextDouble();
                dolares.setSaldo(saldo);
                cuentas.add(dolares);
                System.out.println("**********Cuenta Creada***********");
                System.out.println("Numero Cuenta= " + dolares.getNumeroCuenta());
                System.out.println("Saldo Disponible= " + dolares.getSaldo()+" Dolares");
                System.out.println("");
                break;
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
        System.out.println("Digite el numero de cuenta que quiere buscar");
        String cuenta=leer.next();
       
       int pos=-1;
        for (int i = 0; i < cuentas.size(); i++) { 
            if (cuentas.get(i).getNumeroCuenta().equals(cuenta)) {    
                pos=i;                   
            }
        }
        if(pos!=-1){
           System.out.println(cuentas.get(pos)+ " Posicion : "+pos+" --Cuenta encontrada: "); 
        }else{
            System.out.println("La cuenta digitada no existe en nuestra base de datos");
        }

    }

    //Metodo para eliminar cuenta
    public static void eliminarCuenta() {
        Scanner leer = new Scanner(System.in);
        System.out.println("Ingrese la cuenta que desea eliminar ");
       String cuenta=leer.next();
       int pos=-1;
        for (int i = 0; i < cuentas.size(); i++) {
            if(cuentas.get(i).getNumeroCuenta().equals(cuenta)){
                if(cuentas.get(i).getSaldo()==0){// revisa si la cuenta solicitada esta en cero 
                    pos=i;
                   cuentas.remove(pos); 
                }
            }
        }
        if(pos!=-1){
           System.out.println("Cuenta Eliminada"); 
        }else{
            System.out.println("La cuenta no se puede eliminar por que no esta en cero o no existe");
        }
    }

    //ESTE METODO AÑADE UN NUEVO CLIENTE
    public static void nuevoCliente() {
        Cliente cl = new Cliente();
        System.out.println("Por favor, digite los siguientes datos");
        pedirCedula(cl);
        rellenarNombre(cl);
        pedirFechaNac(cl);
        pedirNumero(cl);
        pedirCorreo(cl);
        cliente.add(cl);
        System.out.println("**********************\nSus datos:\nCedula: " + cl.getCedula() + "\nNombre: " + cl.getNombre()
                + "\nFecha de nacimiento: " + cl.getFechaNacimiento() + "\nTelefono: " + cl.getTelefono() + "\nCorreo: " + cl.getCorreo() + "\n**********************");
    }

    public static void pedirCedula(Cliente cliente) {
        Scanner leer = new Scanner(System.in);
        String cedula;
        do {
            System.out.println("Digite el número de cedula (#0###0###)");
            cedula = leer.nextLine();
            System.out.println(cedula.length());
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
        String[] Nombre = new String[]{"Hugo", "Martín", "Lucas", "Mateo", "Leo", "Daniel", "Alejandro", "Pablo", "Manuel", "Álvaro", "Adrián", "David", "Mario", "Enzo", "Diego", "Marcos", "Izan", "Javier", "Marco", "Álex", "Bruno", "Oliver", "Miguel", "Thiago", "Antonio"};
        String[] Apellido = new String[]{"Rodríguez", "Vargas", "Jiménez", "Mora", "Rojas", "González", "Sánchez", "Hernández", "Ramírez", "Castro", "López", "Araya", "Solano", "Alvarado", "Chaves", "Pérez", "Morales", "Campos", "Quesada", "Gómez", "Arias", "Zúñiga", "Quiros", "Fernández", "Salazar"};
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

    public static void buscarCliente(String cedula) {
        for (Cliente clientes : cliente) {
            if (clientes.getCedula().equals(cedula)) {
                System.out.println("Este Cliente si existe: ");
                System.out.println(clientes);
            } else {
                System.out.println("Este cliente no existe");
            }
        }

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
