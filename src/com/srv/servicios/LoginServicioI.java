
package com.srv.servicios;


import com.srv.dto.Login;
import java.util.List;


public interface LoginServicioI {
    Login buscar(int id);
    List<Login> listar();
    void crear(Login login);
    void actualizar(Login login);
    void eliminar(int id);
    boolean iniciarSesion(Login login);
    
}
