package example.service.user;

import example.model.User;

import java.util.Collection;

public interface UserServiceInterface {
	public User create(User user);
	public Collection<User> all();
	public User get(Integer id);
	public User update(User user);
	public Boolean delete(Integer id);
}
