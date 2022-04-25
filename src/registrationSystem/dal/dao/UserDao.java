package registrationSystem.dal.dao;

import java.util.List;

import registrationSystem.dal.entity.User;
/**
 * @author Kunbin He,Haoze Zhu
 * @version ����ʱ�䣺2021��4��20��
 */
public interface UserDao {
	
	/**
	 * �����ݿ����һ���û�
	 * @param user ���û��Ķ���
	 * @return �Ƿ���ӳɹ�
	 */
	public boolean addUser(User user);
	
	/**
	 * �����û���Ϣ
	 * @param user �û�����
	 * @return �Ƿ���³ɹ�
	 */
	public boolean update(User user);
	
	/**
	 * �ҵ���IDƥ����û�
	 * @param id
	 * @return ��id��ƥ����û�����
	 */
	public User getUserById(int id);
	
	/**
	 * ��ȡ�����û�
	 * @return ӵ�������û������list
	 */
	public List<User> getallUser();

	/**
	 * ��֤�û����������Ƿ�ƥ��
	 * @param uname �û���
	 * @param upassword �û�����
	 * @return �Ƿ���֤�ɹ�
	 */
	public boolean certifyUser(String uname, String upassword);
}
