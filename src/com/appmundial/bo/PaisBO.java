package com.appmundial.bo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTable;
import com.appmundial.dao.PaisDAO;
import com.appmundial.db.Conexion;
import modelo.Pais;

public class PaisBO {
	
private String mensaje=" ";
private PaisDAO Pdao= new PaisDAO();


public int paisID(Pais pais) {
	
	Connection conn= Conexion.getConnection();
	int ID=0;
	try {	
		PreparedStatement ps;
		ResultSet rs;
		String sql="SELECT ID_PAIS FROM CURSO.PAIS"
				+ " where nombre like ? and grupo like ? " ;
		
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1,pais.getNombre());
			ps.setString(2,pais.getGrupo());
			
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




public String agregarPais(Pais pais){
	
	Connection conn= Conexion.getConnection();

	try {
		
		mensaje=Pdao.agregarPais(conn,pais);

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

public String modificarPais(Pais pais){
	
	Connection conn= Conexion.getConnection();
	try {			
		mensaje=Pdao.modificarPais(conn,pais);

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

public String eliminarPais(Pais pais) {
	
	Connection conn= Conexion.getConnection();
	
	try {	
		mensaje=Pdao.eliminarPais(conn,pais);
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

public void listarPais(JTable tablaBO) {
	Connection conn= Conexion.getConnection();
	Pdao.listarPais(conn,tablaBO);
	try {
		conn.close();
	}catch(SQLException ex) {
		System.out.println(ex.getMessage());
	}
}
}
