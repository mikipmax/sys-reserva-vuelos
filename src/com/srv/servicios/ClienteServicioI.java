package com.srv.servicios;

import com.srv.dto.Cliente;
import java.util.List;

public interface ClienteServicioI {

    Cliente buscar(int id);

    List<Cliente> listar();

    void crear(Cliente cliente);

    void actualizar(Cliente cliente);

    boolean eliminar(int id);
}
