package model;

import javax.swing.table.DefaultTableModel;

public class ProcesosModel {
	
	private DefaultTableModel nuevo;
	private DefaultTableModel listo;
	private DefaultTableModel listoSuspendido;
	private DefaultTableModel ejecucion;
	private DefaultTableModel bloqueado;
	private DefaultTableModel bloqueadoSuspendido;
	private DefaultTableModel eliminado;
	
	
	public ProcesosModel(){
		iniciarTablas();
	}
	
	public void iniciarTablas(){
		String [] datos={"N°","Nombre","Ram","Espacio","Prioridad"};
		nuevo=new DefaultTableModel(datos,0);
	}
}
