package ltw04.service;

import java.util.List;

import ltw04.Models.User;

public interface UserService {
    List<User> getAll();
    User get(String username);
    User get(int id);
    User login(String username, String password);
    User findByUserName(String username);
    void register(User user);
    void update(User user);
}
