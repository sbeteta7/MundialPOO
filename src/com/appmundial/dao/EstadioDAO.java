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

import com.appmundial.bo.EstadioBO;
import com.appmundial.bo.PaisBO;

import modelo.Estadios;


public class EstadioDAO {
private String mensaje=" ";

	public String agregarEstadios(Connection con, Estadios estadio){
		CallableStatement cs;
		
		try {
			cs=con.prepareCall("{call curso.ingresarEstadios(?,?,?)}");
			
			EstadioBO Ebo = new EstadioBO();
			

			cs.setString(1,estadio.getNombre());
			cs.setString(2,estadio.getLugar());
			cs.setString(3,estadio.getEstado());
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
	
	public String modificarEstadios(Connection con,Estadios estadio){
		
		CallableStatement cs;
		
		try {
			cs=con.prepareCall("{call curso.modificarEstadios(?,?,?,?)}");
			
			EstadioBO Ebo = new EstadioBO();
			
			
			cs.setString(1,estadio.getNombre());
			cs.setString(2,estadio.getLugar());
			cs.setString(3,estadio.getEstado());
			cs.setInt(4,Ebo.estadioID(estadio));
			cs.execute();
			con.close();
			mensaje="Modificado correctamente";
			cs.close();
			con.close();
		}catch(Exception e) {
			mensaje="Error. No se ha modificado \n"+ e.getMessage(); 
			e.printStackTrace();
		}
		return mensaje;
		
	}
	
	public String eliminarEstadios(Connection con,Estadios estadio) {
		
		PreparedStatement ps;
		String sql= "DELETE FROM CURSO.ESTADIO where id_estadio=?" ;
		
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1,estadio.getId_estadio());
			mensaje="Eliminado correctamente";
			ps.execute();
			ps.close();
		}catch(SQLException e) {
			mensaje="Error. No se ha eliminado \n"+ e.getMessage();  
		}
		return mensaje;
	}
	
	public void listarEstadios(Connection con, JTable tabla) {
		
		DefaultTableModel modeltbe;
		String [] columnas= {"NOMBRE","LUGAR","ESTADO"};
		modeltbe = new DefaultTableModel(null,columnas); //crear modelo para la tabla
		String sql = "select NOMBRE, LUGAR, ESTADO FROM CURSO.estadio ORDER BY NOMBRE";
		
		String [] filas=new String[4];
		Statement st=null; 
		ResultSet rs=null;
		try {
				st=con.createStatement();
				rs=st.executeQuery(sql);
				//insertar los valores del array en cada fila
				while(rs.next()) {
					for(int i=0;i<3;i++) {
					filas[i]=rs.getString(i+1);
					}
					modeltbe.addRow(filas); 
				}
				//asignarle el modelo a la tabla
				tabla.setModel(modeltbe);
				st.close();
				
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null,"No se puede listar");
		}

	}

}
