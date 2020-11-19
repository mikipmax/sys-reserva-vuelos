
package com.srv.servicios;


import com.srv.dto.Compania;
import java.util.List;


public interface CompaniaServicioI {
    Compania buscar(int id);
    List<Compania> listar();
    void crear(Compania compania);
    void actualizar(Compania compania);
    boolean eliminar(int id);
}
