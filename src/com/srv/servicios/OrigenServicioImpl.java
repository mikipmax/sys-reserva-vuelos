/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.srv.servicios;

import com.srv.db.Conexion;
import com.srv.dto.Origen;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

public class OrigenServicioImpl implements OrigenServicioI {

    private final DataSource datasource = Conexion.db();

    @Override
    public Origen buscar(int id) {
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement pstm = null;
        List<Origen> lista = new ArrayList<>();
        Origen origen = null;
        try {
            conn = datasource.getConnection();
            pstm = conn.prepareStatement("SELECT * FROM origen where id_origen=?;");
            pstm.setInt(1, id);
            rs = pstm.executeQuery(); // Ejecuto la sentencia
            // Recorro el resulset y añado a una lista
            while (rs.next()) {
                lista.add(new Origen(rs.getInt("id_origen"),
                        rs.getString("n_aeropuerto"),
                        rs.getString("ciudad"),
                        rs.getString("cod_ciudad")
                ));
            }
            if (!lista.isEmpty()) {
                origen = lista.get(0);
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

        return origen;
    }

    @Override
    public List<Origen> listar() {
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement pstm = null;
        List<Origen> lista = new ArrayList<>();
        Origen origen = null;
        try {
            conn = datasource.getConnection();
            pstm = conn.prepareStatement("SELECT * FROM origen;");

            rs = pstm.executeQuery(); // Ejecuto la sentencia
            // Recorro el resulset y añado a una lista
            while (rs.next()) {
                lista.add(new Origen(rs.getInt("id_origen"),
                        rs.getString("n_aeropuerto"),
                        rs.getString("ciudad"),
                        rs.getString("cod_ciudad")
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
    public void crear(Origen origen) {
        Connection conn = null;
        PreparedStatement pstm = null;
        try {
            conn = datasource.getConnection();
            pstm = conn.prepareStatement("INSERT INTO origen(n_aeropuerto, ciudad, cod_ciudad) VALUES (?,?,?);");
            pstm.setString(1, origen.getnAeropuerto());
            pstm.setString(2, origen.getCiudad());
            pstm.setString(3, origen.getCodCiudad());

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
    public void actualizar(Origen origen) {
        Connection conn = null;
        PreparedStatement pstm = null;
        try {
            conn = datasource.getConnection();
            pstm = conn.prepareStatement("UPDATE origen SET n_aeropuerto=?, ciudad=?, cod_ciudad=? WHERE id_origen=?;");
            pstm.setString(1, origen.getnAeropuerto());
            pstm.setString(2, origen.getCiudad());
            pstm.setString(3, origen.getCodCiudad());
            pstm.setInt(4, origen.getIdOrigen());

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
            pstm = conn.prepareStatement("Delete from origen WHERE id_origen=?;");

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
