package sinensia.model.persistence;

import java.sql.SQLException;
import java.util.List;
import sinensia.model.User;

/**Interfaz que sus funciones lanzan SQLException
 *
 * @author Formacion
 */
public interface IUserDAO {
    
    User create(User user) throws SQLException;
    List<User> getAll() throws SQLException;
    boolean remove (int id) throws SQLException;
    boolean remove (User user) throws SQLException;
}
