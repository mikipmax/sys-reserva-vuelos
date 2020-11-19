/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.srv.servicios;

import com.srv.db.Conexion;
import com.srv.dto.Vuelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

public class VueloServicioImpl implements VueloServicioI {

    private final DataSource datasource = Conexion.db();

    @Override
    public Vuelo buscar(int id) {
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement pstm = null;
        List<Vuelo> lista = new ArrayList<>();
        Vuelo vuelo = null;
        try {
            conn = datasource.getConnection();
            pstm = conn.prepareStatement("SELECT * FROM vuelo where id_vuelo=?;");
            pstm.setInt(1, id);
            rs = pstm.executeQuery(); // Ejecuto la sentencia
            // Recorro el resulset y añado a una lista
            while (rs.next()) {
                lista.add(new Vuelo(rs.getInt("id_vuelo"),
                        rs.getInt("id_compania"),
                        rs.getInt("id_itinerario"),
                        rs.getInt("capacidad"),
                        rs.getString("modelo_avion"),
                        rs.getString("numero_vuelo")
                ));
            }
            if (!lista.isEmpty()) {
                vuelo = lista.get(0);
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

        return vuelo;
    }

    @Override
    public List<Vuelo> listar() {
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement pstm = null;
        List<Vuelo> lista = new ArrayList<>();

        try {
            conn = datasource.getConnection();
            pstm = conn.prepareStatement("SELECT * FROM vuelo;");

            rs = pstm.executeQuery(); // Ejecuto la sentencia
            // Recorro el resulset y añado a una lista
            while (rs.next()) {
                lista.add(new Vuelo(rs.getInt("id_vuelo"),
                        rs.getInt("id_compania"),
                        rs.getInt("id_itinerario"),
                        rs.getInt("capacidad"),
                        rs.getString("modelo_avion"),
                        rs.getString("numero_vuelo")
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
    public void crear(Vuelo vuelo) {
        Connection conn = null;
        PreparedStatement pstm = null;
        try {
            conn = datasource.getConnection();
            pstm = conn.prepareStatement("INSERT INTO vuelo(id_compania, id_itinerario, capacidad, modelo_avion, numero_vuelo) VALUES (?,?,?,?,?);");
            pstm.setInt(1, vuelo.getIdCompania());
            pstm.setInt(2, vuelo.getIdItinerario());
            pstm.setInt(3, vuelo.getCapacidad());
            pstm.setString(4, vuelo.getModeloAvion());
            pstm.setString(5, vuelo.getNumeroVuelo());

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
    public void actualizar(Vuelo vuelo) {
        Connection conn = null;
        PreparedStatement pstm = null;
        try {
            conn = datasource.getConnection();
            pstm = conn.prepareStatement("UPDATE vuelo SET id_compania=?, id_itinerario=?, capacidad=?, modelo_avion=?, numero_vuelo=? WHERE id_vuelo=?;");
            pstm.setInt(1, vuelo.getIdCompania());
            pstm.setInt(2, vuelo.getIdItinerario());
            pstm.setInt(3, vuelo.getCapacidad());
            pstm.setString(4, vuelo.getModeloAvion());
            pstm.setString(5, vuelo.getNumeroVuelo());
            pstm.setInt(6, vuelo.getIdVuelo());

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
            pstm = conn.prepareStatement("Delete from vuelo WHERE id_vuelo=?;");

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
