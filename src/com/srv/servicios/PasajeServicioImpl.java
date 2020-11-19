/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.srv.servicios;

import com.srv.db.Conexion;
import com.srv.dto.Pasaje;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

public class PasajeServicioImpl implements PasajeServicioI {

    private final DataSource datasource = Conexion.db();

    @Override
    public Pasaje buscar(int id) {
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement pstm = null;
        List<Pasaje> lista = new ArrayList<>();
        Pasaje pasaje = null;
        try {
            conn = datasource.getConnection();
            pstm = conn.prepareStatement("SELECT * FROM pasaje where id_pasaje=?;");
            pstm.setInt(1, id);
            rs = pstm.executeQuery(); // Ejecuto la sentencia
            // Recorro el resulset y añado a una lista
            while (rs.next()) {
                lista.add(new Pasaje(rs.getInt("id_pasaje"),
                        rs.getInt("id_cliente"),
                        rs.getInt("id_vuelo"),
                        rs.getString("asiento"),
                        rs.getString("clase"),
                        rs.getString("valor")
                ));
            }
            if (!lista.isEmpty()) {
                pasaje = lista.get(0);
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

        return pasaje;
    }

    @Override
    public List<Pasaje> listar() {
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement pstm = null;
        List<Pasaje> lista = new ArrayList<>();

        try {
            conn = datasource.getConnection();
            pstm = conn.prepareStatement("SELECT * FROM pasaje;");

            rs = pstm.executeQuery(); // Ejecuto la sentencia
            // Recorro el resulset y añado a una lista
            while (rs.next()) {
                lista.add(new Pasaje(rs.getInt("id_pasaje"),
                        rs.getInt("id_cliente"),
                        rs.getInt("id_vuelo"),
                        rs.getString("asiento"),
                        rs.getString("clase"),
                        rs.getString("valor")
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
    public void crear(Pasaje pasaje) {
        Connection conn = null;
        PreparedStatement pstm = null;
        try {
            conn = datasource.getConnection();
            pstm = conn.prepareStatement("INSERT INTO pasaje(id_cliente, id_vuelo, asiento, clase, valor) VALUES (?,?,?,?,?);");
            pstm.setInt(1, pasaje.getIdCliente());
            pstm.setInt(2, pasaje.getIdVuelo());
            pstm.setString(3, pasaje.getAsiento());
            pstm.setString(4, pasaje.getClase());
            pstm.setString(5, pasaje.getValor());

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
    public void actualizar(Pasaje pasaje) {
        Connection conn = null;
        PreparedStatement pstm = null;
        try {
            conn = datasource.getConnection();
            pstm = conn.prepareStatement("UPDATE pasaje SET id_cliente=?, id_vuelo=?, asiento=?, clase=?, valor=? WHERE id_pasaje=?;");
            pstm.setInt(1, pasaje.getIdCliente());
            pstm.setInt(2, pasaje.getIdVuelo());
            pstm.setString(3, pasaje.getAsiento());
            pstm.setString(4, pasaje.getClase());
            pstm.setString(5, pasaje.getValor());
            pstm.setInt(6, pasaje.getIdPasaje());

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
            pstm = conn.prepareStatement("Delete from pasaje WHERE id_pasaje=?;");

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
