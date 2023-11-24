//EL PAQUETE DAO TIENE COMO CLASE JugadorDAO
//CONTIENE LOS METODOS DONDE SE REALIZA LAS CONSULTAS SQL
package com.appmundial.dao;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import com.appmundial.bo.JugadorBO;
import modelo.Jugador;

public class JugadorDAO {
	private String mensaje=" ";
	
	public String agregarJugador(Connection con, Jugador jugador){
		CallableStatement cs;	
		
		try {
			cs=con.prepareCall("{call curso.ingresarjugadores(?,?,?,?,?,?)}");
			
			JugadorBO Jbo = new JugadorBO();
			
			cs.setInt(1,Jbo.paisID(jugador));
			cs.setString(2,jugador.getNombres());
			cs.setString(3,jugador.getApellidos());
			cs.setString(4,jugador.getEstado());
			cs.setInt(5,jugador.getEdad());
			cs.setString(6,jugador.getPosicion());
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

	
	public String modificarJugador(Connection con,Jugador jugador){
		
		CallableStatement cs;
		
		try {
			cs=con.prepareCall("{call curso.modificarJugadores(?,?,?,?,?,?,?)}");
			
			JugadorBO Jbo = new JugadorBO();
			
			cs.setInt(1,Jbo.paisID(jugador));
			cs.setString(2,jugador.getNombres());
			cs.setString(3,jugador.getApellidos());
			cs.setString(4,jugador.getEstado());
			cs.setInt(5,jugador.getEdad());
			cs.setString(6,jugador.getPosicion());
			cs.setInt(7, jugador.getId_jugador());
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
	
	public String eliminarJugador(Connection con,Jugador jugador) {
		
		CallableStatement cs;
		
		try {
			cs=con.prepareCall("{call curso.eliminarJugadores(?)}");
			
			JugadorBO Jbo = new JugadorBO();
			cs.setInt(1,jugador.getId_jugador());
			mensaje="Eliminado correctamente";
			cs.execute();
			cs.close();
			con.close();

		}catch(SQLException e) {
			mensaje="Error. No se ha eliminado \n"+ e.getMessage();  
		}
		return mensaje;
	}
	
	public void listarJugador(Connection con, JTable tabla) {
		
		DefaultTableModel modeltbj;
		String [] columnas= {"PAIS","NOMBRES","APELLIDOS","ESTADO","EDAD","POSICION"};
		modeltbj = new DefaultTableModel(null,columnas); //crear modelo para la tabla
		String sql = "select pais,nombres,apellidos,estado,edad,posicion from curso.vista_jugador order by pais,edad";
		
		String [] filas=new String[6];
		Statement st=null; 
		ResultSet rs=null;
		try {
				st=con.createStatement();
				rs=st.executeQuery(sql);
				//insertar los valores del array en cada fila
				while(rs.next()) {
					for(int i=0;i<6;i++) {
					filas[i]=rs.getString(i+1);
					}
					modeltbj.addRow(filas); 
				}
				//asignarle el modelo a la tabla
				tabla.setModel(modeltbj);
				st.close();
				
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null,"No se puede listar");
		}

	}
	


}
