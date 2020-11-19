
package com.srv.servicios;


import com.srv.dto.Destino;
import java.util.List;


public interface DestinoServicioI {
    Destino buscar(int id);
    List<Destino> listar();
    void crear(Destino destino);
    void actualizar(Destino destino);
    boolean eliminar(int id);
}
