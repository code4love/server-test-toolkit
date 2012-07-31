package org.test.toolkit.database;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionFactory {

	private ConnectionFactory() {
	}

	private static ComboPooledDataSource ds = null;

	static {
		try {
			// Logger log = Logger.getLogger("com.mchange"); // ��־
			// log.setLevel(Level.WARNING);
			ds = new ComboPooledDataSource();
			// ����JDBC��Driver��
			ds.setDriverClass("oracle.jdbc.driver.OracleDriver"); // ������ Config
																	// ����������ļ���ȡ
			// ����JDBC��URL
			ds.setJdbcUrl("jdbc:oracle:thin:@192.168.1.134:1521:zhpt");
			// �������ݿ�ĵ�¼�û���
			ds.setUser("scott");
			// �������ݿ�ĵ�¼�û�����
			ds.setPassword("tiger");
			// �������ӳص����������
			ds.setMaxPoolSize(200);
			// �������ӳص���С������
			ds.setMinPoolSize(20);
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
	}

	public static synchronized Connection getConnection() {
		Connection con = null;
		try {
			con = ds.getConnection();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return con;
	}
	// C3P0 end
}
