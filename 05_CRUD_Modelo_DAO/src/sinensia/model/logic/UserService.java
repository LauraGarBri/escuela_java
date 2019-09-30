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
}
