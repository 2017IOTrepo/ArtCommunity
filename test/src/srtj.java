import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class srtj extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Create the panel.
	 */
	public srtj() {
		setLayout(null);
		
		JLabel label = new JLabel("����ͳ��");
		label.setFont(new Font("����", Font.ITALIC, 14));
		label.setBounds(14, 13, 60, 18);
		add(label);
		
		JLabel label_1 = new JLabel("\u8981\u7EDF\u8BA1\u7684\u5E74");
		label_1.setBounds(62, 69, 88, 18);
		add(label_1);
		
		textField = new JTextField();
		textField.setBounds(178, 66, 86, 24);
		add(textField);
		textField.setColumns(10);
		
		JLabel label_2 = new JLabel("Ҫͳ�Ƶ��·�");
		label_2.setBounds(62, 116, 88, 18);
		add(label_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(178, 113, 86, 24);
		add(textField_1);
		textField_1.setColumns(10);
	
	//���ݿ����	
		JButton button = new JButton("������ͳ�ƣ�/Ԫ��");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		button.setBounds(62, 229, 180, 27);
		add(button);
	
	//ͳ�ƽ����ʾ	
		textField_2 = new JTextField();
		textField_2.setBounds(256, 230, 86, 24);
		add(textField_2);
		textField_2.setColumns(10);
	//���ݿ����	
		JButton button_1 = new JButton("������ͳ�ƣ�/Ԫ��");
		button_1.setBounds(62, 301, 180, 27);
		add(button_1);
		
	//ͳ�ƽ����ʾ	
		textField_3 = new JTextField();
		textField_3.setBounds(256, 302, 86, 24);
		add(textField_3);
		textField_3.setColumns(10);

	}

}
