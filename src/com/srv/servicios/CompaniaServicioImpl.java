/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.srv.servicios;

import com.srv.db.Conexion;
import com.srv.dto.Compania;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

public class CompaniaServicioImpl implements CompaniaServicioI {

    private final DataSource datasource = Conexion.db();

    @Override
    public Compania buscar(int id) {
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement pstm = null;
        List<Compania> lista = new ArrayList<>();
        Compania compania = null;
        try {
            conn = datasource.getConnection();
            pstm = conn.prepareStatement("SELECT * FROM compania where id_compania=?;");
            pstm.setInt(1, id);
            rs = pstm.executeQuery(); // Ejecuto la sentencia
            // Recorro el resulset y añado a una lista
            while (rs.next()) {
                lista.add(new Compania(rs.getInt("id_compania"),
                        rs.getString("nombre"),
                        rs.getString("direccion"),
                        rs.getInt("telefono"),
                        rs.getString("ruc")
                ));
            }
            if (!lista.isEmpty()) {
                compania = lista.get(0);
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

        return compania;
    }

    @Override
    public List<Compania> listar() {
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement pstm = null;
        List<Compania> lista = new ArrayList<>();

        try {
            conn = datasource.getConnection();
            pstm = conn.prepareStatement("SELECT * FROM compania;");

            rs = pstm.executeQuery(); // Ejecuto la sentencia
            // Recorro el resulset y añado a una lista
            while (rs.next()) {
                lista.add(new Compania(rs.getInt("id_compania"),
                        rs.getString("nombre"),
                        rs.getString("direccion"),
                        rs.getInt("telefono"),
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
    public void crear(Compania compania) {
        Connection conn = null;
        PreparedStatement pstm = null;
        try {
            conn = datasource.getConnection();
            pstm = conn.prepareStatement("INSERT INTO compania(nombre, direccion, telefono, ruc) VALUES (?,?,?,?);");
            pstm.setString(1, compania.getNombre());
            pstm.setString(2, compania.getDireccion());
            pstm.setInt(3, compania.getTelefono());
            pstm.setString(4, compania.getRuc());

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
    public void actualizar(Compania compania) {
        Connection conn = null;
        PreparedStatement pstm = null;
        try {
            conn = datasource.getConnection();
            pstm = conn.prepareStatement("UPDATE compania SET nombre=?, direccion=?, telefono=?, ruc=? WHERE id_compania=?;");
            pstm.setString(1, compania.getNombre());
            pstm.setString(2, compania.getDireccion());
            pstm.setInt(3, compania.getTelefono());
            pstm.setString(4, compania.getRuc());
            pstm.setInt(5, compania.getIdCompania());

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
            pstm = conn.prepareStatement("Delete from compania WHERE id_compania=?;");

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
