package registrationSystem.dal.dao;


import java.util.List;

import registrationSystem.dal.entity.NadTaker;

public interface NadTakerDao {
	public List<NadTaker> getAllTaker();
	public boolean registerTaker(NadTaker nadTaker);
}
