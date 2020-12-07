package com.srv.main;

import com.formdev.flatlaf.FlatDarkLaf;

import com.srv.vistas.LoginVista;
import com.srv.vistas.MenuPrincipalVista;

import javax.swing.UIManager;

public class Principal {

    public static void main(String[] args) {

        try {
            // UIManager.setLookAndFeel(new FlatIntelliJLaf());
            UIManager.setLookAndFeel(new FlatDarkLaf());
          /* LoginVista login = new LoginVista();
            login.setVisible(true);
            login.setLocationRelativeTo(null);*/
            MenuPrincipalVista m=new MenuPrincipalVista();
            m.setVisible(true);
            m.setLocationRelativeTo(null);
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }

    }

}
