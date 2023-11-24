package modelo;
//SE CREA LA CLASE JUGADOR EN EL PAQUETE modelo)
public class Jugador {
	private int id_jugador;
	private String pais;
	private String nombres;
	private String apellidos;
	private String estado;
	private int edad;
	private String posicion;
	
	//Constructores
	public Jugador(){
		
	}
	
	public Jugador(int id_jugador, String pais, String nombres, String apellidos, String estado,int edad,String posicion) {
		
		this.id_jugador=id_jugador;
		this.pais=pais;
		this.nombres=nombres;
		this.apellidos=apellidos;
		this.estado=estado;
		this.edad=edad;
		this.posicion=posicion;
		
	}
	
	
	//getSet_jugador
	public int getId_jugador() {
		return id_jugador;
	}
	public void setId_jugador(int id_jugador) {
		this.id_jugador = id_jugador;
	}
	//getSet_pais	
	public String getPais() {
		return pais;
	}
	public void setPais(String id_pais) {
		this.pais = id_pais;
	}
	//getSet_nombres
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	//getSet_apellidos
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	//getSet_estado
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	//getSet_club
	public String getPosicion() {
		return posicion;
	}
	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}


	//getSet_edad
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	
	
	
}

