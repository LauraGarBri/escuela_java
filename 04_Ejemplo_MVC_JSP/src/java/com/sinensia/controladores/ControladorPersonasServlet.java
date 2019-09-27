/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sinensia.controladores;

import com.sinensia.modelo.Persona;
import com.sinensia.modelo.logica.ServicioPersona;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Formacion
 */
public class ControladorPersonasServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        //String edad = request.getParameter("edad");

        Persona p = ServicioPersona.getInstancia().getPersona(nombre);

        request.getSession().setAttribute("resultadoBusq", p);
        request.getRequestDispatcher("resultados_busq.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Persona p;
        String nombre = request.getParameter("nombre");
        String edad = request.getParameter("edad");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String valor = request.getParameter("metodo");
        if (valor == null)
            valor ="";
        

       // if (!valor.equals("modificar")) {
        if (  !valor.equalsIgnoreCase("modificar")) {
            try {
                p = ServicioPersona.getInstancia().addPersonas(nombre, edad, email, password);
              

                if (p == null) { //Si la persona es nula enviamos a otra pagina
                    request.getRequestDispatcher("error.jsp").forward(request, response);
                } else {
                    request.getRequestDispatcher("exito.jsp").forward(request, response);
                }
            } catch (NumberFormatException ex) {
                request.getSession().setAttribute("mensajeError", "Error numerico: " + ex.getMessage());
                request.getRequestDispatcher("error.jsp").forward(request, response);
            } catch (IllegalArgumentException ex) {
                request.getSession().setAttribute("mensajeError", "Error de campos: " + ex.getMessage());
                request.getRequestDispatcher("error.jsp").forward(request, response);
            } catch (Exception ex) {
                request.getSession().setAttribute("mensajeError", "Error generico: " + ex.getMessage());
                request.getRequestDispatcher("error.jsp").forward(request, response);
            }
            
            
        } else {
            try {
                String nombreAntiguo = request.getParameter("nombreAntiguo");
              
               
                p= ServicioPersona.getInstancia().cambiarDatos(nombre,nombreAntiguo,edad,email,password);
           
            if (p == null) { //Si la persona es nula enviamos a otra pagina
                    request.getRequestDispatcher("error.jsp").forward(request, response);
                } else {
                    request.getRequestDispatcher("exito.jsp").forward(request, response);
                }
            } catch (NumberFormatException ex) {
                request.getSession().setAttribute("mensajeError", "Error numerico: " + ex.getMessage());
                request.getRequestDispatcher("error.jsp").forward(request, response);
            } catch (IllegalArgumentException ex) {
                request.getSession().setAttribute("mensajeError", "Error de campos: " + ex.getMessage());
                request.getRequestDispatcher("error.jsp").forward(request, response);
            } catch (Exception ex) {
                request.getSession().setAttribute("mensajeError", "Error generico: " + ex.getMessage());
                request.getRequestDispatcher("error.jsp").forward(request, response);
            }

        }
    }

}
