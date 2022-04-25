package registrationSystem.dal.daoImp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import registrationSystem.dal.DBUtil;
import registrationSystem.dal.entity.User;
import registrationSystem.dal.dao.UserDao;
/**
 * @author Kunbin He,Haoze Zhu
 * @version 创建时间：2021年4月20日
 */
public class UserDaoImp implements UserDao {

	@Override
	public boolean addUser(User user) {
		String insert = "insert into user(uname,upassword) values('" + user.getUname() + "','" + user.getUpassword()
				+ "')";
		try {
			DBUtil.runUpdate(insert);
			return true;
		} catch (SQLException ex) {
			Logger.getLogger(UserDaoImp.class.getName()).log(Level.SEVERE, null, ex);
		}
		return false;
	}

	@Override
	public boolean update(User user) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public User getUserById(int id) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public List<User> getallUser() {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public boolean certifyUser(String uname, String upassword) {
		String select = "select * from user where uname='" + uname + "' and upassword='" + upassword + "'";
		boolean isCertifyUser = false;
		try {
			ResultSet rs = DBUtil.runQuery(select);
			if (rs != null) {
				isCertifyUser = rs.next();
				DBUtil.realeaseAll();
			}
		} catch (SQLException ex) {
			Logger.getLogger(UserDaoImp.class.getName()).log(Level.SEVERE, null, ex);
		}
		return isCertifyUser;
	}

}
