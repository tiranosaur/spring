package example.service.role;

import example.model.Role;
import example.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Service
@Transactional
public class RoleService implements RoleServiceInterface {

    @Autowired
    protected RoleRepository roleRepository;

    @Override
    public Role create(Role role) {
        return null;
    }

    @Override
    public Collection<Role> all() {
        List<Role> users = new ArrayList<>();
        roleRepository.findAll().forEach(x -> users.add(x));
        return users;
    }

    @Override
    public Role get(Integer userId) {
        return roleRepository.findById(userId).get();
    }

    @Override
    public Role update(Role role) {
        return null;
    }

    @Override
    public Boolean delete(Integer id) {
        return null;
    }
}
