package registrationSystem.dal.daoImp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.util.ArrayList;
import registrationSystem.dal.DBUtil;
import registrationSystem.dal.entity.NadTaker;
import registrationSystem.dal.dao.NadTakerDao;

public class NadTakerDaoImp implements NadTakerDao {
	@Override
	public List<NadTaker> getAllTaker() {
		String select = "select * from taker";
		try {
			List<NadTaker> takers = new ArrayList<NadTaker>();
			ResultSet rs = DBUtil.runQuery(select);
			while (rs.next()) {
				NadTaker taker = new NadTaker();
				taker.setSid(rs.getInt("sid"));
				taker.setSname(rs.getString("sname"));
				taker.setSnumber(rs.getString("snumber"));
				taker.setSage(rs.getInt("sage"));
				taker.setSphone(rs.getString("sphone"));
				taker.setSaddress(rs.getString("saddress"));
				taker.setState(rs.getString("state"));
				taker.setStime(rs.getString("stime"));
				takers.add(taker);
			}
			DBUtil.realeaseAll();
			return takers;
		} catch (SQLException ex) {
			Logger.getLogger(UserDaoImp.class.getName()).log(Level.SEVERE, null, ex);
		}
		return null;
	}

	@Override
	public boolean registerTaker(NadTaker nadTaker) {
		String insert = "insert into taker(sname,snumber,sage,sphone,saddress,state,stime) " + "values('"
				+ nadTaker.getSname() + "','" + nadTaker.getSnumber() + "','" + nadTaker.getSage() + "','"
				+ nadTaker.getSphone() + "','" + nadTaker.getSaddress() + "','" + nadTaker.getState() + "','"
				+ nadTaker.getStime() + "')";

		try {
			// System.out.println(insert);
			DBUtil.runUpdate(insert);
			return true;
		} catch (SQLException ex) {
			Logger.getLogger(UserDaoImp.class.getName()).log(Level.SEVERE, null, ex);
		}
		return false;
	}

	@Override
	public String getAnswer(String number) {
		String select = "select state from taker where snumber='" + number + "'";
		try {
			ResultSet rs = DBUtil.runQuery(select);
			while (rs.next()) {
				return rs.getString("state");
			}

		} catch (SQLException ex) {
			Logger.getLogger(UserDaoImp.class.getName()).log(Level.SEVERE, null, ex);
		}
		return "查无此人";
	}

}
