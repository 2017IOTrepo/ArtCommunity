import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class kfcx extends JPanel  implements ActionListener {
	private JTable table;
	DefaultTableModel model;

	/**
	 * Create the panel.
	 */
	public kfcx() {
		this.setLayout(null);
		
		JLabel label_3 = new JLabel("�շ���ѯ");
		label_3.setFont(new Font("����", Font.ITALIC, 14));
		label_3.setBounds(14, 13, 60, 18);
		this.add(label_3);
		
	//�����ݿ��ѯ�շ�	
		JButton b1 = new JButton("��ѯ");
		b1.addActionListener(this);
		b1.setFont(new Font("����", Font.BOLD, 15));
		b1.setBounds(233, 13, 113, 27);
		this.add(b1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(28, 94, 557, 266);
		JTable table = new JTable();
		scrollPane.setViewportView(table);
		model=(DefaultTableModel) table.getModel();    //��ñ��ģ��
		model.setRowCount(0);    //��ձ���е�����
	    model.setColumnIdentifiers(new Object[]{"������","��������"});    //���ñ�ͷ
		add(scrollPane);

	}
		public void actionPerformed(ActionEvent e) {
			
			
		    try {
		    	model.setRowCount(0); 
				Bean yd =new Bean();
		        
		       ResultSet rs= yd.executeQuery( "select Rno,Rtype from Room where Rstate='��' AND ROstate='��'");
		       
		        rs.last();
		        int num=rs.getRow(); 
		        if(num==0) {
		        	JOptionPane.showMessageDialog(this, "���޿շ�", "ϵͳ��ʾ", JOptionPane.WARNING_MESSAGE);
		        }
		        rs.beforeFirst();
		       
		        while(rs.next()) {

		        	String rn=rs.getString("Rno");
		        	String rt=rs.getString("Rtype");
		        	
		        	model.addRow(new Object[] {rn,rt});
		        }
		       
				       

				yd.close();
				}catch(SQLException e2) {
						e2.printStackTrace();
					}
		
		}
		

	
	

	}