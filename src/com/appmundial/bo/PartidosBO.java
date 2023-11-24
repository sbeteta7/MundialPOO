	package com.appmundial.bo;

import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JTable;


import com.appmundial.dao.PartidosDAO;
import com.appmundial.db.Conexion;

import modelo.Partidos;


public class PartidosBO {
	private String mensaje=" ";
	private PartidosDAO Matchdao= new PartidosDAO();
	
	
	public int partidosID(Partidos partido) {
		
		Connection conn= Conexion.getConnection();
		int ID=0;
		try {	
			ID= Matchdao.partidosID(conn,partido);
		}catch(Exception e) {
			mensaje=mensaje+" "+e.getMessage();
		}finally {
			try {
				if(conn!=null) {
					conn.close();
				}
			}catch (Exception e){
				mensaje=mensaje+" "+e.getMessage();
			}
		}
		return ID;
	}
	
	
	
	
	public String agregarPartidos(Partidos partido){
		
		Connection conn= Conexion.getConnection();
	
		try {
			
			mensaje=Matchdao.agregarPartidos(conn,partido);

		}catch(Exception e) {
			mensaje=mensaje+" "+e.getMessage();
		}finally {
			try {
				if(conn!=null) {
					conn.close();
				}
			}catch (Exception e){
				mensaje=mensaje+" "+e.getMessage();
			}
		}
		return mensaje;
		
	}
	
	public String modificarPartidos(Partidos partido){
		
		Connection conn= Conexion.getConnection();
		try {			
			mensaje=Matchdao.modificarPartidos(conn,partido);

		}catch(Exception e) {
			mensaje=mensaje+" "+e.getMessage();
		}finally {
			try {
				if(conn!=null) {
					conn.close();
				}
			}catch (Exception e){
				mensaje=mensaje+" "+e.getMessage();
			}
		}
		return mensaje;
	}
	
	public String eliminarPartidos(Partidos jugador) {
		
		Connection conn= Conexion.getConnection();
		
		try {	
			mensaje=Matchdao.eliminarPartidos(conn,jugador);
		}catch(Exception e) {
			mensaje=mensaje+" "+e.getMessage();
		}finally {
			try {
				if(conn!=null) {
					conn.close();
				}
			}catch (Exception e){
				mensaje=mensaje+" "+e.getMessage();
			}
		}
		return mensaje;
	}
	
	public void listarPartidos(JTable tablaBO) {
		Connection conn= Conexion.getConnection();
		Matchdao.listarPartidos(conn,tablaBO);
		try {
			conn.close();
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
	}
}
