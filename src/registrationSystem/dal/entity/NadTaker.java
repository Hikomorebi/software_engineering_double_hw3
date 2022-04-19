package registrationSystem.dal.entity;

public class NadTaker {
	private int sid;
	private String sname; 	// ���������
	private String snumber; // ��������֤����
	private int sage; 		// ���������
	private String sphone; 	// ����ߵ绰����
	private String saddress; // ����ߵ�ַ
	private int state; 		// �������0 ���ԣ�1 ���ԣ�2 ��δ���
	private String stime; 	// ���ʱ��

	public NadTaker() {
	}

	public NadTaker(String sname, String snumber, int sage, String sphone, String saddress) {
		this.sname = sname;
		this.snumber = snumber;
		this.sage = sage;
		this.sphone = sphone;
		this.saddress = saddress;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
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
