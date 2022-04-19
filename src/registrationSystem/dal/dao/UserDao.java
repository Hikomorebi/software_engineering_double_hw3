package registrationSystem.dal.dao;

import java.util.List;

import registrationSystem.dal.entity.User;

public interface UserDao {
	public boolean addUser(User user);

	public boolean update(User user);

	public User getUserbyID(int id);

	public List<User> getallUser();

	public boolean certifyUser(String uname, String upassword);
}
