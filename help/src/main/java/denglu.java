import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")

public class denglu extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					denglu frame = new denglu();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public denglu() {
		
		setVisible(true);
		setTitle("��¼");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 250, 380, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("�û���");
		label.setBounds(76, 149, 72, 18);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.setBounds(151, 146, 134, 24);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel label_1 = new JLabel("����");
		label_1.setBounds(76, 203, 72, 18);
		contentPane.add(label_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(151, 200, 134, 24);
		contentPane.add(passwordField);
		
		
		
		JButton button = new JButton("��¼");
		button.addActionListener(new ActionListener() {
			
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				String name=textField.getText();
				String pswd=passwordField.getText();
				Boolean sss=panduan(name,pswd);
				if(name.trim().length()==0||pswd.trim().length()==0){
					JOptionPane.showMessageDialog(null, "�û������벻����Ϊ��");
					return;
				}
				if(sss){
					JOptionPane.showMessageDialog(null, "��¼�ɹ�");
					denglu.this.dispose();	//�رյ�¼����
					new Xitong();
				}
				else
					JOptionPane.showMessageDialog(null, "�����֤ʧ��");
			}

		});
		button.setBounds(59, 272, 113, 27);
		contentPane.add(button);
		
		JButton button_1 = new JButton("����");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(null);
				passwordField.setText(null);
			}
		});
		button_1.setBounds(227, 272, 113, 27);
		contentPane.add(button_1);

		
		JLabel lblImag = new JLabel();
		lblImag.setSize(100, 100);
		lblImag.setLocation(140, 24);
		ImageIcon icon = new ImageIcon("C:\\Users\\dell\\Pictures\\3.jpg");	//lblImag��Ҫ��ʾ��ͼ��
		Image img =icon.getImage();	//ͼ���л�ȡͼ��
		img = img.getScaledInstance(100, 100, Image.SCALE_DEFAULT); //������ͼ������Ű汾��ԭ��С100x100
		icon.setImage(img);
		lblImag.setIcon(icon);	//����ΪlblImag��Ҫ��ʾ��ͼ��
		contentPane.add(lblImag);
		lblImag.setVisible(true);	
	}
	
	Boolean panduan(String a,String b)
	{
		try {
				Bean a1= new Bean();	//���ݿ�����
				ResultSet rs = a1.executeQuery("select * from Manager where Mno="+a+" and Mpassword="+b+"");
					
				if(rs.next())
					return true;
				a1.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				return false;
			}

			return false;
	}

}
