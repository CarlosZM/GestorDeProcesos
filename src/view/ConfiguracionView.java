package view;

import controller.ConfiguracionController;
import controller.ContenedorController;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.AbstractButton;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;

public class ConfiguracionView extends JPanel{
    private JComboBox<String> tipoMedidaRam,tipoMedidaDisco;
    private JPanel botonesOpcionesProcesador,botonesOpcionesRam,botonesOpcionesDisco;
    private JSpinner datoRam,datoDisco;
    private JLabel dimensionRam,dimensionDisco;
    private JTable tablaProcesadores;
    private JTextField numProcesador,velProcesador,quantProcesador;
    public ConfiguracionView(){
        vistaProcesadores();
        vistaRam();
        vistaDisco();
    }
    public void registrarListener(ConfiguracionController control,ContenedorController controlTotal) {
        Component[] componentes =botonesOpcionesProcesador.getComponents();
        for (Component componente : componentes) {
            if(componente instanceof AbstractButton && !((AbstractButton) componente).getActionCommand().equals("Salvar")){
                AbstractButton boton=(AbstractButton)componente;
                boton.addActionListener(control);
            }
        }
        for (Component componente : componentes) {
            if(componente instanceof AbstractButton && ((AbstractButton) componente).getActionCommand().equals("Salvar")){
                AbstractButton boton=(AbstractButton)componente;
                boton.addActionListener(controlTotal);
            }
        }
        componentes=botonesOpcionesDisco.getComponents();
        for(Component componente:componentes){
            if(componente instanceof AbstractButton){
                AbstractButton boton=(AbstractButton)componente;
                boton.addActionListener(control);
            }
        }
        componentes=botonesOpcionesRam.getComponents();
        for(Component componente:componentes){
            if(componente instanceof AbstractButton){
                AbstractButton boton=(AbstractButton)componente;
                boton.addActionListener(control);
            }
        }
        
        getTablaProcesadores().addMouseListener(control);
    }
    public void actualizarRam(String medida, double cant){
        dimensionRam.setText(cant+"-"+medida);
    }
    public Integer getCantRam(){
        return  (Integer) datoRam.getValue();
    }
    public String getDimRam(){
        return tipoMedidaRam.getSelectedItem().toString();
    }
    public void actualizarDisco(String medida, double cant){
        dimensionDisco.setText(cant+"-"+medida);
    }
    public Integer getCantDisco(){
        return  (Integer) datoDisco.getValue();
    }
    public String getDimDisco(){
        return tipoMedidaDisco.getSelectedItem().toString();
    }

    private void vistaProcesadores() {
        JPanel procesadores=new JPanel();
        procesadores.setBorder(javax.swing.BorderFactory.createTitledBorder("Especificaciones de los Procesadores"));
        add(procesadores);
        vistaTablaProcesador(procesadores);
        vistaEdicionProcesador(procesadores);
        vistaOpcionesProcesador(procesadores);
        
        
        
        
    }

    private void vistaRam() {
        JPanel ram=new JPanel();
        ram.setBorder(javax.swing.BorderFactory.createTitledBorder("Especificaciones de la Memoria Ram"));
        ram.setLayout(new javax.swing.BoxLayout(ram, javax.swing.BoxLayout.LINE_AXIS));
        
        add(ram);
        JLabel etiqueta=new JLabel("Tamaño actual de la memoria:");
        ram.add(etiqueta);
        ram.add(Box.createRigidArea(new Dimension(10,0)));
        
        dimensionRam=new JLabel("1024 Kb");        
        ram.add(dimensionRam);
        ram.add(Box.createRigidArea(new Dimension(10,0)));
        
        SpinnerModel modeloIncremento=new SpinnerNumberModel(128,-1024,1024,128);
        datoRam=new JSpinner(modeloIncremento);
        ram.add(datoRam);
        ram.add(Box.createRigidArea(new Dimension(10,0)));
        
        tipoMedidaRam=new JComboBox<String>();
        tipoMedidaRam.addItem("Kb");
        tipoMedidaRam.addItem("Mb");
        tipoMedidaRam.addItem("Gb");
        ram.add(tipoMedidaRam);
        ram.add(Box.createRigidArea(new Dimension(10,0)));
        
        botonesOpcionesRam=new JPanel();
        
        JButton accionRam=new JButton("Adicionar");
        accionRam.setActionCommand("addRam");
        botonesOpcionesRam.add(accionRam);
        botonesOpcionesRam.add(Box.createRigidArea(new Dimension(10,0)));
        
        JButton reinicioRam=new JButton("Restablecer");
        reinicioRam.setActionCommand("resetRam");
        botonesOpcionesRam.add(reinicioRam);
        
        ram.add(botonesOpcionesRam);
    }

    private void vistaDisco() {
        JPanel disco=new JPanel();
        disco.setBorder(javax.swing.BorderFactory.createTitledBorder("Especificaciones del Disco Duro"));
        disco.setLayout(new javax.swing.BoxLayout(disco, javax.swing.BoxLayout.LINE_AXIS));
        
        add(disco);
        JLabel etiqueta1=new JLabel("Tamaño actual del Disco:");
        disco.add(etiqueta1);
        disco.add(Box.createRigidArea(new Dimension(10,0)));
        
        dimensionDisco=new JLabel("1024.0 Kb");        
        disco.add(dimensionDisco);
        disco.add(Box.createRigidArea(new Dimension(10,0)));
        SpinnerModel modeloIncremento=new SpinnerNumberModel(128,-1024,1024,128);
        datoDisco=new JSpinner(modeloIncremento);
        disco.add(datoDisco);
        disco.add(Box.createRigidArea(new Dimension(10,0)));
        
        tipoMedidaDisco=new JComboBox<String>();
        tipoMedidaDisco.addItem("Kb");
        tipoMedidaDisco.addItem("Mb");
        tipoMedidaDisco.addItem("Gb");
        disco.add(tipoMedidaDisco);
        disco.add(Box.createRigidArea(new Dimension(10,0)));
        
        botonesOpcionesDisco=new JPanel();
        JButton accionDisco=new JButton("Adicionar");
        accionDisco.setActionCommand("addDisco");
        botonesOpcionesDisco.add(accionDisco);
        botonesOpcionesDisco.add(Box.createRigidArea(new Dimension(10,0)));
        
        JButton reinicioDisco=new JButton("Restablecer");
        reinicioDisco.setActionCommand("resetDisco");
        botonesOpcionesDisco.add(reinicioDisco);
        
        disco.add(botonesOpcionesDisco);
    }

    private void vistaTablaProcesador(JPanel principal) {
        JPanel tablas=new JPanel();
        tablas.setBorder(javax.swing.BorderFactory.createTitledBorder("Procesadores"));
        principal.add(tablas);
        Object [] nombres={"N°","Velocidad","Quantum"};
        DefaultTableModel tabla=new DefaultTableModel(nombres, 1){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };;
        setTablaProcesadores(new JTable(tabla));
        
        JScrollPane scrollTable=new JScrollPane(getTablaProcesadores());
        tablas.add(scrollTable);
    }

    private void vistaEdicionProcesador(JPanel principal) {
        JPanel registroProcesadores= new JPanel();
        GridLayout layoutRegistro=new GridLayout(3, 2);
        registroProcesadores.setLayout(layoutRegistro);
        registroProcesadores.setBorder(javax.swing.BorderFactory.createTitledBorder("Informacion del Procesador"));
        principal.add(registroProcesadores);
        
        JLabel num=new JLabel("N° de Procesador:");
        registroProcesadores.add(num);
        setNumProcesador(new JTextField("1", 10));
        getNumProcesador().setEnabled(false);
        registroProcesadores.add(getNumProcesador());
        
        JLabel vel=new JLabel("Velocidad de Procesamiento:");
        registroProcesadores.add(vel);
        setVelProcesador(new JTextField("0.0",10));
        registroProcesadores.add(getVelProcesador());
        
        JLabel quant=new JLabel("Quantum:");
        registroProcesadores.add(quant);
        setQuantProcesador(new JTextField("0",10));
        registroProcesadores.add(getQuantProcesador());
        
        
    }

    private void vistaOpcionesProcesador(JPanel principal) {
        botonesOpcionesProcesador=new JPanel();
        botonesOpcionesProcesador.setBorder(javax.swing.BorderFactory.createTitledBorder("Acciones"));
        GridLayout layoutRegistro=new GridLayout(3, 2);
        botonesOpcionesProcesador.setLayout(layoutRegistro);
        JButton agregarProc=new JButton("Agregar");
        botonesOpcionesProcesador.add(agregarProc);
        JButton editarProc=new JButton("Editar");
        botonesOpcionesProcesador.add(editarProc);
        JButton salvarProc=new JButton("Salvar");
        botonesOpcionesProcesador.add(salvarProc);
        JButton eliminarProc=new JButton("Eliminar");
        botonesOpcionesProcesador.add(eliminarProc);
        JButton limpiarProc=new JButton("Limpiar");
        botonesOpcionesProcesador.add(limpiarProc);
        JButton resetProc=new JButton("Reiniciar");
        botonesOpcionesProcesador.add(resetProc);
        principal.add(botonesOpcionesProcesador);
    }
    public void setProcesador(String n,String v,String q){
        getNumProcesador().setText(n);
        getVelProcesador().setText(v);
        getQuantProcesador().setText(q);
    }
    public boolean isProcesador(){
        if(!numProcesador.isEnabled()&&velProcesador.isEditable()&&quantProcesador.isEnabled()){
            return true;
        }
        return false;
    }
    public void disableProcesador(){
        numProcesador.setEnabled(false);
        velProcesador.setEnabled(false);
        quantProcesador.setEnabled(false);
    }
    public void enableProcesador(){
        numProcesador.setEnabled(true);
        velProcesador.setEnabled(true);
        quantProcesador.setEnabled(true);
    }

    /**
     * @return the numProcesador
     */
    public JTextField getNumProcesador() {
        return numProcesador;
    }

    /**
     * @param numProcesador the numProcesador to set
     */
    public void setNumProcesador(JTextField numProcesador) {
        this.numProcesador = numProcesador;
    }

    /**
     * @return the velProcesador
     */
    public JTextField getVelProcesador() {
        return velProcesador;
    }

    /**
     * @param velProcesador the velProcesador to set
     */
    public void setVelProcesador(JTextField velProcesador) {
        this.velProcesador = velProcesador;
    }

    /**
     * @return the quantProcesador
     */
    public JTextField getQuantProcesador() {
        return quantProcesador;
    }

    /**
     * @param quantProcesador the quantProcesador to set
     */
    public void setQuantProcesador(JTextField quantProcesador) {
        this.quantProcesador = quantProcesador;
    }

    public void actualizarProcesador(DefaultTableModel procesador) {
        getTablaProcesadores().setModel(procesador);
    }

    /**
     * @return the tablaProcesadores
     */
    public JTable getTablaProcesadores() {
        return tablaProcesadores;
    }

    /**
     * @param tablaProcesadores the tablaProcesadores to set
     */
    public void setTablaProcesadores(JTable tablaProcesadores) {
        this.tablaProcesadores = tablaProcesadores;
        this.tablaProcesadores.setAutoCreateRowSorter(true);
    }
}