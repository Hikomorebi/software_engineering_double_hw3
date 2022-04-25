package registrationSystem.dal.entity;
/**
 * @author Kunbin He,Haoze Zhu
 * @version ����ʱ�䣺2021��4��20��
 */
public class NadTaker {
	private int sid;
	/**���������*/
	private String sname;
	/**��������֤����*/
	private String snumber;
	/**���������*/
	private int sage;
	/**����ߵ绰����*/
	private String sphone;
	/**����ߵ�ַ*/
	private String saddress;
	/**�����*/
	private String state;
	/**���ʱ��*/
	private String stime;

	public NadTaker() {
	}

	public NadTaker(String sname, String snumber, int sage, String sphone, String saddress) {
		this.sname = sname;
		this.snumber = snumber;
		this.sage = sage;
		this.sphone = sphone;
		this.saddress = saddress;
	}



	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getStime() {
		return stime;
	}

	public void setStime(String stime) {
		this.stime = stime;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public int getSid() {
		return sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getSnumber() {
		return snumber;
	}

	public void setSnumber(String snumber) {
		this.snumber = snumber;
	}

	public int getSage() {
		return sage;
	}

	public void setSage(int sage) {
		this.sage = sage;
	}

	public String getSphone() {
		return sphone;
	}

	public void setSphone(String sphone) {
		this.sphone = sphone;
	}

	public String getSaddress() {
		return saddress;
	}

	public void setSaddress(String saddress) {
		this.saddress = saddress;
	}
}
