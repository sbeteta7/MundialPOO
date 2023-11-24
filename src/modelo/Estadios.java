package modelo;

public class Estadios {
	private int id_estadio;
	private	String nombre;
	private	String lugar;
	private String estado;
	
	public Estadios() {
		
	}
	
	public Estadios(int id_estadio, String nombre, String lugar, String estado) {
		this.id_estadio = id_estadio;
		this.nombre = nombre;
		this.lugar = lugar;
		this.estado= estado;
	}
	
	public int getId_estadio() {
		return id_estadio;
	}


	public void setId_estadio(int id_estadio) {
		this.id_estadio = id_estadio;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getLugar() {
		return lugar;
	}
	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	

}
