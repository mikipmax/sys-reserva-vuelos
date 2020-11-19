package com.srv.dto;

public class Login {

    private int idLogin;
    private String usuario;
    private String password;

    public Login(int idLogin, String usuario, String password) {
        this.idLogin = idLogin;
        this.usuario = usuario;
        this.password = password;
    }

    public Login(String usuario, String password) {
        this.usuario = usuario;
        this.password = password;
    }



    public int getIdLogin() {
        return idLogin;
    }

    public void setIdLogin(int idLogin) {
        this.idLogin = idLogin;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Login{" + "idLogin=" + idLogin + ", usuario=" + usuario + ", password=" + password + '}';
    }

}
