package registrationSystem.dal.dao;


import java.util.List;

import registrationSystem.dal.entity.NadTaker;
/**
 * @author Kunbin He,Haoze Zhu
 * @version 创建时间：2021年4月20日
 */
public interface NadTakerDao {
	
	/**
	 * 获取所有已经注册过的核酸检测人员信息
	 * @return 核酸检测人员的对象列表
	 */
	public List<NadTaker> getAllTaker();
	
	
	/**
	 * 注册一个核酸检测人员
	 * @param nadTaker 一个检测人员的对象
	 * @return 注册是否成功
	 */
	public boolean registerTaker(NadTaker nadTaker);
	
	/**
	 * 根据身份证号码查询此人核酸检测结果
	 * @param number 身份证号码
	 * @return 核酸检测结果
	 */
	public String getAnswer(String number);
	
	/**
	 * 登记核酸检测时间以及核酸检测结果
	 * @param number 身份证号
	 * @param time 核酸检测结果
	 * @param res 核酸检测结果
	 * @return 是否成功登记
	 */
    public boolean checkNadTaker(String number,String time,String res);
}
