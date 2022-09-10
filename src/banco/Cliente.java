/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package banco;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author joans
 */
public class Cliente {

    private int cedula;
    private String nombre;
    private String fechaNacimiento;
    private String telefono;
    private String correo;

    public int getCedula() {
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
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Cliente(int cedula, String nombre, String fechaNacimiento, String telefono, String correo) {
        this.cedula=cedula;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.correo = correo;
    }

    public Cliente() {
        this(000000000, "Usuario", null, null, null);
    }

    public boolean  validarCedula(String cedula) {
        boolean validacion=false;
        if (cedula.length()==11){
        try{
        int digitos= Integer.parseInt(cedula);
        validacion=true;
        this.setCedula(digitos);
        }catch(NumberFormatException nfe){
            System.out.println("Solo digitos, No olvidar poner los ceros");
            validacion=false;
        }
        }else {
            System.out.println("Recuerde su cedula tiene una cantidad de 11 digitos");
            validacion=false;
        }
        return validacion;
    }

    public void obtenerEdad() {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fechaNac = LocalDate.parse(fechaNacimiento, formato);
        LocalDate ahora = LocalDate.now();

        Period periodo = Period.between(fechaNac, ahora);
        System.out.printf("%s anios", periodo.getYears()); System.out.println("");
    }

    
    @Override
    public String toString() {
        return "Cliente" + "\nCedula: " + cedula + "\nNombre: " + nombre + "\nEdad: " + fechaNacimiento + "\nTelefono: " + telefono + "\nCorreo: " + correo;
    }

}
