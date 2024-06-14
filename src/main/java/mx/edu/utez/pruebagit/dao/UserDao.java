package mx.edu.utez.pruebagit.dao;

import mx.edu.utez.pruebagit.model.User;
import mx.edu.utez.pruebagit.utils.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    public User getOne(String user_name, String pass) {
        User u = new User();
        // LOS SÍBOLOS DE ? SON PARA EVITAR LA INYECCIÓN DE CÓDIGO EN SQL
        String query = "select * from users where user_name = ? and pass = sha2(?,256) ";


        try {
        // Conectarnos a la bd
            Connection con = DatabaseConnectionManager.getConnection();
            // Me prepara la coonsulta para ser escuchada
            PreparedStatement ps = con.prepareStatement(query);
            // Voy a definir los parámetros del query
            ps.setString(1,user_name);
            ps.setString(2,pass);

            // Ejecutar la consulta
            ResultSet rs = ps.executeQuery();
            // Obtener la información del usuario
            if(rs.next()){
                // Significa que el usuario si existe en la base de datos
                u.setUser_name(rs.getString("user_name"));
                u.setPass(rs.getString("pass"));
                u.setEmail(rs.getString("email"));
                u.setCody(rs.getString("cody"));
            }

        } catch (SQLException e){
            e.printStackTrace();
        }

        return u;
    }
}
