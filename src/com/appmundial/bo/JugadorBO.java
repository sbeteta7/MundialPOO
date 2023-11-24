package com.appmundial.bo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTable;

import com.appmundial.dao.JugadorDAO;
import com.appmundial.db.Conexion;

import modelo.Jugador;

public class JugadorBO {
	
	private String mensaje=" ";
	private JugadorDAO Jdao= new JugadorDAO();
	
	
	public int jugadorID(Jugador jugador) {
		
		Connection conn= Conexion.getConnection();
		int ID = 0;
		try {		
			JugadorBO Jbo = new JugadorBO();
			PreparedStatement ps;
			ResultSet rs;
			String sql="SELECT ID_JUGADOR FROM CURSO.JUGADORES"
					+ " where nombres like ? and apellidos like ? and edad like ?  and posicion like ?  " ;
			try {
				ps=conn.prepareStatement(sql);
				ps.setString(1,jugador.getNombres());
				ps.setString(2,jugador.getApellidos());
				ps.setInt(3,jugador.getEdad());
				ps.setString(4,jugador.getPosicion());
				
				rs=ps.executeQuery();
				while(rs.next()) {
					ID=rs.getInt(1);
				}
				
				
				System.out.println("ID encontrado");
				ps.execute();
				ps.close();
			}catch(SQLException e) {
				System.out.println("Error. No se ha eencontrado ID \n"+ e.getMessage()); 
			}
			
			
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
	
	
	public int paisID(Jugador jugador) {
		Connection conn= Conexion.getConnection();
		int ID=0;
		try {	
			PreparedStatement ps;
			ResultSet rs;
			String sql="select id_pais from curso.vista_jugador where pais=upper(?) group by id_pais";
			try {
				ps=conn.prepareStatement(sql);
				ps.setString(1,jugador.getPais());
				
				rs=ps.executeQuery();
				while(rs.next()) {
					ID=rs.getInt(1);
				}
				
				
				System.out.println("ID encontrado");
				ps.execute();
				ps.close();
			}catch(SQLException e) {
				System.out.println("Error. No se ha eencontrado ID \n"+ e.getMessage()); 
			}
				return ID;
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
	
	
	
	
	public String agregarJugador(Jugador jugador){
		
		Connection conn= Conexion.getConnection();
	
		try {
			mensaje=Jdao.agregarJugador(conn,jugador);

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
	
	public String modificarJugador(Jugador jugador){
		
		Connection conn= Conexion.getConnection();
		try {			
			mensaje=Jdao.modificarJugador(conn,jugador);

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
	
	public String eliminarJugador(Jugador jugador) {
		
		Connection conn= Conexion.getConnection();
		
		try {	
			mensaje=Jdao.eliminarJugador(conn,jugador);
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
	
	public void listarJugador(JTable tablaBO) {
		Connection conn= Conexion.getConnection();
		Jdao.listarJugador(conn,tablaBO);
		try {
			conn.close();
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	
}
