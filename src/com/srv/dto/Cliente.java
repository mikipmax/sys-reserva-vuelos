package com.srv.dto;

import java.util.logging.Logger;

public class Cliente {

    private int idCliente;
    private String nombre;
    private String apellido;
    private int edad;
    private int telefono;
    private String direccion;
    private String ruc;
    private static final Logger LOG = Logger.getLogger(Cliente.class.getName());

    public Cliente(int idCliente, String nombre, String apellido, int edad, int telefono, String direccion, String ruc) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.telefono = telefono;
        this.direccion = direccion;
        this.ruc = ruc;
    }

    public Cliente( String nombre, String apellido, int edad, int telefono, String direccion, String ruc) {
     
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.telefono = telefono;
        this.direccion = direccion;
        this.ruc = ruc;
    }


    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }



    @Override
    public String toString() {
        return "Cliente{" + "idCliente=" + idCliente + ", nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad + ", telefono=" + telefono + ", direccion=" + direccion + ", ruc=" + ruc + '}';
    }

}
