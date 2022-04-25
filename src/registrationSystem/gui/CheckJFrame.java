package registrationSystem.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import registrationSystem.dal.entity.NadTaker;
import registrationSystem.dal.daoImp.NadTakerDaoImp;

/**
 * @author Kunbin He,Haoze Zhu
 * @version ����ʱ�䣺2021��4��20��
 */

public class CheckJFrame extends JFrame{
	private JPanel contentPane;
	private NadTaker nadTaker;
	private JTextField snumber;
	private JTextField stime;
	private JTextField state;
	private String number;
	private String time;
	private String res;
	
	public CheckJFrame() {
		super();
		setTitle("�ǼǺ�������");		
		initComponents();
	}
	
//	public CheckJFrame(NadTaker nadTaker) throws HeadlessException {
//		super();
//		initComponents();
//		this.nadTaker = nadTaker;
//		sname.setText(student.getSname());
//		sage.setText(student.getSage()+"");
//
//		snumber.setText(student.getSnumber());
//		sphone.setText(student.getSphone());
//	}
	
	public void initComponents() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		
		snumber = new JTextField();
		snumber.setBounds(216, 100, 128, 21);
		contentPane.add(snumber);
		snumber.setColumns(10);
		
		stime = new JTextField();
		stime.setBounds(216, 150, 128, 21);
		contentPane.add(stime);
		stime.setColumns(10);
		
		state = new JTextField();
		state.setBounds(216, 200, 128, 21);
		contentPane.add(state);
		state.setColumns(10);
		
		
		
		JLabel labelSnumber = new JLabel("���֤�ţ�");
		labelSnumber.setBounds(123, 100, 70, 15);
		contentPane.add(labelSnumber);
		
		JLabel labelStime = new JLabel("���ʱ�䣺");
		labelStime.setBounds(123, 150, 70, 15);
		contentPane.add(labelStime);
		
		JLabel labelState = new JLabel("�������");
		labelState.setBounds(123, 200, 70, 15);
		contentPane.add(labelState);
		
		
		JButton buttonUpdate = new JButton("�Ǽ�");
		buttonUpdate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				checkInActionPerformed(e);
			}
		});
		buttonUpdate.setBounds(102, 300, 93, 23);
		contentPane.add(buttonUpdate);
		
		JButton buttonCancel = new JButton("ȡ��");
		buttonCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cancelActionPerformed(e);
			}
		});
		buttonCancel.setBounds(261, 300, 93, 23);
		contentPane.add(buttonCancel);
	}
	
	private void checkInActionPerformed(ActionEvent actionEvent) {
		 NadTakerDaoImp nadTakerDaoImp=new NadTakerDaoImp();
		try {
			number = this.snumber.getText();
			time = this.stime.getText();
			res = this.state.getText();
			//number = Integer.valueOf(this.sweight.getText()).intValue();
			if(nadTakerDaoImp.checkNadTaker(number,time,res)) {
				JOptionPane.showMessageDialog(this, "�Ǽǳɹ���");
			}else {
				JOptionPane.showMessageDialog(this, "�Ǽ�ʧ�ܣ�");
			}
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this, "�Ǽ�ʧ�ܣ�");
		}		
	}
	
	private void cancelActionPerformed(ActionEvent actionEvent) {
		this.setVisible(false);
		this.dispose();
	}
}











