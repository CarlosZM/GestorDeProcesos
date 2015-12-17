package view;


import java.awt.CardLayout;
import java.awt.Component;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controller.ProcesoController;

public class ProcesosView extends JPanel{
	private JProgressBar barraRam,barraDisco;
    private JLabel usoRam,usoDisco;
    private JPanel procesos;
    private JTabbedPane panelInicio;
    private CardLayout cambiosInicio;
    private JTextField nombreAgregar,nombreEliminar;
    private JTable inicio;	
    public ProcesosView(){
        vistaBarras();	
        vistaDiagrama();
    }
    public void vistaBarras(){
        vistaRam();
        vistaDisco();
        vistaProcesos();
    }
    public void vistaDiagrama(){
        /*
        	
        }*/
    	String [] datos={"N°","Nombre","Ram","Espacio","Prioridad"};
    	DefaultTableModel modelo=new DefaultTableModel(datos,0);
    	inicio=new JTable(modelo);
    	JScrollPane scroll=new JScrollPane(inicio);
    	
    	
    	panelInicio=new JTabbedPane();
    	for(int i=0;i<5;i++){
    		panelInicio.addTab("Error"+i,new JScrollPane(new JTable(new DefaultTableModel(datos,0))));
    	}
    	this.add(panelInicio);
    }
    public void vistaRam(){
        JPanel ram=new JPanel();
        ram.setBorder(javax.swing.BorderFactory.createTitledBorder("Uso de la RAM"));
        barraRam= new JProgressBar(0, 100);
        barraRam.setStringPainted(true);
        ram.add(barraRam);
        usoRam=new JLabel("0/1024.0 Kb");
        ram.add(usoRam);
        add(ram);
    }
    public void vistaDisco(){
        JPanel disco=new JPanel();
        disco.setBorder(javax.swing.BorderFactory.createTitledBorder("Uso del Disco"));
        barraDisco= new JProgressBar(0, 100);
        barraDisco.setStringPainted(true);
        disco.add(barraDisco);
        usoDisco=new JLabel("0/1024.0 Kb");	
        disco.add(usoDisco);
        add(disco);
    }
    public void vistaProcesos(){
    	procesos=new JPanel();
    	procesos.setBorder(javax.swing.BorderFactory.createTitledBorder("Opciones de procesos"));
    	JLabel nombre=new JLabel("Nombre del nuevo Proceso:");
    	procesos.add(nombre);	
    	nombreAgregar=new JTextField(10);
    	procesos.add(nombreAgregar);
    	JButton agregarProceso=new JButton("Agregar");
    	procesos.add(agregarProceso);
    	JLabel namae=new JLabel("Nombre del Proceso a eliminar:");
    	procesos.add(namae);
    	nombreEliminar=new JTextField(10);
    	procesos.add(nombreEliminar);
    	JButton  eliminarProceso=new JButton("Eliminar");
    	procesos.add(eliminarProceso);
    	add(procesos);
    }

    public void registrarListener(ProcesoController control) {
    	Component[] componentes =procesos.getComponents();
        for (Component componente : componentes) {
            if(componente instanceof AbstractButton){
                AbstractButton boton=(AbstractButton)componente;
                boton.addActionListener(control);
            }
        }
    }
    
}
