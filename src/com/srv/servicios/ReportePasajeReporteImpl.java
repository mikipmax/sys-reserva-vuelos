package com.srv.servicios;

import com.srv.db.Conexion;
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
    public void generarReporte() {
        try {
            JasperReport reportePasaje = JasperCompileManager.compileReport("src/com/srv/reportes/reporte-pasaje.jrxml");
            JasperPrint jp = JasperFillManager.fillReport(reportePasaje, null, datasource.getConnection());
            JasperViewer.viewReport(jp, true);
            
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }
    
}
