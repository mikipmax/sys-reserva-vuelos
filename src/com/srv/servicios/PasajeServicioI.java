
package com.srv.servicios;


import com.srv.dto.Pasaje;
import java.util.List;


public interface PasajeServicioI {
    Pasaje buscar(int id);
    List<Pasaje> listar();
    void crear(Pasaje pasaje);
    void actualizar(Pasaje pasaje);
    boolean eliminar(int id);
}
