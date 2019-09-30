/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sinensia.tests;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import sinensia.model.User;
import sinensia.model.logic.UserService;
import sinensia.model.persistence.IUserDAO;
import sinensia.model.persistence.UserDAO_DerbyDB;

/**
 *
 * @author Formacion
 */
public class TryModelDAO {

    UserService userSrv;

    public TryModelDAO() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        IUserDAO daoUsers = new UserDAO_DerbyDB();
        userSrv = new UserService(daoUsers);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void createAndListUsersFail() {
        
        try {
            List<User> allUsers;
            allUsers = userSrv.getAll();
            int totalUsersBefore = allUsers.size();
            User u1 = userSrv.create(null, null, null, 0);
            User u2 = userSrv.create("", "p1234", "J J", 20);
            User u3 = userSrv.create("er@dd", null, "J J", 20);
            User u4 = userSrv.create("er@dd", "p1234", "", 20);
            User u5 = userSrv.create("er@dd", "p1234", "J J", 0);
            assertNull(u1);
            assertNull(u2);
            assertNull(u3);
            assertNull(u4);
            assertNull(u5);
            userSrv.getAll();
            assertEquals(totalUsersBefore, allUsers.size());
        } catch (SQLException ex) {
            Logger.getLogger(TryModelDAO.class.getName()).log(Level.SEVERE, null, ex);
            fail("Error en SQL: " + ex.getMessage());
        }

    }

    @Test
    public void createAndListUsersOK() {
      
        try {  
            List<User> allUsers;
            allUsers = userSrv.getAll();
            int totalUsersBefore = allUsers.size();
            User u1 = userSrv.create("aaa@mail.com", "a1234", "Aaaaa", 20);
            User u2 = userSrv.create("bbb@mail.com", "b1234", "B. Bbbb", 30);
            User u3 = userSrv.create("ccc@mail.com", "c1234", "Cccc C.", 40);
            User u4 = userSrv.create("ddd@mail.com", "d1234", "D. D. Dd", 50);
            assertNotNull(u1);
            assertEquals(u2.getName(), "B. Bbbb");
            assertTrue(u3.getEmail().equals("ccc@mail.com"));
            assertFalse(u4.getAge() != 50);

            // Repetido que debe fallar
            User u5 = userSrv.create("ddd@mail.com", "d1234", "D. D. Dd", 50);
            assertNull(u5);

            allUsers = userSrv.getAll();
            assertEquals(totalUsersBefore + 4, allUsers.size());
        } catch (SQLException ex) {
            Logger.getLogger(TryModelDAO.class.getName()).log(Level.SEVERE, null, ex);
            fail("Error en SQL: " + ex.getMessage());
            
        }

    }
}
