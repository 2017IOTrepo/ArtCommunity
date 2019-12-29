import java.sql.Connection;
import java.sql.Statement;
import java.sql.*;

public class Bean {
	 	private static final String driverStr = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	    private static final String connStr = "jdbc:sqlserver://localhost\\SQLEXPRESS:1433;DatabaseName=Hotel";
	    private static final String dbusername = "sa";
	    private static final String dbpassword = "dxq1997";
	    private static Connection conn = null;
	    private Statement stmt = null;
	    public Bean()
	    {
	        try
	        {
	            Class.forName(driverStr);
	            conn = DriverManager.getConnection("jdbc:sqlserver://localhost\\SQLEXPRESS:1433;DatabaseName=Hotel","sa", "dxq1997");
	            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
	            System.out.println("�������ӳɹ�");
	        } 
	        catch (Exception ex) {
	            ex.printStackTrace();
	        	System.out.println(ex.getMessage());
	            System.out.println("��������ʧ��");
	        } 
	        
	    }

	    public int executeUpdate(String s) {
	        int result = 0;
	        System.out.println("--�������:"+s+"\n");
	        try {
	            result = stmt.executeUpdate(s);
	        } catch (Exception ex) {
	            System.out.println("ִ�и��´���");
	        }
	        return result;
	    }

	    public ResultSet executeQuery(String s) {
	        ResultSet rs = null;
	        System.out.print("--��ѯ���:"+s+"\n");
	        try {
	            rs = stmt.executeQuery(s);
	            System.out.println("ִ�в�ѯ�ɹ���");
	        } catch (Exception ex) {
	            System.out.println("ִ�в�ѯ����");
	        }
	        return rs;
	    }
	    public void execQuery(String s){
	    	System.out.print("--�������:"+s+"\n");
	        try {
	            stmt.executeUpdate(s);
	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            System.out.println("ִ�в������");
	        }
	    }
	    
	    
	    public static Connection getConnection() throws Exception
	    {
	    	if(conn==null)
	    	{
	    		conn=DriverManager.getConnection(connStr, dbusername, dbpassword);
	    		return conn;
	    	}
	    	return conn;
	    }
	    
	    public void close() {
	        try {
	            stmt.close();
	            conn.close();
	        } catch (Exception e) {
	        }
	    }
	}