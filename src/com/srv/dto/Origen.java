package com.srv.dto;

public class Origen {

    private int idOrigen;
    private String nAeropuerto;
    private String ciudad;
    private String codCiudad;
    
    public Origen(int idOrigen, String nAeropuerto, String ciudad, String codCiudad) {
        this.idOrigen = idOrigen;
        this.nAeropuerto = nAeropuerto;
        this.ciudad = ciudad;
        this.codCiudad = codCiudad;
    }
    public Origen( String nAeropuerto, String ciudad, String codCiudad) {
      
        this.nAeropuerto = nAeropuerto;
        this.ciudad = ciudad;
        this.codCiudad = codCiudad;
    }
    public int getIdOrigen() {
        return idOrigen;
    }

    public void setIdOrigen(int idOrigen) {
        this.idOrigen = idOrigen;
    }

    public String getnAeropuerto() {
        return nAeropuerto;
    }

    public void setnAeropuerto(String nAeropuerto) {
        this.nAeropuerto = nAeropuerto;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCodCiudad() {
        return codCiudad;
    }

    public void setCodCiudad(String codCiudad) {
        this.codCiudad = codCiudad;
    }

    @Override
    public String toString() {
        return "Origen{" + "idOrigen=" + idOrigen + ", nAeropuerto=" + nAeropuerto + ", ciudad=" + ciudad + ", codCiudad=" + codCiudad + '}';
    }

}
