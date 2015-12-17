package controller;

import view.ConfiguracionView;
import model.ConfiguracionModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JOptionPane;
import javax.swing.JTable;

public class ConfiguracionController implements ActionListener,MouseListener,PropertyChangeListener  {
    ConfiguracionModel modelo;
    ConfiguracionView vista;
    
    public ConfiguracionController(ConfiguracionView view,ConfiguracionModel model){
        modelo=model;
        vista=view;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String nombre=e.getActionCommand();
        if(nombre.equals("addRam")){
            modelo.actualizarRam(vista.getDimRam(),vista.getCantRam());
            vista.actualizarRam(modelo.getDimRam(), modelo.getCantRam());
        }
        else if(nombre.equals("resetRam")){
            modelo.nuevoRam();
            vista.actualizarRam(modelo.getDimRam(), modelo.getCantRam());
        }
        else if(nombre.equals("addDisco")){
            modelo.actualizarDisco(vista.getDimDisco(),vista.getCantDisco());
            vista.actualizarDisco(modelo.getDimDisco(), modelo.getCantDisco());
        }
        else if(nombre.equals("resetDisco")){
            modelo.nuevoDisco();
            vista.actualizarDisco(modelo.getDimDisco(), modelo.getCantDisco());
        }
        else if(nombre.equals("Agregar")){
            if(vista.isProcesador()){
                int index=modelo.busqueda(vista.getNumProcesador().getText());
                if(index==-1){
                	modelo.agregarProcesador(vista.getNumProcesador(),vista.getVelProcesador(),vista.getQuantProcesador());
                }
                else{
                	modelo.actualizarProcesador(index,vista.getVelProcesador(),vista.getQuantProcesador());
                }
                vista.actualizarProcesador(modelo.getProcesador());
                vista.setProcesador(String.valueOf(modelo.getContador()+1), "", "");
                vista.getNumProcesador().setEnabled(false);
            }
        }
        else if(nombre.equals("Eliminar")){
            modelo.eliminarProcesador(vista.getNumProcesador(),vista.getVelProcesador(),vista.getQuantProcesador());
            vista.actualizarProcesador(modelo.getProcesador());
            vista.setProcesador(String.valueOf(modelo.getContador()+1), "", "");
            vista.getNumProcesador().setEnabled(false);
        }
        else if(nombre.equals("Limpiar")){
            vista.setProcesador("", "", "");
            vista.disableProcesador();
        }
        else if(nombre.equals("Editar")){
            if(vista.getVelProcesador().getText().equals("")){
                vista.setProcesador(String.valueOf(modelo.getContador()+1), "", "");
            }
            vista.enableProcesador();
            vista.getNumProcesador().setEnabled(false);
            
        }
        else {
            System.out.println(nombre);
        }
    
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        JTable tabla=vista.getTablaProcesadores();
        if(tabla.getValueAt(0,0)!=null){
            int row=tabla.getSelectedRow();
            if(row!=-1){
                vista.setProcesador(String.valueOf(tabla.getValueAt(row,0)), String.valueOf(tabla.getValueAt(row,1)), String.valueOf(tabla.getValueAt(row,2)));
                vista.disableProcesador();
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println(e.getSource());
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println(e.getSource());
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println(e.getSource());
    }

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println(e.getSource());
    }

	@Override
	public void propertyChange(PropertyChangeEvent arg0) {
		System.out.println("hello");
		if(modelo.getError()){
			JOptionPane.showMessageDialog(null, "Persuation");
			modelo.setError();
		}
	}
    
}