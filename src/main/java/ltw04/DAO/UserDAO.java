package ltw04.DAO;

import java.util.List;

import ltw04.Models.User;

public interface UserDAO {
    User get(String username);
    User get(int id);
    List<User> getAll();
    User findByUserName(String username);
    void register(User user); // Add this method
    public void update(User user);
}
