
package com.srv.dto;


public class Pasaje {
    private int idPasaje;
    private int idCliente;
    private int idVuelo;
    private String asiento;
    private String clase;
    private String valor;

    public Pasaje(int idPasaje, int idCliente, int idVuelo, String asiento, String clase, String valor) {
        this.idPasaje = idPasaje;
        this.idCliente = idCliente;
        this.idVuelo = idVuelo;
        this.asiento = asiento;
        this.clase = clase;
        this.valor = valor;
    }
    public Pasaje( int idCliente, int idVuelo, String asiento, String clase, String valor) {
       
        this.idCliente = idCliente;
        this.idVuelo = idVuelo;
        this.asiento = asiento;
        this.clase = clase;
        this.valor = valor;
    }
    public int getIdPasaje() {
        return idPasaje;
    }

    public void setIdPasaje(int idPasaje) {
        this.idPasaje = idPasaje;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdVuelo() {
        return idVuelo;
    }

    public void setIdVuelo(int idVuelo) {
        this.idVuelo = idVuelo;
    }

    public String getAsiento() {
        return asiento;
    }

    public void setAsiento(String asiento) {
        this.asiento = asiento;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Pasaje{" + "idPasaje=" + idPasaje + ", idCliente=" + idCliente + ", idVuelo=" + idVuelo + ", asiento=" + asiento + ", clase=" + clase + ", valor=" + valor + '}';
    }
    
    
}
