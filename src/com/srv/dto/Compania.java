
package com.srv.dto;


public class Compania {
private int idCompania;
private String nombre;
private String direccion;
private int telefono;
private String ruc;

    public Compania(int idCompania, String nombre, String direccion, int telefono, String ruc) {
        this.idCompania = idCompania;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.ruc = ruc;
    }

    public Compania( String nombre, String direccion, int telefono, String ruc) {
      
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.ruc = ruc;
    }
   


public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public int getIdCompania() {
        return idCompania;
    }

    public void setIdCompania(int idCompania) {
        this.idCompania = idCompania;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }



    @Override
    public String toString() {
        return "Compania{" + "idCompania=" + idCompania + ", nombre=" + nombre + ", direccion=" + direccion + ", telefono=" + telefono + ", ruc=" + ruc + '}';
    }


}
