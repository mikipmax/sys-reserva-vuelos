package com.srv.dto;

public class Destino {

    private int idDestino;
    private String nAeropuerto;
    private String ciudad;
    private String codCiudad;

    public Destino(int idDestino, String nAeropuerto, String ciudad, String codCiudad) {
        this.idDestino = idDestino;
        this.nAeropuerto = nAeropuerto;
        this.ciudad = ciudad;
        this.codCiudad = codCiudad;
    }
  public Destino( String nAeropuerto, String ciudad, String codCiudad) {
       
        this.nAeropuerto = nAeropuerto;
        this.ciudad = ciudad;
        this.codCiudad = codCiudad;
    }
    public int getIdDestino() {
        return idDestino;
    }

    public void setIdDestino(int idDestino) {
        this.idDestino = idDestino;
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
        return "Destino{" + "idDestino=" + idDestino + ", nAeropuerto=" + nAeropuerto + ", ciudad=" + ciudad + ", codCiudad=" + codCiudad + '}';
    }

}
