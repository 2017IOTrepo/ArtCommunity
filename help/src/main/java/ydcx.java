import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ydcx extends JPanel implements ActionListener {
    String name = new String();
    String tel = new String();
    public JTextField textField_1;
    private JTable p1;
    private ResultSet rs = null;
    DefaultTableModel model;

    public ydcx() {

        this.setLayout(null);

        JLabel label = new JLabel("Ԥ����ѯ");
        label.setFont(new Font("����", Font.ITALIC, 14));
        label.setBounds(14, 13, 60, 18);
        this.add(label);

        JLabel label_2 = new JLabel("��ϵ��ʽ");
        label_2.setBounds(59, 93, 72, 18);
        this.add(label_2);

        textField_1 = new JTextField();
        textField_1.setBounds(172, 90, 134, 24);
        this.add(textField_1);
        textField_1.setColumns(10);

        JButton button = new JButton("��ѯ");
        button.addActionListener(this);
        button.setFont(new Font("����", Font.BOLD, 15));
        button.setBounds(373, 89, 113, 27);
        this.add(button);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(19, 174, 625, 206);
        add(scrollPane);

        JTable table = new JTable();
        model = (DefaultTableModel) table.getModel();    //��ñ��ģ��
        model.setRowCount(0);    //��ձ���е�����
        model.setColumnIdentifiers(new Object[]{"��ϵ��ʽ", "��������", "Ԥ��ʱ��"});    //���ñ�ͷ
        scrollPane.setViewportView(table);


    }

    public void actionPerformed(ActionEvent e) {


        try {
            model.setRowCount(0);
            Bean yd = new Bean();

            String Ctel = "'" + textField_1.getText().trim() + "'";
            System.out.println(Ctel);
            ResultSet rs = yd.executeQuery("SELECT * FROM Orderr WHERE Otel=" + Ctel + "");
            rs.last();
            int num = rs.getRow();
//	        String s[]= {"��ϵ��ʽ","Ԥ�Ƶ���ʱ��","Ԥ���ͷ�����"};
            if (num == 0) {
                JOptionPane.showMessageDialog(this, "�����ҵ��û�������", "ϵͳ��ʾ", JOptionPane.WARNING_MESSAGE);
            }

            rs.beforeFirst();

            while (rs.next()) {

                String phone = rs.getString("Otel");
                String type = rs.getString("ORtype");
                String date = rs.getString("Otime");
                model.addRow(new Object[]{phone, type, date});
            }


            yd.close();
        } catch (SQLException e2) {
            e2.printStackTrace();
        }

    }
}
