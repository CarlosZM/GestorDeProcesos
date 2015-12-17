package controller;

import view.ContenedorView;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;


public class ContenedorController implements ActionListener {
	ContenedorView vista;
    
    public ContenedorController(ContenedorView view){
        vista=view;
    }
    public void actionPerformed(ActionEvent e) {
        String comando=e.getActionCommand();
        if(comando.equals("Salir")){
            System.exit(0);
        }
        else if(comando.equals("Detener")){
            vista.cambio("error");
        }
        else if(comando.equals("Iniciar")){
            vista.cambio("procesos");
        }
        else if(comando.equals("Configuracion")){
            vista.cambio("configuracion");
        }
        else if(comando.equals("Reporte")){
            vista.cambio("error");
        }
        else{
        	System.out.println(comando+"da");
        	Component [] componente=vista.getComponents();
        	System.out.println(componente.length);
        	for(Component component:componente){
        		if(component instanceof JPanel ){
        			System.out.println("lol");
        		}
        	}
        }
    }
}
