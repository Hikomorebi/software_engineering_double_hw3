package registrationSystem.dal.entity;
/**
 * @author Kunbin He,Haoze Zhu
 * @version 创建时间：2021年4月20日
 */
public class User {
	private int uid;
	private String uname;
	private String upassword;

	public User() {
	}

	public User(String uname, String upassword) {
		// 管理员名称
		this.uname = uname;
		// 密码
		this.upassword = upassword;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUpassword() {
		return upassword;
	}

	public void setUpassword(String upassword) {
		this.upassword = upassword;
	}

}