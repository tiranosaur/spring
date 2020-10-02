package example.service.role;

import example.model.Role;

import java.util.Collection;

public interface RoleServiceInterface {
	public Role create(Role role);
	public Collection<Role> all();
	public Role get(Integer id);
	public Role update(Role role);
	public Boolean delete(Integer id);
}
