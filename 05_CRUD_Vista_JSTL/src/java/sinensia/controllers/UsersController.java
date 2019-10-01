package sinensia.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sinensia.model.User;
import sinensia.model.logic.UserService;
import sinensia.model.persistence.IUserDAO;
import sinensia.model.persistence.UserDAO_DerbyDB;

/**
 * @author Laura Garcia
 */
@WebServlet(asyncSupported = true, urlPatterns = "/users.do")
public class UsersController extends HttpServlet {

    UserService userSrv;

    @Override
    public void init() throws ServletException {
        super.init(); //To change body of generated methods, choose Tools | Templates.

        IUserDAO userDAO = new UserDAO_DerbyDB();
        this.userSrv = new UserService(userDAO);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            String email = req.getParameter("email");
            String password = req.getParameter("password");
            String name = req.getParameter("name");
            int age = Integer.parseInt(req.getParameter("age"));

            userSrv.create(email, password, name, age);
        } catch (SQLException ex) {
            Logger.getLogger(UsersController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            List<User> listUser = userSrv.getAll(); //Obtenemos los datos en este objeto
            req.setAttribute("usersList", listUser); //Añadiendo informacion a la peticion (clave y valor)
            req.getRequestDispatcher("listUsers.jsp").forward(req, resp); //Redirigimos a la vista
        }catch(Exception ex){
             Logger.getLogger(UsersController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
