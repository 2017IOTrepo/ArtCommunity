import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class lsxxtj extends JPanel implements ActionListener {
    private JTextField textField;
    private JTable table;
    DefaultTableModel model;

    /**
     * Create the panel.
     */
    public lsxxtj() {
        setLayout(null);

        JLabel label = new JLabel("��ʷ��ѯ");
        label.setFont(new Font("����", Font.ITALIC, 14));
        label.setBounds(14, 13, 60, 18);
        add(label);

        JLabel label_1 = new JLabel("�����뷿����");
        label_1.setBounds(81, 81, 105, 18);
        add(label_1);

        textField = new JTextField();
        textField.setBounds(200, 78, 86, 24);
        add(textField);
        textField.setColumns(10);

        //��ѯ���ݿ�
        JButton b1 = new JButton("��ѯ");
        b1.addActionListener(this);
        b1.setFont(new Font("����", Font.BOLD, 15));
        b1.setBounds(233, 13, 113, 27);
        this.add(b1);


        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(81, 173, 359, 152);
        JTable table = new JTable();
        scrollPane.setViewportView(table);
        model = (DefaultTableModel) table.getModel();    //��ñ��ģ��
        model.setRowCount(0);    //��ձ���е�����
        model.setColumnIdentifiers(new Object[]{"���", "����", "֤����", "����ʱ��", "���ʱ��", "������", "����������"});    //���ñ�ͷ
        add(scrollPane);
    }

    public void actionPerformed(ActionEvent e) {


        try {
            model.setRowCount(0);
            Bean zs = new Bean();

            ResultSet rs = zs.executeQuery("select * from history");

            rs.last();
            int num = rs.getRow();
            if (num == 0) {
                JOptionPane.showMessageDialog(this, "������ʷ��Ϣ", "ϵͳ��ʾ", JOptionPane.WARNING_MESSAGE);
            }
            rs.beforeFirst();

            while (rs.next()) {
                String Hno = rs.getString("Hno");
                String HCname = rs.getString("HCname");
                String HCid = rs.getString("HCid");
                String Hatime = rs.getString("Hatime");
                String Hltime = rs.getString("Hltime");
                String Hmon = rs.getString("Hmon");
                String HMname = rs.getString("HMname");
                model.addRow(new Object[]{Hno, HCname, HCid, Hatime, Hltime, Hmon, HMname});
            }


            zs.close();
        } catch (SQLException e2) {
            e2.printStackTrace();
        }

    }

}
