package registrationSystem.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

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

public class RegisterJFrame extends JFrame {
	private JPanel contentPane;
	private JTextField sname;
	private JTextField sage;
	private JTextField saddress;
	private JTextField snumber;
	private JTextField sphone;
	private JTextField stime;
	private JTextField state;


	public RegisterJFrame() {
		setTitle("注册");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 426, 460);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		sname = new JTextField();
		sname.setBounds(195, 30, 140, 20);
		contentPane.add(sname);
		sname.setColumns(10);

		sage = new JTextField();
		sage.setBounds(195, 70, 140, 20);
		contentPane.add(sage);
		sage.setColumns(10);

		saddress = new JTextField();
		saddress.setBounds(195, 110, 140, 20);
		contentPane.add(saddress);
		saddress.setColumns(10);

		snumber = new JTextField();
		snumber.setBounds(195, 150, 140, 20);
		contentPane.add(snumber);
		snumber.setColumns(10);

		sphone = new JTextField();
		sphone.setBounds(195, 190, 140, 20);
		contentPane.add(sphone);
		sphone.setColumns(10);
		
		stime = new JTextField();
		stime.setBounds(195, 230, 140, 20);
		contentPane.add(stime);
		stime.setColumns(10);
		
		state = new JTextField();
		state.setBounds(195, 270, 140, 20);
		contentPane.add(state);
		state.setColumns(10);

		JLabel labelName = new JLabel("姓名：");
		labelName.setBounds(90, 30, 66, 15);
		contentPane.add(labelName);

		JLabel labelAge = new JLabel("年龄：");
		labelAge.setBounds(90, 70, 66, 15);
		contentPane.add(labelAge);

		JLabel labelAddress = new JLabel("地址：");
		labelAddress.setBounds(90, 110, 66, 15);
		contentPane.add(labelAddress);

		JLabel labelSnumber = new JLabel("身份证号：");
		labelSnumber.setBounds(90, 150, 66, 15);
		contentPane.add(labelSnumber);

		JLabel labelPhone = new JLabel("联系电话：");
		labelPhone.setBounds(90, 190, 66, 15);
		contentPane.add(labelPhone);

		JLabel labelTime = new JLabel("检测时间：");
		labelTime.setBounds(90, 230, 66, 15);
		contentPane.add(labelTime);
		
		JLabel labelState = new JLabel("检测结果：");
		labelState.setBounds(90, 270, 66, 15);
		contentPane.add(labelState);
		
		JButton buttonAdd = new JButton("注册");
		buttonAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registerTakerActionPerformed(e);
			}
		});
		buttonAdd.setBounds(91, 327, 93, 23);
		contentPane.add(buttonAdd);

		JButton buttonCancel = new JButton("取消");
		buttonCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelActionPerformed(e);
			}
		});
		buttonCancel.setBounds(230, 327, 93, 23);
		contentPane.add(buttonCancel);
	}

	private void registerTakerActionPerformed(ActionEvent event) {
		NadTaker nadTaker = new NadTaker();
		NadTakerDaoImp nadTakerDaoImp = new NadTakerDaoImp();
		try {
			nadTaker.setSname(sname.getText());
			nadTaker.setSage(Integer.parseInt(sage.getText()));
			nadTaker.setSaddress(saddress.getText());
			nadTaker.setSnumber(snumber.getText());
			nadTaker.setSphone(sphone.getText());
			nadTaker.setStime(stime.getText());
			nadTaker.setState(state.getText());
			nadTakerDaoImp.registerTaker(nadTaker);
			JOptionPane.showMessageDialog(this, "注册成功！", "添加检测人员信息", JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this, "注册失败！", "添加检测人员信息", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void cancelActionPerformed(ActionEvent event) {
		this.setVisible(false);
		this.dispose();
	}
}
