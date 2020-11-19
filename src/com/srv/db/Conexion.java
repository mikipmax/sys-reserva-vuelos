package com.srv.db;

import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

public class Conexion { 

    public static DataSource db() {

        BasicDataSource ds = new BasicDataSource();

        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/sys-reserva-vuelos");
        ds.setUsername("root");

        return ds;
    }
}
