package example.service.user;


import example.model.User;
import example.repository.RoleRepository;
import example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class UserService implements UserServiceInterface {

    @Autowired
    protected UserRepository userRepository;
    @Autowired
    protected RoleRepository roleRepository;

    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

    @Override
    public Collection<User> all() {
        List<User> users = new ArrayList<>();
//        userRepository.findAll().forEach(x -> users.add(x));
        userRepository.findAll().forEach(users::add);
        return users;
    }

    @Override
    public User get(Integer userId) {
        Optional<User> user = userRepository.findById(userId);
//        return user.isPresent() ? user.get() : null;
        return user.orElse(null);
    }

    @Override
    public User update(User user) {
        return userRepository.save(user);
    }

    @Override
    public Boolean delete(Integer id) {
        Optional<User> user = userRepository.findById(id);
        user.ifPresent(value -> userRepository.delete(value));
        return userRepository.findById(id).isEmpty();
    }
}
