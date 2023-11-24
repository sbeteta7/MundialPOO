package modelo;

public class Pais {
	private int idPais;
	private String Nombre;
	private String Grupo;
	private String Estado;
	
	public Pais() {
		
	}
	
	public Pais(int idPais, String nombre,String grupo, String estado) {
		this.idPais=idPais;
		this.Nombre=nombre;
		this.Grupo=grupo;
		this.Estado=estado;
		
	}


	public int getIdPais() {
		return idPais;
	}


	public void setIdPais(int idPais) {
		this.idPais = idPais;
	}


	public String getNombre() {
		return Nombre;
	}


	public void setNombre(String nombre) {
		Nombre = nombre;
	}


	public String getGrupo() {
		return Grupo;
	}


	public void setGrupo(String grupo) {
		Grupo = grupo;
	}


	public String getEstado() {
		return Estado;
	}


	public void setEstado(String estado) {
		Estado = estado;
	}
}
