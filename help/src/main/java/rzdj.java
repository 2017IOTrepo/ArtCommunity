import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class rzdj extends JPanel {
    private JTextField textField_3;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_5;
    private JTextField textField_6;
    private JTextField textField_7;
    private JTextField textField_8;
    private JTextField textField_4;

    private int money;
    private Date nowdate;
    private String days;
    private int day;

    /**
     * Create the panel.
     */
    public rzdj() {
        setLayout(null);

        JLabel label = new JLabel("��ס�Ǽ�");
        label.setFont(new Font("����", Font.ITALIC, 14));
        label.setBounds(14, 13, 60, 18);
        add(label);

        JLabel label_1 = new JLabel("��������");
        label_1.setBounds(27, 60, 72, 18);
        add(label_1);

        textField_3 = new JTextField();
        textField_3.setBounds(101, 57, 86, 24);
        add(textField_3);
        textField_3.setColumns(10);

        JLabel label_2 = new JLabel("֤������");
        label_2.setBounds(27, 102, 72, 18);
        add(label_2);

        final JComboBox comboBox = new JComboBox();
        comboBox.addItem("���֤");
        comboBox.addItem("����");
        comboBox.setBounds(101, 99, 86, 24);
        add(comboBox);

        JLabel label_3 = new JLabel("֤������");
        label_3.setBounds(27, 158, 72, 18);
        add(label_3);

        textField_1 = new JTextField();
        textField_1.setBounds(101, 155, 132, 24);
        add(textField_1);
        textField_1.setColumns(10);

        JLabel label_4 = new JLabel("��  ��");
        label_4.setBounds(27, 210, 72, 18);
        add(label_4);

        final JComboBox comboBox_1 = new JComboBox();
        comboBox_1.addItem("��");
        comboBox_1.addItem("Ů");
        comboBox_1.setBounds(101, 207, 86, 24);
        add(comboBox_1);

        JLabel label_5 = new JLabel("��ϵ��ʽ");
        label_5.setBounds(27, 267, 72, 18);
        add(label_5);

        textField_2 = new JTextField();
        textField_2.setBounds(101, 264, 132, 24);
        add(textField_2);
        textField_2.setColumns(10);

        JLabel label_6 = new JLabel("��סʱ�䣨�Զ���ȡ��ǰʱ�䣩");
        label_6.setBounds(371, 198, 223, 18);
        add(label_6);

        JLabel label_9 = new JLabel("�ͷ����");
        label_9.setBounds(371, 57, 72, 18);
        add(label_9);

        textField_5 = new JTextField();
        textField_5.setBounds(482, 57, 97, 24);
        add(textField_5);
        textField_5.setColumns(10);

        JLabel label_10 = new JLabel("���ռ۸�");
        label_10.setBounds(371, 158, 72, 18);
        add(label_10);

        textField_6 = new JTextField();
        textField_6.setBounds(482, 155, 97, 24);
        add(textField_6);
        textField_6.setColumns(10);

        JLabel label_11 = new JLabel("������");
        label_11.setBounds(371, 307, 72, 18);
        add(label_11);

        JLabel label_12 = new JLabel("��סʱ��");
        label_12.setBounds(371, 252, 72, 18);
        add(label_12);

        textField_7 = new JTextField();
        textField_7.setBounds(482, 249, 86, 24);
        add(textField_7);
        textField_7.setColumns(10);

        textField_8 = new JTextField();
        textField_8.setBounds(482, 304, 86, 24);
        add(textField_8);
        textField_8.setColumns(10);

        JLabel label_13 = new JLabel("����������");
        label_13.setBounds(372, 355, 86, 18);
        add(label_13);

        final JComboBox comboBox_4 = new JComboBox();
        comboBox_4.addItem("JOSH");
        comboBox_4.addItem("LILI");

        comboBox_4.setBounds(482, 352, 86, 24);
        add(comboBox_4);

        JLabel label_7 = new JLabel("�ͷ����");
        label_7.setBounds(371, 105, 72, 18);
        add(label_7);

        textField_4 = new JTextField();
        textField_4.setBounds(482, 99, 97, 24);
        add(textField_4);
        textField_4.setColumns(10);

        JLabel lblNewLabel = new JLabel("Ѻ��100Ԫ��");
        lblNewLabel.setBounds(27, 310, 160, 18);
        add(lblNewLabel);

        JLabel label_8 = new JLabel("Ѻ��״̬");
        label_8.setBounds(27, 355, 72, 18);
        add(label_8);

        final JComboBox comboBox_2 = new JComboBox();    //Ѻ��״̬
        comboBox_2.addItem("δ��");
        comboBox_2.addItem("�ѽ�");
        comboBox_2.setBounds(101, 352, 86, 24);
        add(comboBox_2);

        JButton btnNewButton = new JButton("����");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textField_1.setText(null);
                textField_2.setText(null);
                textField_3.setText(null);
                textField_4.setText(null);
                textField_5.setText(null);
                textField_6.setText(null);
                textField_7.setText(null);
                textField_8.setText(null);
            }
        });
        btnNewButton.setBounds(309, 439, 113, 27);
        add(btnNewButton);

        JButton button_1 = new JButton("ȷ��");
        button_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String roomNumber = textField_5.getText();
                days = textField_7.getText();


                //��ȡ��ǰ����
                nowdate = new java.sql.Date(new java.util.Date().getTime());


                //	     long money = days * price;������Ĺ�ʽ�����м۸��ɿͷ���Ų���Room��õ�
                String no = textField_5.getText();

                Bean bbb = new Bean();
                ResultSet brs = bbb.executeQuery("select Rtype,Rprice from Room where Rno='" + no + "'");
                try {
                    while (brs.next()) {
                        String Roomtype = brs.getString("Rtype");
                        int Roomprice = brs.getInt("Rprice");

                        textField_4.setText(Roomtype);
                        textField_6.setText(String.valueOf(Roomprice));    //intת��Ϊ�ַ���
                        day = Integer.valueOf(days);
                        money = day * Roomprice;
                        textField_8.setText(String.valueOf(money));
                    }
                } catch (SQLException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                bbb.close();

            }
        });
        button_1.setBounds(133, 439, 113, 27);
        add(button_1);

        //��ס��Ϣ�ĵǼǣ����ݿ����
        JButton button = new JButton("�ύ");
        button.setFont(new Font("����", Font.BOLD, 19));
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String cname = textField_3.getText();
                String cid = textField_1.getText();
                String tel = textField_2.getText();
                String rno = textField_5.getText();
                String rtype = textField_4.getText();
                String price = textField_6.getText();
                String cidtype = comboBox.getSelectedItem().toString();
                String csex = comboBox_1.getSelectedItem().toString();
                String yjstate = comboBox_2.getSelectedItem().toString();
                String manage = comboBox_4.getSelectedItem().toString();
                //			System.out.println(cid);

                Bean aaa = new Bean();
//                aaa.execQuery("insert into CUSTOMER values('" + cid + "','" + cidtype + "','" + cname + "','" + csex + "','" + tel + "')");//����ͻ���Ϣ
                aaa.execQuery("insert into CHECKIN(CIid,CIname,CItime,CIdays,CImon,CIMname,CIRno,CIRstate) values('" + cid + "','" + cname + "','" + nowdate + "'," + day + "," + money + ",'" + manage + "','" + rno + "','��ס')");//������ס��Ϣ
                aaa.execQuery("UPDATE Room SET Rdeposite = '" + yjstate + "'WHERE Rno='" + rno + "'");

            }
        });
        button.setBounds(550, 426, 97, 40);
        add(button);

    }
}
