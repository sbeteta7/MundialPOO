package com.appmundial.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Conexion {
	
	private static java.sql.Connection conn=null;
	private static  String login="system";
	private static String clave="system";
	private static String url="jdbc:oracle:thin:@localhost:1521:xe";
	
	


	
	public static Connection getConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url,login,clave);
			if(conn != null) {
				System.out.println("Conexion Exitosa");
			}else {
				System.out.println("Conexion es errónea");
			}
			
		} catch (ClassNotFoundException | SQLException e ) {
			JOptionPane.showMessageDialog(null,"Conexion Erronea" +" "+ e.getMessage());
			
		}
		
		return conn;
	}
	
	public void desconexion() {
		try {
			conn.close();
		} catch (Exception e) 
		{
			System.out.println("Error al desconectar"+e.getMessage());
		}	
	}
	
	public static void main(String[] args) {
		Conexion c=new Conexion();
		c.getConnection();
	}
	
	
	}
