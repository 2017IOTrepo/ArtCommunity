import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class yddj extends JPanel {
    private JTextField textField;
    String ydono;

    /**
     * Create the panel.
     */
    public yddj() {
        setLayout(null);

        JLabel label = new JLabel("Ԥ���Ǽ�");
        label.setFont(new Font("����", Font.ITALIC, 14));
        label.setBounds(14, 13, 60, 18);
        add(label);

        JLabel label_1 = new JLabel("Ԥ���ֻ���");
        label_1.setBounds(71, 90, 72, 18);
        add(label_1);

        JLabel label_2 = new JLabel("Ԥ������");
        label_2.setBounds(71, 121, 72, 18);
        add(label_2);

        final JComboBox comboBox = new JComboBox();
        comboBox.setBounds(203, 118, 114, 24);
        comboBox.addItem("���˼�");
        comboBox.addItem("���");
        comboBox.addItem("�����");
        comboBox.addItem("�׼�");
        add(comboBox);

        JLabel label_3 = new JLabel("��ǰ������ΪԤ��ʱ��");
        label_3.setBounds(77, 173, 154, 18);
        add(label_3);


        textField = new JTextField();
        textField.setBounds(203, 87, 114, 24);
        add(textField);
        textField.setColumns(10);


        JButton button = new JButton("�ύ");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                /***
                 * ���ݿ�
                 *
                 */
                String ydphone = textField.getText();
                String ydtype = comboBox.getSelectedItem().toString();
                Date yddate = new java.sql.Date(new java.util.Date().getTime());


                Bean yd = new Bean();

                ResultSet rs = null;
                rs = yd.executeQuery("SELECT Rno =MIN(Rno) FROM Room b WHERE (( b.Rstate = '��' ) AND (b.Rtype = '" + ydtype + "')AND(b.ROstate='��'))");
                try {
                    while (rs.next()) {
                        ydono = rs.getString("Rno");

                    }
                } catch (SQLException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                yd.execQuery("INSERT INTO Orderr VALUES ('" + ydphone + "','" + yddate + "','" + ydtype + "','" + ydono + "');");

                yd.executeUpdate("UPDATE Room SET ROstate='��' WHERE(Rno=(SELECT Rno =MIN(Rno) FROM Room b WHERE (( b.Rstate = '��' ) AND (b.Rtype = '" + ydtype + "')AND(b.ROstate='��'))));");
                yd.close();

            }
        });


        button.setBounds(86, 233, 81, 27);
        add(button);

        JButton button_1 = new JButton("����");
        button_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textField.setText(null);    //������Ϣ��Ϊ��ֵ


            }
        });
        button_1.setBounds(203, 233, 81, 27);
        add(button_1);


    }
}