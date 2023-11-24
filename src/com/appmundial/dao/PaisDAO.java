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

import com.appmundial.bo.JugadorBO;
import com.appmundial.bo.PaisBO;

import modelo.Pais;



public class PaisDAO {

private String mensaje=" ";


	

	public String agregarPais(Connection con, Pais pais){
		CallableStatement cs;
		
		try {
			cs=con.prepareCall("{call curso.ingresarPaises(?,?,?)}");
			
			PaisBO Pbo = new PaisBO();
			

			cs.setString(1,pais.getNombre());
			cs.setString(2,pais.getGrupo());
			cs.setString(3,pais.getEstado());
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
	
	public String modificarPais(Connection con,Pais pais){
		
		CallableStatement cs;
		
		try {
			cs=con.prepareCall("{call curso.modificarPaises(?,?,?,?)}");
			
			PaisBO Pbo = new PaisBO();
			
			
			cs.setString(1,pais.getNombre());
			cs.setString(2,pais.getGrupo());
			cs.setString(3,pais.getEstado());
			cs.setInt(4,Pbo.paisID(pais));
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
	
	public String eliminarPais(Connection con,Pais pais) {
		
		CallableStatement cs;
		try {
			cs=con.prepareCall("{call curso.eliminarPaises(?)}");
			cs.setInt(1,pais.getIdPais());
			mensaje="Eliminado correctamente";
			cs.execute();
			cs.close();
			con.close();
			
		}catch(SQLException e) {
			mensaje="Error. No se ha eliminado \n"+ e.getMessage();  
		}
		return mensaje;
	}
	
	public void listarPais(Connection con, JTable tabla) {
		
		DefaultTableModel modeltbp;
		String [] columnas= {"NOMBRE","GRUPO","ESTADO"};
		modeltbp = new DefaultTableModel(null,columnas); //crear modelo para la tabla
		String sql = "select NOMBRE, GRUPO, ESTADO FROM CURSO.PAIS ORDER BY GRUPO,NOMBRE";
		
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
					modeltbp.addRow(filas); 
				}
				//asignarle el modelo a la tabla
				tabla.setModel(modeltbp);
				st.close();
				
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null,"No se puede listar");
		}

	}
	
}
