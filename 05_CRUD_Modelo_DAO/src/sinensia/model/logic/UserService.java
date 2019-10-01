package sinensia.model.logic;

import java.sql.SQLException;
import java.util.List;
import sinensia.model.User;
import sinensia.model.persistence.IUserDAO;
import sinensia.model.persistence.UserDAO_DerbyDB;

/**
 * @author Laura Garcia
 */
public class UserService {

    IUserDAO daoUsers;

    //Constructor
    public UserService(IUserDAO daoUsers) {
        this.daoUsers = daoUsers;
    }

    public User create(String email, String password, String name, int age) throws SQLException {
        User user = null;
        if (email != null && password != null && name != null) {
            if (email.length() > 3 && !password.equals("") && !name.equals("") && age > 0) {

                user = new User(email, password, name, age);
                user = daoUsers.create(user);

            }
        }

        return user;
    }

    public List<User> getAll() throws SQLException {
        return daoUsers.getAll();
    }
    
    public boolean remove(int id) throws SQLException {
        return daoUsers.remove(id);       
    }
       
    public User update(User user) throws SQLException {
        
        if (validate(user.getEmail(), user.getPassword(), user.getName(), 
                Integer.toString(user.getAge()))) {
            return daoUsers.update(user);
        } else {
            return null;
        }
    }
    
     public boolean validate(String email, String password, String name, String strEdad) {
        if (email != null && password != null && name != null && strEdad != null) {
            if (!strEdad.matches("[0-9]{1,3}")) {
                throw new IllegalArgumentException("La edad no es un número válido");
            } else {
                int edad = Integer.parseInt(strEdad);
                if (email.length() > 3
                        && !password.equals("")
                        && !name.equals("")
                        && edad > 0) {

                    return true;
                }
            }
        }
        return false;
    }
    
    
    
    
    
    
    
}
