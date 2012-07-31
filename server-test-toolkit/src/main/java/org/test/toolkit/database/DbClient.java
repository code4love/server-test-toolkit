package org.test.toolkit.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbClient {
	public static void main(String[] args) {
		boolean flag = false;
		// �ڴ˴��ɾ�������ݿ���֤

		// ����һ�����ݿ��������
		PreparedStatement pstmt = null;
		// ����һ�����������
		ResultSet rs = null;
		// ����һ��SQL���������ڱ���SQL���
		String sql = null;
		// DataBaseConnectionΪ��������ݿ����Ӽ��رղ�����
		Connection con = null;
		// �������ݿ�
		con = ConnectionFactory.getConnection();

		// ��дSQL���
		sql = "SELECT u_name,u_password FROM nwvideo.n_user WHERE u_name=? and u_password=?";
		try {
			// ʵ�������ݿ��������
			pstmt = con.prepareStatement(sql);

			System.out.println("���������ѱ�ʵ����");

			// ����pstmt�����ݣ��ǰ�ID��������֤
			pstmt.setString(1, "limeng");
			pstmt.setString(2, "limeng");

			System.out.println("���username,password");

			// ��ѯ��¼
			rs = pstmt.executeQuery();
			System.out.println("ִ�в�ѯ���");
			// �ж��Ƿ��м�¼
			if (rs.next()) {
				// ����м�¼����ִ�д˶δ���
				// �û��ǺϷ��ģ����Ե�½
				flag = true;

				System.out.println("�û��Ϸ�");
			}
			// ���ιر�

			rs.close();
			pstmt.close();

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			// ���һ��Ҫ��֤���ݿ��ѱ��ر�
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}