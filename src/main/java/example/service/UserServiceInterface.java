package example.service;

import example.model.User;

import java.util.Collection;

public interface UserServiceInterface {
	public User saveUser(User emp);
	public Collection<User> getUsers();
	public User getUserById(Integer userId);
	public User editUser(User emp);
	public Boolean deleteUser(String userId);
}
