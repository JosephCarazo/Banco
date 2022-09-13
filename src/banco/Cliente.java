/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package banco;

import java.io.PrintStream;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

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

    public Cliente(String cedula, String nombre, String fechaNacimiento, String telefono, String correo) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.correo = correo;
    }

    public Cliente() {
        this("000000000", "Usuario", null, null, null);
    }

    public Cliente(String cedula) {
        this.cedula = cedula;
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

    @Override
    public String toString() {
        return "Cliente" + "\nCedula: " + cedula + "\nNombre: " + nombre + "\nFechaNacimiento: " + fechaNacimiento + "\nTelefono: " + telefono + "\nCorreo: " + correo;
    }

}
