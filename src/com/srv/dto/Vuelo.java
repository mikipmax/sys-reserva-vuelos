
package com.srv.dto;


public class Vuelo {
    private int idVuelo;
    private int idCompania;
    private int idItinerario;
    private int capacidad;
    private String modeloAvion;
    private String numeroVuelo;

    public Vuelo(int idVuelo, int idCompania, int idItinerario, int capacidad, String modeloAvion, String numeroVuelo) {
        this.idVuelo = idVuelo;
        this.idCompania = idCompania;
        this.idItinerario = idItinerario;
        this.capacidad = capacidad;
        this.modeloAvion = modeloAvion;
        this.numeroVuelo = numeroVuelo;
    }
    public Vuelo( int idCompania, int idItinerario, int capacidad, String modeloAvion, String numeroVuelo) {
       
        this.idCompania = idCompania;
        this.idItinerario = idItinerario;
        this.capacidad = capacidad;
        this.modeloAvion = modeloAvion;
        this.numeroVuelo = numeroVuelo;
    }
    public int getIdVuelo() {
        return idVuelo;
    }

    public void setIdVuelo(int idVuelo) {
        this.idVuelo = idVuelo;
    }

    public int getIdCompania() {
        return idCompania;
    }

    public void setIdCompania(int idCompania) {
        this.idCompania = idCompania;
    }

    public int getIdItinerario() {
        return idItinerario;
    }

    public void setIdItinerario(int idItinerario) {
        this.idItinerario = idItinerario;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getModeloAvion() {
        return modeloAvion;
    }

    public void setModeloAvion(String modeloAvion) {
        this.modeloAvion = modeloAvion;
    }

    public String getNumeroVuelo() {
        return numeroVuelo;
    }

    public void setNumeroVuelo(String numeroVuelo) {
        this.numeroVuelo = numeroVuelo;
    }

    @Override
    public String toString() {
        return "Vuelo{" + "idVuelo=" + idVuelo + ", idCompania=" + idCompania + ", idItinerario=" + idItinerario + ", capacidad=" + capacidad + ", modeloAvion=" + modeloAvion + ", numeroVuelo=" + numeroVuelo + '}';
    }
    
}
