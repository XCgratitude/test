package com.alibaba.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import org.junit.Test;

import com.alibaba.Bean.User;

public class Test4 {

	@Test
	public void login() throws Exception{
		//ģ���¼����
		Scanner sc = new Scanner(System.in);
		System.out.println("�������û�����");
		String username = sc.nextLine();
		System.out.println("���������룡");
		String password = sc.nextLine();
		//1.ע������
		Class.forName("com.mysql.jdbc.Driver");
		//2.��������
		Connection conn = DriverManager.getConnection("jdbc:mysql:///yideng","root","root");
		//3.�����������ݵĶ���
		Statement stmt = conn.createStatement();
		//4.ִ��sql���
		String sql = "select * from users where username='"+username+"' and password='"+password+"'";
		//5.���ؽ����
		ResultSet rs = stmt.executeQuery(sql);
		if(rs.next()){
			System.out.println("��ӭ��:"+username);
		}else{
			System.out.println("�û������������");
		}
		//�ر���Դ
		conn.close();
		stmt.close();
		rs.close();
	}
}
