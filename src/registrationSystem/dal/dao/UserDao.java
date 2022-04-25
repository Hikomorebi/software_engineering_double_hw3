package registrationSystem.dal.dao;

import java.util.List;

import registrationSystem.dal.entity.User;
/**
 * @author Kunbin He,Haoze Zhu
 * @version 创建时间：2021年4月20日
 */
public interface UserDao {
	
	/**
	 * 向数据库添加一个用户
	 * @param user 该用户的对象
	 * @return 是否添加成功
	 */
	public boolean addUser(User user);
	
	/**
	 * 更新用户信息
	 * @param user 用户对象
	 * @return 是否更新成功
	 */
	public boolean update(User user);
	
	/**
	 * 找到与ID匹配的用户
	 * @param id
	 * @return 与id相匹配的用户对象
	 */
	public User getUserById(int id);
	
	/**
	 * 获取所有用户
	 * @return 拥有所有用户对象的list
	 */
	public List<User> getallUser();

	/**
	 * 验证用户名与密码是否匹配
	 * @param uname 用户名
	 * @param upassword 用户密码
	 * @return 是否验证成功
	 */
	public boolean certifyUser(String uname, String upassword);
}
