package controller;

import view.ProcesosView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.ProcesosModel;

public class ProcesoController implements ActionListener{
	ProcesosView vista;
	ProcesosModel modelo;
	
	public ProcesoController(ProcesosModel model,ProcesosView view){
		vista=view;
		modelo=model;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand());
	}
}
