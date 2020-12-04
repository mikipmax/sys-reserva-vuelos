package com.srv.servicios;

import java.time.LocalDate;
import java.util.Date;

public interface ReportePasajeServicioI {

    void generarReporte(Date fechaVuelo);

    void generarReportePorRango(Date fechaInicial, Date fechaFinal);
}
