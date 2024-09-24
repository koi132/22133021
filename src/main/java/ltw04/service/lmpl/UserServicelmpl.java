package ltw04.service.lmpl;

import ltw04.Models.User;
import ltw04.service.UserService;

import java.util.List;

import ltw04.DAO.UserDAO;
import ltw04.DAO.lmpl.UserDAOlmpl;

public class UserServicelmpl implements UserService {
    private UserDAO userDAO = new UserDAOlmpl();

    @Override
    public User login(String username, String password) {
    	UserDAO userDao = new UserDAOlmpl();
        User user = userDao.findByUserName(username);
        if (user != null && user.getPassWord().equals(password)) {
            return user;
        }
        return null;
    }

    @Override
    public User findByUserName(String username) {
        return userDAO.findByUserName(username);
    }

    @Override
    public void register(User user) {
        userDAO.register(user); // You need to implement this method in DAO
    }
    
    @Override
    public void update(User user) {
        userDAO.update(user); // Giả sử bạn đã triển khai phương thức update trong UserDAO
    }

    @Override
    public List<User> getAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public User get(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public User get(String username) {
        // TODO Auto-generated method stub
        return userDAO.get(username);
    }
}
