package com.appmundial.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.appmundial.bo.PartidosBO;

import modelo.Partidos;

public class PartidosDAO {
	
private String mensaje=" ";
	
	public int partidosID(Connection con, Partidos partido) {
		PreparedStatement ps;
		ResultSet rs;
		String sql="SELECT ID_PARTIDO FROM CURSO.PARTIDOS"
				+ " where f_pais like ? and s_pais like ? and fecha_partido like ?  and fase like ?  " ;
		int ID = 0;
		
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1,partido.getF_pais());
			ps.setInt(2,partido.getS_pais());
			ps.setDate(3,partido.getFecha_partido());
			ps.setInt(4,partido.getId_fase());
			
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
		}
	

	public String agregarPartidos(Connection con, Partidos partido){
		CallableStatement cs;
		
		try {
			cs=con.prepareCall("{call curso.ingresarPartidos(?,?,?,?,?,?,?,?,?)}");
			
			PartidosBO MatchBO = new PartidosBO();
			
			
			cs.setInt(1,partido.getId_estadio());
			cs.setInt(2,partido.getId_arbitro());
			cs.setInt(3,partido.getF_pais());
			cs.setInt(4,partido.getS_pais());
			cs.setDate(5,partido.getFecha_partido());
			cs.setInt(6,partido.getId_fase());
			cs.setString(7, partido.getEstado());
			cs.setInt(8, partido.getG_f_pais());
			cs.setInt(9, partido.getG_s_pais());
			
			cs.execute();
			mensaje="Agregado correctamente";
			cs.close();
			con.close();
		}catch(Exception e) {
			mensaje="Error. No se ha agregado \n"+ e.getMessage(); 
			e.printStackTrace();
		}
			
		
	
	return mensaje;
	}
	
	public String modificarPartidos(Connection con,Partidos partido){
		
		CallableStatement cs;
		try {
		cs=con.prepareCall("{call curso.modificarPartidos(?,?,?,?,?,?,?,?,?)}");
		
		PartidosBO MatchBO = new PartidosBO();
		
		
		cs.setInt(1,partido.getId_estadio());
		cs.setInt(2,partido.getId_arbitro());
		cs.setInt(3,partido.getF_pais());
		cs.setInt(4,partido.getS_pais());
		cs.setDate(5,partido.getFecha_partido());
		cs.setInt(6,partido.getId_fase());
		cs.setString(7, partido.getEstado());
		cs.setInt(8, partido.getG_f_pais());
		cs.setInt(9, partido.getG_s_pais());
		cs.setInt(10,partido.getId_partido() );
		
			cs.execute();
			cs.close();
		}catch(SQLException e) {
			mensaje="Error. No se ha modificado \n"+ e.getMessage();  
		}
		
		return mensaje;
		
	}
	
	public String eliminarPartidos(Connection con,Partidos partido) {
		
		CallableStatement cs;
		try {
		cs=con.prepareCall("{call curso.eliminarPartidos(?)}");
		
		PartidosBO MatchBO = new PartidosBO();
		
		cs.setInt(1,partido.getId_partido() );
			cs.execute();
			cs.close();
		}catch(SQLException e) {
			mensaje="Error. No se ha modificado \n"+ e.getMessage();  
		}
		
		return mensaje;
	}
	
	public void listarPartidos(Connection con, JTable tabla) {
		
		DefaultTableModel modeltbmatch;
		String [] columnas= {"Primer equipo","Segundo equipo","Grupo","Fase","Fecha","Arbitro","Estadio","Lugar"};
		modeltbmatch = new DefaultTableModel(null,columnas); //crear modelo para la tabla
		String sql = "select \"Primer equipo\",\"Segundo equipo\",grupo,fase,fecha,arbitro,Estadio, lugar"
				+ " from curso.vista_partido order by fecha, grupo";
		
		String [] filas=new String[9];
		Statement st=null; 
		ResultSet rs=null;
		try {
				st=con.createStatement();
				rs=st.executeQuery(sql);
				//insertar los valores del array en cada fila
				while(rs.next()) {
					for(int i=0;i<8;i++) {
					filas[i]=rs.getString(i+1);
					}
					modeltbmatch.addRow(filas); 
				}
				//asignarle el modelo a la tabla
				tabla.setModel(modeltbmatch);
				st.close();
				
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null,"No se puede listar");
		}

	}

}


