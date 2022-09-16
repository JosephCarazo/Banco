/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package banco;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author joans
 */
public class Cliente {

    private String cedula;
    private String nombre;
    private String fechaNacimiento;
    private String telefono;
    private String correo;
    private boolean tarjetaCredito;
    private static ArrayList<Cuenta> cuentas = new ArrayList<>();

    public String getCedula() {
        return cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String edad) {
        this.fechaNacimiento = edad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public boolean isTarjetaCredito() {
        return tarjetaCredito;
    }

    public void setTarjetaCredito(boolean tarjetaCredito) {
        this.tarjetaCredito = tarjetaCredito;
    }

    public Cliente(String cedula, String nombre, String fechaNacimiento, String telefono, String correo, boolean tarjetaCredito) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.correo = correo;
        this.tarjetaCredito = tarjetaCredito;
    }

    public Cliente() {
        this("000000000", "Usuario", null, null, null, false);
    }

    public Cliente(String cedula) {
        this.cedula = cedula;
    }

    public void validarTarjetaC() {
        if (isTarjetaCredito()) {
            System.out.println("Usted ya posee una tarjeta de credito");
        }
    }

    public boolean validarCedula(String cedula) {
        boolean validacion = false;
        if (cedula.length() == 9) {
            try {
                validacion = true;
                this.setCedula(cedula);
            } catch (NumberFormatException nfe) {//EN CASO DE QUE HAYAN PUESTO LETRAS EN LA CEDULA
                System.out.println("Solo digitos. No olvidar poner los ceros");
                validacion = false;
            }
        } else {
            System.out.println("Recuerde su cedula tiene una cantidad de 11 digitos");
            validacion = false;
        }
        return validacion;
    }

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

    public Cuenta buscarCuentaPos(String numdeCuenta) {
        for (Cuenta cuent : cuentas) {
            if (cuent.getNumeroCuenta().equals(numdeCuenta)) {
                System.out.println("Esta cuenta si existe: ");
                System.out.println(cuent);
                return cuent;

            } else {
                System.out.println("Esa cuenta no existe " + numdeCuenta);

            }

        }
        return null;

    }

    public void eliminarCuenta() {
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

    @Override
    public String toString() {
        return "Cliente" + "\nCedula: " + cedula + "\nNombre: " + nombre + "\nFechaNacimiento: " + fechaNacimiento + "\nTelefono: " + telefono + "\nCorreo: " + correo;
    }

}
