package classes;

public class Proceso {
	private int UID;
	private String nombre;
	private double pesoRam;
	private double pesoDisco;
	private int prioridad;
	private double tiempoSuspendido;
	private double tiempoOperacion;
	
	public Proceso(int identificador,int priority,String name,Double weightRam,Double weightDisco){
		UID=identificador;
		prioridad=priority;
		nombre=name;
		pesoRam=weightRam;
		pesoDisco=weightDisco;
		tiempoSuspendido=0.0;
		tiempoOperacion=0.0;
	}
	public void addTiempoSuspendido(Double tiempo){
		tiempoSuspendido+=tiempo;
	}
	public void addTiempoOperacion(Double tiempo){
		tiempoOperacion+=tiempo;
	}
	public Double getPesoRam(){
		return pesoRam;
	}
	public Double getPesoDisco(){
		return pesoDisco;
	}
	public Double getTiempoSuspendido(){
		return tiempoSuspendido;
	}
	public Double getTiempoOperacion(){
		return tiempoOperacion;
	}
	public String getNombre(){
		return nombre;
	}
	
}
