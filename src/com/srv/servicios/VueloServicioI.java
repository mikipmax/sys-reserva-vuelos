
package com.srv.servicios;


import com.srv.dto.Vuelo;
import java.util.List;


public interface VueloServicioI {
    Vuelo buscar(int id);
    List<Vuelo> listar();
    void crear(Vuelo vuelo);
    void actualizar(Vuelo vuelo);
    boolean eliminar(int id);
}
