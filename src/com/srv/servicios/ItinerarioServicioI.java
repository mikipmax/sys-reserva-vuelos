
package com.srv.servicios;


import com.srv.dto.Itinerario;
import java.util.List;


public interface ItinerarioServicioI {
    Itinerario buscar(int id);
    List<Itinerario> listar();
    void crear(Itinerario itinerario);
    void actualizar(Itinerario itinerario);
    boolean eliminar(int id);
}
