package mx.edu.utez.pruebagit.model;

import java.io.Serializable;

public class User implements Serializable {
    /* Bean es una estructura de datos que modela objetos de la vida real, es útil
    en varios escenarios*/
    private String user_name;
    private String email;
    private String pass;
    private String cody;

    // Siempre debe tener los métodos constructores. getters y setters

    public User() {}

    public User(String user_name, String email, String pass, String cody) {
        this.user_name = user_name;
        this.email = email;
        this.pass = pass;
        this.cody = cody;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getCody() {
        return cody;
    }

    public void setCody(String cody) {
        this.cody = cody;
    }
}
