package com.sinensia.modelo.logica;

import com.sinensia.modelo.Persona;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Singleton porque sólo queremos un servicio por aplicación/servidor
 *
 * @author Laura Garcia
 */
public class ServicioPersona {

    // <editor-fold defaultstate="collapsed" desc="Codigo patrón Singleton">
    private static ServicioPersona instancia;
    private ArrayList<Persona> personas;

    //Constructor privado
    private ServicioPersona() {
        personas = new ArrayList<>();
    }

    public static ServicioPersona getInstancia() {
        if (instancia == null) {
            instancia = new ServicioPersona();
        }
        return instancia;
    }//</editor-fold>

    public Persona addPersonas(String nombre, String edad, String email, String password) throws
            NumberFormatException, IOException, IllegalArgumentException {

        int edadPersona = Integer.parseInt(edad);

        // Patrón para validar el email
        Pattern pattern = Pattern
                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

        Matcher mather = pattern.matcher(email);

        if (nombre.equals("")) {
            throw new IllegalArgumentException("El nombre es vacio");
        } else if (nombre.length() < 2) {
            throw new IllegalArgumentException("El nombre es demasiado corto");
        } else if (edad.equals("")) {
            throw new NumberFormatException("La edad esta vacia");
        } else if (email.equals("")) {
            throw new IllegalArgumentException("El email esta vacio");
        } else if (mather.find() == false) {
            throw new IllegalArgumentException("El email es incorrecto");
        } else if (password.equals("")) {
            throw new IllegalArgumentException("El password esta vacio");
        } else {
            if (edadPersona <= 12) {
                throw new IllegalArgumentException("La edad debe ser mayor de 12");
            } else {
                Persona persona = new Persona(nombre, edadPersona, email, password);
                personas.add(persona);
                return persona;
            }
        }
    }

    public Persona getPersona(String nombre) {
        for (Persona p : personas) {
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                return p;
            }
        }

        return null;
    }

    

    /*public boolean removePersona(String nombre) {
        Persona perElim = null;
        for (Persona p : personas) {
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                perElim = p;
            }
        }

        if (perElim == null) {
            return false;
        } else {
            personas.remove(perElim);
            return true;
        }

    }*/

    public Persona darDeBaja(String nombre) {
        //Declaramos variable 
        Persona actual=null;
        Iterator<Persona> iterador = personas.iterator();

        while (iterador.hasNext()) {
            actual = iterador.next();
            if (actual.igualNombre(nombre)) {
                iterador.remove();
            }
        }
        return actual;
    }

    public Persona cambiarDatos(String nombreNuevo,String nombreAntiguo, String edad,
             String email, String password) {
        //Declaro variable
        Persona actual = null;
        int edadNueva = Integer.parseInt(edad);

        Iterator<Persona> iterador = personas.iterator();

        while (iterador.hasNext()) {

            actual = iterador.next();
            if (actual.igualNombre(nombreAntiguo)) {
                actual.setNombre(nombreNuevo);
                actual.setEdad(edadNueva);
                actual.setEmail(email);
                actual.setPassword(password);

            }
        }
        return actual;
    }

}
