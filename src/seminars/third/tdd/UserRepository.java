package seminars.third.tdd;

import java.util.ArrayList;
import java.util.List;

//Добавьте функцию в класс UserRepository, которая разлогинивает всех пользователей, кроме администраторов.
// Для этого, вам потребуется расширить класс User новым свойством, +
// указывающим, обладает ли пользователь админскими правами. +
// Протестируйте данную функцию.

public class UserRepository  {

    // Тут можно хранить аутентифицированных пользователей
    List<User> data = new ArrayList<>();

    public void addUser(User user) {
        if (user.isAuthenticate) {
            this.data.add(user);
        }
    }

    public boolean findByName(String username) {
        for (User user : data) {
            if (user.name.equals(username)) {
                return true;
            }
        }
        return false;
    }

    public void logoutAllUserExceptAdmin() {
        //разлогинивая будем удалять из их репозитория
        this.data.removeIf(user -> !user.isAdmin);
    }

}