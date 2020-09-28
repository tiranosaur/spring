package example.service;


import example.model.User;
import example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Service
@Transactional
public class UserService implements UserServiceInterface {

    @Autowired
    protected UserRepository userRepository;

    @Override
    public User saveUser(User emp) {
        return null;
    }

    @Override
    public Collection<User> getUsers() {
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(x -> users.add(x));
        return users;
    }

    @Override
    public User getUserById(Integer userId) {
        return userRepository.findById(userId).get();
    }

    @Override
    public User editUser(User emp) {
        return null;
    }

    @Override
    public Boolean deleteUser(String empId) {
        return null;
    }
}
