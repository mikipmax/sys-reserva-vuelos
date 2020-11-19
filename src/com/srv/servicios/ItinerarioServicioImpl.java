/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.srv.servicios;

import com.srv.db.Conexion;
import com.srv.dto.Itinerario;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import java.util.List;
import javax.sql.DataSource;

public class ItinerarioServicioImpl implements ItinerarioServicioI {

    private final DataSource datasource = Conexion.db();

    @Override
    public Itinerario buscar(int id) {
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement pstm = null;
        List<Itinerario> lista = new ArrayList<>();
        Itinerario itinerario = null;
        try {
            conn = datasource.getConnection();
            pstm = conn.prepareStatement("SELECT * FROM itinerario where id_itinerario=?;");
            pstm.setInt(1, id);
            rs = pstm.executeQuery(); // Ejecuto la sentencia
            // Recorro el resulset y añado a una lista
            while (rs.next()) {
                lista.add(new Itinerario(rs.getInt("id_itinerario"),
                        rs.getInt("id_origen"),
                        rs.getInt("id_destino"),
                        rs.getObject("hora", LocalTime.class),
                        rs.getDate("fecha")
                ));
            }
            if (!lista.isEmpty()) {
                itinerario = lista.get(0);
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

        return itinerario;
    }

    @Override
    public List<Itinerario> listar() {
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement pstm = null;
        List<Itinerario> lista = new ArrayList<>();

        try {
            conn = datasource.getConnection();
            pstm = conn.prepareStatement("SELECT * FROM itinerario;");

            rs = pstm.executeQuery(); // Ejecuto la sentencia
            // Recorro el resulset y añado a una lista
            while (rs.next()) {
                lista.add(new Itinerario(rs.getInt("id_itinerario"),
                        rs.getInt("id_origen"),
                        rs.getInt("id_destino"),
                        rs.getObject("hora", LocalTime.class),
                        rs.getDate("fecha")
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
    public void crear(Itinerario itinerario) {
        Connection conn = null;
        PreparedStatement pstm = null;
        try {
            conn = datasource.getConnection();
            pstm = conn.prepareStatement("INSERT INTO itinerario(id_origen, id_destino, hora, fecha) VALUES (?,?,?,?);");
            pstm.setInt(1, itinerario.getIdOrigen());
            pstm.setInt(2, itinerario.getIdDestino());
            pstm.setObject(3, itinerario.getHora());
            pstm.setDate(4, new java.sql.Date(itinerario.getFecha().getTime()));

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
    public void actualizar(Itinerario itinerario) {
        Connection conn = null;
        PreparedStatement pstm = null;
        try {
            conn = datasource.getConnection();
            pstm = conn.prepareStatement("UPDATE itinerario SET id_origen=?, id_destino=?, hora=?, fecha=? WHERE id_itinerario=?;");
            pstm.setInt(1, itinerario.getIdOrigen());
            pstm.setInt(2, itinerario.getIdDestino());
            pstm.setObject(3, itinerario.getHora());
              pstm.setDate(4, new java.sql.Date(itinerario.getFecha().getTime()));
            pstm.setInt(5, itinerario.getIdItinerario());

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
            pstm = conn.prepareStatement("Delete from itinerario WHERE id_itinerario=?;");

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
