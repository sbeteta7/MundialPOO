package modelo;

import java.sql.Date;

public class Partidos {
	
	private int id_partido ;
	private  int id_estadio;
	private  int id_arbitro;
	private  int f_pais;
	private  int s_pais;
	private  Date fecha_partido;
	private  int id_fase;
	private  String estado;
	private  int g_f_pais;
	private  int g_s_pais;
	private  int id_gol;
	private  int id_goleador;
	private  int id_asistidor;
	private  int minuto;
	private int distancia;
	
	
	//Constructor partidos
	public Partidos(int id_partido, int id_estadio, int id_arbitro, int f_pais, int s_pais, Date fecha_partido,
			int fase, String estado, int g_f_pais, int g_s_pais) {
		super();
		this.id_partido = id_partido;
		this.id_estadio = id_estadio;
		this.id_arbitro = id_arbitro;
		this.f_pais = f_pais;
		this.s_pais = s_pais;
		this.fecha_partido = fecha_partido;
		this.id_fase = fase;
		this.estado = estado;
		this.g_f_pais = g_f_pais;
		this.g_s_pais = g_s_pais;
	}

	//Constructor gol

	public Partidos(int id_gol, int id_goleador, int id_asistidor, int minuto, int distancia) {
		super();
		this.id_gol = id_gol;
		this.id_goleador = id_goleador;
		this.id_asistidor = id_asistidor;
		this.minuto = minuto;
		this.distancia = distancia;
	}


	public int getId_partido() {
		return id_partido;
	}
	public void setId_partido(int id_partido) {
		this.id_partido = id_partido;
	}
	public int getId_estadio() {
		return id_estadio;
	}
	public void setId_estadio(int id_estadio) {
		this.id_estadio = id_estadio;
	}
	public int getId_arbitro() {
		return id_arbitro;
	}
	public void setId_arbitro(int id_arbitro) {
		this.id_arbitro = id_arbitro;
	}
	public int getF_pais() {
		return f_pais;
	}
	public void setF_pais(int f_pais) {
		this.f_pais = f_pais;
	}
	public Date getFecha_partido() {
		return fecha_partido;
	}
	public void setFecha_partido(Date fecha_partido) {
		this.fecha_partido = fecha_partido;
	}
	public int getS_pais() {
		return s_pais;
	}
	public void setS_pais(int s_pais) {
		this.s_pais = s_pais;
	}
	public int getId_fase() {
		return id_fase;
	}
	public void setId_fase(int fase) {
		this.id_fase = fase;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public int getG_f_pais() {
		return g_f_pais;
	}
	public void setG_f_pais(int g_f_pais) {
		this.g_f_pais = g_f_pais;
	}
	public int getG_s_pais() {
		return g_s_pais;
	}
	public void setG_s_pais(int g_s_pais) {
		this.g_s_pais = g_s_pais;
	}
	public int getId_gol() {
		return id_gol;
	}
	public void setId_gol(int id_gol) {
		this.id_gol = id_gol;
	}
	public int getId_goleador() {
		return id_goleador;
	}
	public void setId_goleador(int id_goleador) {
		this.id_goleador = id_goleador;
	}
	public int getId_asistidor() {
		return id_asistidor;
	}
	public void setId_asistidor(int id_asistidor) {
		this.id_asistidor = id_asistidor;
	}
	public int getMinuto() {
		return minuto;
	}
	public void setMinuto(int minuto) {
		this.minuto = minuto;
	}
	public int getDistancia() {
		return distancia;
	}
	public void setDistancia(int distancia) {
		this.distancia = distancia;
	}

}
