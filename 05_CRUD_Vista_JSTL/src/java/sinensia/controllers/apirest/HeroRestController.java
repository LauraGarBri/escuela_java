/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sinensia.controllers.apirest;

import com.google.gson.Gson;
import java.io.BufferedReader;
import sinensia.controllers.*;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sinensia.model.logic.UserService;

/**
 *
 * @author alumno
 */
@WebServlet(asyncSupported = true, urlPatterns = "/api/heroes")
public class HeroRestController extends HttpServlet {

    public class Hero implements Serializable {

        private int id;
        private String name;
        private String file;

        public Hero() {

        }

        public Hero(int id, String name, String file) {
            this.id = id;
            this.name = name;
            this.file = file;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getFile() {
            return file;
        }

        public void setFile(String file) {
            this.file = file;
        }

    }

    ArrayList<Hero> listaHeroes;

//    UserService userSrv;
    @Override
    public void init() throws ServletException {
        super.init(); //To change body of generated methods, choose Tools | Templates.

        listaHeroes = new ArrayList<>();
        listaHeroes.add(new Hero(1, "Spider Man", "../sp.jpg"));
        listaHeroes.add(new Hero(2, "Super man", "../spm.jpg"));
        listaHeroes.add(new Hero(3, "Batman", "../bt.jpg"));
//        IUserDAO usersDAO = new UserDAO_DerbyDB();
//        this.userSrv = new UserService(usersDAO);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json;charset=UTF-8");
        setAccessControlHeaders(resp);
        try {

            // Serializamos el List en un JSON
            Gson gson = new Gson();
            String textJson = gson.toJson(listaHeroes);
            resp.getWriter().print(textJson);

        } catch (Exception ex) {
            Logger.getLogger(HeroRestController.class.getName()).log(Level.SEVERE, null, ex);
            resp.getWriter().print("{\"error\": \""
                    + ex.getMessage() + "\"}");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        //Recicir el JSON como parámetro de FORMulario
        //String jsonUser = req.getParameter("json");
        BufferedReader bufRead = req.getReader();
        String jsonUser;
        jsonUser = bufRead.readLine();
        /*String li
         while (jsonUser != null) {
             jsonUser += bu
         }*/
        Logger.getLogger(HeroRestController.class.getName()).log(Level.SEVERE, null, jsonUser);

        Hero heroObject = new Gson().fromJson(jsonUser, Hero.class);
        try {
            listaHeroes.add(heroObject);
            resp.setContentType("application/json;charset=UTF-8");
            setAccessControlHeaders(resp);

            Gson gson = new Gson();
            String textJson = gson.toJson(heroObject);
            resp.getWriter().print(textJson);
        } catch (Exception ex) {
            Logger.getLogger(HeroRestController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void setAccessControlHeaders(HttpServletResponse resp) {
        resp.setHeader("Access-Control-Allow-Origin", "http://localhost:4200");
        resp.setHeader("Access-Control-Allow-Methods", "OPTIONS,HEAD,GET,PUT,DELETE,POST");
        resp.setHeader("Access-Control-Allow-Headers", "X-PINGOTHER,Origin,X-Requested-With,Content-Type,Accept");
        resp.addHeader("Access-Control-Max-Age", "1728000"); //20 dias
    }

    @Override
    protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        setAccessControlHeaders(resp);
        resp.setStatus(HttpServletResponse.SC_OK); //Devolvemos cod 200
    }

//    @Override
//    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        try {
//            String jsonUser = req.getReader().readLine();
//            Hero heroObject = new Gson().fromJson(jsonUser, Hero.class);
//            userSrv.remove(userObject.getId());
//            resp.getWriter().print("OK");
//        } catch (SQLException ex) {
//            Logger.getLogger(HeroRestController.class.getName()).log(Level.SEVERE, null, ex);
//            
//            resp.getWriter().print("ERROR: " + ex.getMessage());
//        }
//    }
//    @Override
//    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String jsonUser = req.getReader().readLine();
//        User userObject = new Gson().fromJson(jsonUser, User.class);
//        try { // Debe venir ya con el id
//            userObject = userSrv.update(userObject);
//        } catch (SQLException ex) {
//            Logger.getLogger(HeroRestController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        resp.setContentType("application/json;charset=UTF-8");
//        resp.getWriter().print(new Gson().toJson(userObject));
//    }
}
