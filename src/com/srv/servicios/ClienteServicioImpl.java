package com.srv.servicios;

import com.srv.db.Conexion;
import com.srv.dto.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

public class ClienteServicioImpl implements ClienteServicioI {

    private final DataSource datasource = Conexion.db();

    @Override
    public Cliente buscar(int id) {
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement pstm = null;
        List<Cliente> lista = new ArrayList<>();
        Cliente cliente = null;
        try {
            conn = datasource.getConnection();
            pstm = conn.prepareStatement("SELECT * FROM cliente where id_cliente=?;");
            pstm.setInt(1, id);
            rs = pstm.executeQuery(); // Ejecuto la sentencia
            // Recorro el resulset y añado a una lista
            while (rs.next()) {
                lista.add(new Cliente(rs.getInt("id_cliente"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getInt("edad"),
                        rs.getInt("telefono"),
                        rs.getString("direccion"),
                        rs.getString("ruc")
                ));
            }
            if (!lista.isEmpty()) {
                cliente = lista.get(0);
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

        return cliente;
    }

    @Override
    public List<Cliente> listar() {
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement pstm = null;
        List<Cliente> lista = new ArrayList<>();

        try {
            conn = datasource.getConnection();
            pstm = conn.prepareStatement("SELECT * FROM cliente");

            rs = pstm.executeQuery(); // Ejecuto la sentencia
            // Recorro el resulset y añado a una lista
            while (rs.next()) {
                lista.add(new Cliente(rs.getInt("id_cliente"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getInt("edad"),
                        rs.getInt("telefono"),
                        rs.getString("direccion"),
                        rs.getString("ruc")
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
    public void crear(Cliente cliente) {
        Connection conn = null;
        PreparedStatement pstm = null;
        try {
            conn = datasource.getConnection();
            pstm = conn.prepareStatement("INSERT INTO cliente(nombre, apellido, edad, telefono, direccion,ruc) VALUES (?,?,?,?,?,?);");
            pstm.setString(1, cliente.getNombre());
            pstm.setString(2, cliente.getApellido());
            pstm.setInt(3, cliente.getEdad());
            pstm.setInt(4, cliente.getTelefono());
            pstm.setString(5, cliente.getDireccion());
            pstm.setString(6, cliente.getRuc());

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
    public void actualizar(Cliente cliente) {
        Connection conn = null;
        PreparedStatement pstm = null;
        try {
            conn = datasource.getConnection();
            pstm = conn.prepareStatement("UPDATE cliente SET nombre=?, apellido=?, edad=?, telefono=?, direccion=?, ruc=? WHERE id_cliente=?;");
            pstm.setString(1, cliente.getNombre());
            pstm.setString(2, cliente.getApellido());
            pstm.setInt(3, cliente.getEdad());
            pstm.setInt(4, cliente.getTelefono());
            pstm.setString(5, cliente.getDireccion());
            pstm.setString(6, cliente.getRuc());
            pstm.setInt(7, cliente.getIdCliente());

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
    public boolean eliminar(int id) {
        Connection conn = null;
        PreparedStatement pstm = null;
        try {
            conn = datasource.getConnection();
            pstm = conn.prepareStatement("Delete from cliente WHERE id_cliente=?;");

            pstm.setInt(1, id);

            pstm.executeUpdate(); // Ejecuto la sentencia
            return true;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
            return false;
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

}
