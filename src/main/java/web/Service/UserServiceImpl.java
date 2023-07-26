package web.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.Dao.DaoInterface;
import web.model.User;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {


    DaoInterface daoInterface;

    @Autowired
    public UserServiceImpl(DaoInterface daoInterface) {
        this.daoInterface = daoInterface;
    }

    @Override
    public List<User> getAllUsers() {
        return daoInterface.getAllUsers();
    }


    @Override
    @Transactional
    public void saveUser(User user) {
        daoInterface.saveUser(user);
    }


    @Override
    @Transactional
    public void deleteUser(Long id) {
        daoInterface.deleteUser(id);
    }


    @Override
    public User getUserById(Long id) {
        return daoInterface.getUserById(id);
    }


    @Override
    @Transactional
    public void updateUser(Long id, User updatedUser) {
        daoInterface.updateUser(id, updatedUser);
    }
}
