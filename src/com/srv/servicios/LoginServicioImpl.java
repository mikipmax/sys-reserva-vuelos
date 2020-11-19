package com.srv.servicios;

import com.srv.db.Conexion;
import com.srv.dto.Login;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;
import javax.sql.DataSource;

public class LoginServicioImpl implements LoginServicioI {

   private final DataSource datasource = Conexion.db();

    @Override
    public Login buscar(int id) {
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement pstm = null;
        List<Login> lista = new ArrayList<>();
        Login login = null;
        try {
            conn = datasource.getConnection();
            pstm = conn.prepareStatement("SELECT * FROM login where id_login=?;");
            pstm.setInt(1, id);
            rs = pstm.executeQuery(); // Ejecuto la sentencia
            // Recorro el resulset y añado a una lista
            while (rs.next()) {
                lista.add(new Login(rs.getInt("id_login"), rs.getString("usuario"), rs.getString("password")
                ));
            }
            if (!lista.isEmpty()) {
                login = lista.get(0);
            }
        } catch (SQLException e) {

            e.printStackTrace(System.out);
        } finally {
            // Cierro los objetos: resulset, prepareStatement y la conexión
            try {
                rs.close();
                pstm.close();
                conn.close();

            } catch (SQLException e) {
                e.printStackTrace(System.out);
            }

        }

        return login;
    }

    @Override
    public List<Login> listar() {
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement pstm = null;
        List<Login> lista = new ArrayList<>();
        try {
            conn = datasource.getConnection();
            pstm = conn.prepareStatement("SELECT * FROM login;");
            rs = pstm.executeQuery(); // Ejecuto la sentencia
            // Recorro el resulset y añado a una lista
            while (rs.next()) {
                lista.add(new Login(rs.getInt("id_login"), rs.getString("usuario"), rs.getString("password")
                ));
            }

        } catch (SQLException e) {

            e.printStackTrace(System.out);
        } finally {
            // Cierro los objetos: resulset, prepareStatement y la conexión
            try {
                rs.close();
                pstm.close();
                conn.close();

            } catch (SQLException e) {
                e.printStackTrace(System.out);
            }

        }

        return lista;
    }

    @Override
    public void crear(Login login) {
        Connection conn = null;
        PreparedStatement pstm = null;
        try {
            conn = datasource.getConnection();
            pstm = conn.prepareStatement("INSERT INTO login(usuario, password) VALUES (?,?);");
            pstm.setString(1, login.getUsuario());
            pstm.setString(2, login.getPassword());

            pstm.executeUpdate(); // Ejecuto la sentencia
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            // Cierro los objetos: prepareStatement y la conexión
            try {

                pstm.close();
                conn.close();

            } catch (SQLException e) {
                e.printStackTrace(System.out);
            }
        }
    }

    @Override
    public void actualizar(Login login) {
        Connection conn = null;
        PreparedStatement pstm = null;
        try {
            conn = datasource.getConnection();
            pstm = conn.prepareStatement("UPDATE login SET usuario=?, password=? WHERE id_login=?;");

            pstm.setString(1, login.getUsuario());
            pstm.setString(2, login.getPassword());
            pstm.setInt(3, login.getIdLogin());
            pstm.executeUpdate(); // Ejecuto la sentencia
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            // Cierro los objetos: prepareStatement y la conexión
            try {

                pstm.close();
                conn.close();

            } catch (SQLException e) {
                e.printStackTrace(System.out);
            }
        }
    }

    @Override
    public void eliminar(int id) {
        Connection conn = null;
        PreparedStatement pstm = null;
        try {
            conn = datasource.getConnection();
            pstm = conn.prepareStatement("Delete from login WHERE id_login=?;");

            pstm.setInt(1, id);

            pstm.executeUpdate(); // Ejecuto la sentencia
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            // Cierro los objetos: prepareStatement y la conexión
            try {

                pstm.close();
                conn.close();

            } catch (SQLException e) {
                e.printStackTrace(System.out);
            }
        }
    }

    @Override
    public boolean iniciarSesion(Login login) {
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement pstm = null;

        boolean success = false;
        try {
            conn = datasource.getConnection();
            pstm = conn.prepareStatement("SELECT * FROM login where usuario=? and password=?");

            pstm.setString(1, login.getUsuario());
            pstm.setString(2, login.getPassword());
            rs = pstm.executeQuery(); // Ejecuto la sentencia
            // Recorro el resulset 
            while (rs.next()) {
                success = true;
            }

        } catch (SQLException e) {

            e.printStackTrace(System.out);
        } finally {
            // Cierro los objetos: resulset, prepareStatement y la conexión
            try {
                rs.close();
                pstm.close();
                conn.close();

            } catch (SQLException e) {
                e.printStackTrace(System.out);
            }

        }
        return success;
    }

}
