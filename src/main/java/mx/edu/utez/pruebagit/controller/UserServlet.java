package mx.edu.utez.pruebagit.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import mx.edu.utez.pruebagit.dao.UserDao;
import mx.edu.utez.pruebagit.model.User;

import java.io.IOException;

@WebServlet(name="UserServlet", value = "/login")
public class UserServlet extends HttpServlet {

    // Se tiene que poner el extends HttpServlet, Se tiene q poner la etiqueta de arriba y
    // Se tienen que sobreescribir los métodos


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // super.doGet(req, resp); Se quita
        // Aquí se se va a conectar a la base de datos...

        String user_name = req.getParameter("user_name");
        String pass = req.getParameter("pass");
        UserDao dao = new UserDao();
        User u = dao.getOne(user_name,pass);

        String ruta = "Index.jsp";

        if(u.getUser_name() != null) {
            // Significa que el usuario existe en la bd
            ruta = "Bienvenido.jsp"; // aun no la creamos pero para redireccionar

        }else{
            // Significa que el usuario no existe
            HttpSession sesion = req.getSession();
            sesion.setAttribute("mensaje","El usuario no existe en la BD");
        }
    resp.sendRedirect(ruta);
    }

    @Override
    public void init() throws ServletException {
        // super.init(); Este se quita
    }

    @Override
    public void destroy() {
        // super.destroy(); Este también se quita
    }
}
