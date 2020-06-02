package Login.Dao;

import Login.model.Login;
import Login.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserDao {
    private static List<User> listUser;

    static {
        listUser = new ArrayList<>();
        User user1 = new User();
        user1.setAccount("khanhquoc");
        user1.setPassword("123");
        user1.setAge(18);
        user1.setName("Do Quoc Khanh");
        listUser.add(user1);
    }

    public static User checkLogin(Login login){
        for (User u: listUser) {
            if(u.getAccount().equals(login.getAccount())
                    && u.getPassword().equals(login.getPassword())){
                return u;
            }
        }
        return null;
    }
}
