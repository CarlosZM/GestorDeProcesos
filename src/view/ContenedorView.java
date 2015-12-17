package view;

import controller.ContenedorController;
import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.AbstractButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class ContenedorView extends JFrame{
	private JMenu procesos;
    private JMenu opciones;
    private JPanel panelCambios;
    private CardLayout cambios;
    
    
    public ContenedorView(JPanel p1,JPanel p2){
        JMenuBar menudeOpciones=new JMenuBar();
        setJMenuBar(menudeOpciones);
        procesos=new JMenu("Diagrama de Procesos");
        menudeOpciones.add(procesos);
        JMenuItem inicio=new JMenuItem("Iniciar");
        procesos.add(inicio);
        JMenuItem parar=new JMenuItem("Detener");
        procesos.add(parar);
        JMenuItem salir=new JMenuItem("Salir");
        procesos.add(salir);
        
        opciones=new JMenu("Opciones");
        menudeOpciones.add(opciones);
        JMenuItem configuracion=new JMenuItem("Configuracion");
        opciones.add(configuracion);
        JMenuItem reporte=new JMenuItem("Reportes");
        opciones.add(reporte);
        
        panelCambios=new JPanel();
        cambios=new CardLayout();
        panelCambios.setLayout(cambios);
        
        panelCambios.add("procesos", p1);
        panelCambios.add("configuracion", p2);
        panelCambios.add("error",new ErrorView());
        
        add(panelCambios);
        
        setUndecorated(true);
        setResizable(false);
    }
    
    public void registrarListener(ContenedorController control){
        Component[] components = opciones.getMenuComponents();
        for (Component component : components) {
            if (component instanceof AbstractButton) {
                AbstractButton button = (AbstractButton) component;
                button.addActionListener(control);
            }
        }
        components=procesos.getMenuComponents();
        for (Component component : components) {
            if (component instanceof AbstractButton) {
                AbstractButton button = (AbstractButton) component;
                button.addActionListener(control);
            }
        }
    }
    
    public void update(String valor){
        
    }
    public void cambio(String panel){
        cambios.show(panelCambios,panel);
    }
}
