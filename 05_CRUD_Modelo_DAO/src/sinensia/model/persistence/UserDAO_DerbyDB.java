package sinensia.model.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import sinensia.model.User;

/**
 * @author Laura Garcia
 */
public class UserDAO_DerbyDB implements IUserDAO {

    private static final String USER_DB = "root";
    private static final String PASSWD_DB = "1234";
    private static final String CONEX_DB = "jdbc:derby://localhost:1527/db_users";

    public UserDAO_DerbyDB() {
        try {
            //Cargamos el driver de Derby DB. Esta basado en JDBC,
            //Una implementacion de ODBC para Java
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            DriverManager.registerDriver(new org.apache.derby.jdbc.EmbeddedDriver());
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UserDAO_DerbyDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public User create(User user) throws SQLException {
        Connection con = DriverManager.getConnection(CONEX_DB, USER_DB, PASSWD_DB);
        /*String sqlQuery = "INSERT INTO users (email, password, name, age) VALUES ("
                    + " '" + user.getEmail()
                    + "', '" + user.getPassword()
                    + "', '" + user.getName()
                    + "', " + user.getAge() + ")";
            Statement stmt = con.createStatement();
            stmt.executeUpdate(sqlQuery);*/

        //Los interrogantes son los parametros de la sentencia sql que vamos a sustituir
        //Evitamos Sql Injection
        String sqlQuery = "INSERT INTO users (email, password, name, age) VALUES (?,?,?,?)";
        PreparedStatement prepStmt = con.prepareCall(sqlQuery);

        prepStmt.setString(1, user.getEmail());
        prepStmt.setString(2, user.getPassword());
        prepStmt.setString(3, user.getName());
        prepStmt.setInt(4, user.getAge());
        prepStmt.executeUpdate();

        //Buscamos el id a traves del email
        String sqlQuery2 = "SELECT id FROM users WHERE email='" + user.getEmail() + "'";

        Statement stmt = con.createStatement();
        ResultSet res = stmt.executeQuery(sqlQuery2);

        if (res.next()) {
            int id = res.getInt("id");
            user.setId(id);
        }

        con.close();
        return user;
    }

    @Override
    public List<User> getAll() throws SQLException {
        try (Connection con = DriverManager.getConnection(CONEX_DB, USER_DB, PASSWD_DB)) {
            ArrayList<User> usersList = new ArrayList<>();
            String sqlQuery = "SELECT id, email, password, name, age FROM users";
            Statement stmt = con.createStatement();
            ResultSet res = stmt.executeQuery(sqlQuery);

            while (res.next()) {
                int id = res.getInt("id");
                String email = res.getString("email");
                String password = res.getString("password");
                String name = res.getString("name");
                int age = res.getInt("age");

                User newUser = new User(email, password, name, age);
                newUser.setId(id);
                usersList.add(newUser);
            }
            return usersList;
        }
    }

    @Override
    public boolean remove(int id) throws SQLException {

        boolean valor = false;

        try (Connection con = DriverManager.getConnection(CONEX_DB, USER_DB, PASSWD_DB)) {
            String sqlQuery = "DELETE FROM users WHERE id=?";
            PreparedStatement prepStmt = con.prepareStatement(sqlQuery);
            prepStmt.setInt(1, id);
            int result = prepStmt.executeUpdate();
            if (result == 1) {
                System.out.println("El usuario ha sido eliminado");
                return valor;
            }

        }
        return valor;

    }

    @Override
    public boolean remove(User user) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /*@Override
    public User update(User user) throws SQLException {
        try (Connection con = DriverManager.getConnection(CONEX_DB, USER_DB, PASSWD_DB)) {
            Statement sentencia = con.createStatement();
            

            String sql = "UPDATE users SET email = '" + user.setEmail(email) + "','" 
                    + user.setPassword(password) + "','" + user.setName(name) + "'," 
                    + user.setAge(age) + " WHERE id ='" + user.getId() + "'  ";
            
            sentencia.executeQuery(sql);

        }

        return user;

    }*/
    
     
   
    
    @Override
    public User update(User user)throws SQLException{
        
        try (Connection con = DriverManager.getConnection(CONEX_DB, USER_DB, PASSWD_DB)) {
             PreparedStatement stmt = con.prepareStatement("UPDATE users SET email = ?, "
                     + "password = ?, name = ?,age = ? WHERE id = ?"); 
                stmt.setString(1, user.getEmail());
                stmt.setString(2, user.getPassword());
                stmt.setString(3, user.getName());
                stmt.setInt(4, user.getAge());
                stmt.setInt(5, user.getId());

                stmt.executeUpdate();
            }
        
        return user;
    }

    
}
