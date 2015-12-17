package model;

import classes.Hardware_Sensible;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class ConfiguracionModel {
    private Hardware_Sensible ram;
    private Hardware_Sensible disco;
    public String mostrarRam;
    public String mostrarDisco;
    private int contador;
    private DefaultTableModel procesos;
    private boolean error;
    private String mensaje;
    
    
    public ConfiguracionModel(){
        nuevoDisco();
        nuevoRam();
        nuevoProc();
        error=false;
    }
    public void nuevoProc(){
        String [] nombres={"N°","Velocidad","Quantum"};
        contador=0;
        procesos=new DefaultTableModel(nombres, 0){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };;
    }
    public void nuevoDisco(){
        disco=new Hardware_Sensible("Disco");
        mostrarDisco=disco.tamano();
    }
    public void nuevoRam(){
        ram=new Hardware_Sensible("Ram");
        mostrarRam=ram.tamano();
    }
    public void actualizarRam(String medida,double cant){
        ram.actualizar(medida, cant);
        mostrarRam=ram.tamano();
    }
    public void actualizarDisco(String medida,double cant){
        disco.actualizar(medida, cant);
        mostrarRam=disco.tamano();
    }
    public int getContador(){
        return contador;
    }
    public Double getCantRam(){
        return ram.getCantidad();
    }
    public String getDimRam(){
        return ram.getMedida();
    }
    public Double getCantDisco(){
        return disco.getCantidad();
    }
    public String getDimDisco(){
        return disco.getMedida();
    }
    public DefaultTableModel getProcesador(){
        return procesos;
    }
    public boolean getError(){
    	return error;
    }
    public void setError(){
    	error=false;
    }

    public void agregarProcesador(JTextField numProcesador, JTextField velProcesador, JTextField quantProcesador) {
        try{
            int dato=Integer.parseInt(numProcesador.getText());
            double dato1=Double.parseDouble(velProcesador.getText());
            int dato2=Integer.parseInt(quantProcesador.getText());
            Object [] agregar= {dato,dato1,dato2};
            procesos.addRow(agregar);
            contador++;
        }
        catch(NumberFormatException ex){
            error=true;
            mensaje="Se ingresaron letras o caracteres diferentes a los numeros";
        }
    }
    public void actualizarProcesador(int indice,JTextField velProcesador, JTextField qantProcesador){
    	procesos.setValueAt(velProcesador.getText(), indice, 1);
    	procesos.setValueAt(qantProcesador.getText(), indice, 2);
    }
    public int busqueda(String numeracion){
        int dim=procesos.getRowCount();
        for(int i =0;i<dim;i++){
            if(numeracion.equals(String.valueOf(procesos.getValueAt(i,0)))){
                return i;
            }
        }
        return -1;
    }
    public void eliminarProcesador(JTextField numProcesador, JTextField velProcesador, JTextField quantProcesador){
        try{
            int row=busqueda(numProcesador.getText());
            if(velProcesador.getText().equals(procesos.getValueAt(row, 1)+"")&&quantProcesador.getText().equals(procesos.getValueAt(row, 2)+"")){
                procesos.removeRow(row);
            }
        }
        catch(NumberFormatException ex){
            error=true;
            mensaje="Se ingresaron letras o caracteres diferentes a los numeros";
        }
    }
}