package com.srv.servicios;

import com.srv.db.Conexion;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

public class ReportePasajeReporteImpl implements ReportePasajeServicioI {

    private final DataSource datasource = Conexion.db();

    @Override
    public void generarReporte(Date fechaVuelo) {
        try {
            JasperReport reportePasaje = JasperCompileManager.compileReport("src/com/srv/reportes/reporte-pasaje.jrxml");

            Map parametro = new HashMap();
            parametro.put("fechaVuelo", fechaVuelo);
          
            JasperPrint jp = JasperFillManager.fillReport(reportePasaje, parametro, datasource.getConnection());
            JasperViewer.viewReport(jp, false);

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

    @Override
    public void generarReportePorRango(Date fechaInicial, Date fechaFinal) {
              try {
            JasperReport reportePasaje = JasperCompileManager.compileReport("src/com/srv/reportes/reporte-rangos.jrxml");

            Map parametro = new HashMap();
            parametro.put("fechaInicial", fechaInicial);
            parametro.put("fechaFinal", fechaFinal);
          
            JasperPrint jp = JasperFillManager.fillReport(reportePasaje, parametro, datasource.getConnection());
            JasperViewer.viewReport(jp, false);

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

}
