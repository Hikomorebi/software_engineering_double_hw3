package registrationSystem.dal.dao;


import java.util.List;

import registrationSystem.dal.entity.NadTaker;
/**
 * @author Kunbin He,Haoze Zhu
 * @version ����ʱ�䣺2021��4��20��
 */
public interface NadTakerDao {
	
	/**
	 * ��ȡ�����Ѿ�ע����ĺ�������Ա��Ϣ
	 * @return ��������Ա�Ķ����б�
	 */
	public List<NadTaker> getAllTaker();
	
	
	/**
	 * ע��һ����������Ա
	 * @param nadTaker һ�������Ա�Ķ���
	 * @return ע���Ƿ�ɹ�
	 */
	public boolean registerTaker(NadTaker nadTaker);
	
	/**
	 * �������֤�����ѯ���˺�������
	 * @param number ���֤����
	 * @return ��������
	 */
	public String getAnswer(String number);
	
	/**
	 * �ǼǺ�����ʱ���Լ���������
	 * @param number ���֤��
	 * @param time ��������
	 * @param res ��������
	 * @return �Ƿ�ɹ��Ǽ�
	 */
    public boolean checkNadTaker(String number,String time,String res);
}
