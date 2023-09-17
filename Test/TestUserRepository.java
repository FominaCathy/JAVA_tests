
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import seminars.third.tdd.User;
import seminars.third.tdd.UserRepository;


import static org.junit.jupiter.api.Assertions.*;


public class TestUserRepository {

    //    аутентификации по логину и паролю
    @Test
    void authenticateUser() {
        User user = new User("user", "1111", true);
        assertTrue(user.authenticate("user", "1111"));
    }

    @ParameterizedTest
    @CsvSource (value  = {"user, 0000", "user2, 1111", "user2, 0000"})
    void notAuthenticateUser(String name, String password) {
        User user = new User("user", "1111", true);
        assertFalse(user.authenticate(name, password));
    }


    //добавляет пользователя в систему, если он прошел аутентификацию
    @Test
    void addUserInRepo() {
        User user = new User("user", "1111", true);
        user.authenticate("user", "1111");
        UserRepository data = new UserRepository();
        data.addUser(user);
        assertTrue(data.findByName("user"));
    }

    //    НЕ добавляет пользователя в систему, если он НЕ прошел аутентификацию
    @Test
    void notAddUserInRepo() {
        User user = new User("user", "1111", true);
        UserRepository data = new UserRepository();
        data.addUser(user);
        assertFalse(data.findByName("user"));
    }
    //Протестируйте функцию в классе UserRepository, которая разлогинивает всех пользователей, кроме администраторов.

    @Test
    void logoutAllExceptAdmin(){
        User user = new User("user", "1111", false);
        User admin = new User("admin", "0000", true);
        UserRepository data = new UserRepository();
        user.authenticate("user", "1111");
        admin.authenticate("admin", "0000");
        data.addUser(user);
        data.addUser(admin);
        data.logoutAllUserExceptAdmin();
        assertTrue(data.findByName("admin") && !data.findByName("user"));



    }



}
