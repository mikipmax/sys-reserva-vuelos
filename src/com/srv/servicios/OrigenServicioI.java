
package com.srv.servicios;


import com.srv.dto.Origen;
import java.util.List;


public interface OrigenServicioI {
    Origen buscar(int id);
    List<Origen> listar();
    void crear(Origen origen);
    void actualizar(Origen origen);
    boolean eliminar(int id);
}
