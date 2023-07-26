package web.Dao;


import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.*;
import java.util.List;

@Repository
public class DaoImp implements DaoInterface {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("select user from User user", (User.class)).getResultList();
    }

    @Override
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void deleteUser(Long id) {
      entityManager.createQuery("delete from User user where user.id=:id")
                .setParameter("id", id)
                .executeUpdate();
    }

    @Override
    public User getUserById(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void updateUser(Long id, User updatedUser) {
        User upUser = getUserById(id);
        upUser.setName(updatedUser.getName());
        upUser.setEmail(updatedUser.getEmail());
        upUser.setPhone(updatedUser.getPhone());
        entityManager.merge(upUser);
    }
}
