package com.appmundial.bo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTable;

import com.appmundial.dao.EstadioDAO;
import com.appmundial.db.Conexion;

import modelo.Estadios;

public class EstadioBO {
	
private String mensaje=" ";
private EstadioDAO Edao= new EstadioDAO();


public int estadioID(Estadios estadio) {
	
	Connection conn= Conexion.getConnection();
	int ID=0;
	try {	
		PreparedStatement ps;
		ResultSet rs;
		String sql="SELECT ID_ESTADIO FROM CURSO.estadio"
				+ " where nombre like ? and lugar like ? " ;
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1,estadio.getNombre());
			ps.setString(2,estadio.getLugar());
			
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


public String agregarEstadios(Estadios estadio){
	
	Connection conn= Conexion.getConnection();

	try {
		
		mensaje=Edao.agregarEstadios(conn,estadio);

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

public String modificarEstadios(Estadios estadio){
	
	Connection conn= Conexion.getConnection();
	try {			
		mensaje=Edao.modificarEstadios(conn,estadio);

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

public String eliminarEstadios(Estadios estadio) {
	
	Connection conn= Conexion.getConnection();
	
	try {	
		mensaje=Edao.eliminarEstadios(conn,estadio);
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

public void listarEstadios(JTable tablaBO) {
	Connection conn= Conexion.getConnection();
	Edao.listarEstadios(conn,tablaBO);
	try {
		conn.close();
	}catch(SQLException ex) {
		System.out.println(ex.getMessage());
	}
}
}
