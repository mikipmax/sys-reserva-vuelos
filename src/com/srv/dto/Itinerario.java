package com.srv.dto;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

public class Itinerario {

    private int idItinerario;
    private int idOrigen;
    private int idDestino;
    private LocalTime hora;
    private Date fecha;

    public Itinerario(int idItinerario, int idOrigen, int idDestino, LocalTime hora, Date fecha) {
        this.idItinerario = idItinerario;
        this.idOrigen = idOrigen;
        this.idDestino = idDestino;
        this.hora = hora;
        this.fecha = fecha;
    }

    public Itinerario(int idOrigen, int idDestino, LocalTime hora, Date fecha) {

        this.idOrigen = idOrigen;
        this.idDestino = idDestino;
        this.hora = hora;
        this.fecha = fecha;
    }

    public int getIdItinerario() {
        return idItinerario;
    }

    public void setIdItinerario(int idItinerario) {
        this.idItinerario = idItinerario;
    }

    public int getIdOrigen() {
        return idOrigen;
    }

    public void setIdOrigen(int idOrigen) {
        this.idOrigen = idOrigen;
    }

    public int getIdDestino() {
        return idDestino;
    }

    public void setIdDestino(int idDestino) {
        this.idDestino = idDestino;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Itinerario{" + "idItinerario=" + idItinerario + ", idOrigen=" + idOrigen + ", idDestino=" + idDestino + ", hora=" + hora + ", fecha=" + fecha + '}';
    }

}
