import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

//import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class Shouye extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Shouye frame = new Shouye();
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
	public Shouye() {
		
		setTitle("�ͷ�����ϵͳ��ҳ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(180,150,1000,530);
		contentPane = new JPanel();
		contentPane.setVisible(true);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton button = new JButton("��¼");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new denglu();
				Shouye.this.dispose();
			}
		});
		button.setFont(new Font("����", Font.BOLD, 18));
		button.setBounds(860, 13, 82, 39);
		contentPane.add(button);
		
		JLabel label = new JLabel("*****\u6B22\u8FCE\u767B\u9646\u5BA2\u623F\u7BA1\u7406\u7CFB\u7EDF*****");
		label.setFont(new Font("��������", Font.BOLD, 30));
		label.setBounds(163, 0, 586, 85);
		contentPane.add(label);
		
		
	//���ñ���ͼƬ	
		
		JLabel label_1 = new JLabel();
		label_1.setSize(954, 403);
		label_1.setLocation(14, 67);
		ImageIcon icon = new ImageIcon("C:\\Users\\dell\\Pictures\\background.jpg");	//lblImag��Ҫ��ʾ��ͼ��
		Image img =icon.getImage();	//ͼ���л�ȡͼ��
		img = img.getScaledInstance(954, 403, Image.SCALE_DEFAULT);
		icon.setImage(img);
		label_1.setIcon(icon);
		contentPane.add(label_1);
		label_1.setVisible(true);
		
		setVisible(true);
	}
}
