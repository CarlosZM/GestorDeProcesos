package head;
import controller.ConfiguracionController;
import controller.ContenedorController;
import controller.ProcesoController;
import view.ConfiguracionView;
import view.ContenedorView;
import view.ProcesosView;
import model.ConfiguracionModel;
import model.ProcesosModel;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import javax.swing.JFrame;

public class Principal {
	public static void main(String[] args) {
		
		Principal obj = new Principal();

		String domainName = "google.com";
		
		//in mac oxs
		String command = "pwd";
		
		//in windows
		//String command = "ping -n 3 " + domainName;
		
		String output = obj.executeCommand(command);

		System.out.println(output);
		
		
		
		ConfiguracionModel modeloConf=new ConfiguracionModel();
		ConfiguracionView vistaConf=new ConfiguracionView();
		ConfiguracionController controlConf=new ConfiguracionController(vistaConf, modeloConf);
		
                
		ProcesosView vistaPro=new ProcesosView();
		ProcesosModel modeloPro=new ProcesosModel();
		ProcesoController controlPro=new ProcesoController(modeloPro, vistaPro);
		
		
		ContenedorView vista = new ContenedorView(vistaPro,vistaConf);
		ContenedorController control=new ContenedorController(vista);
		vista.registrarListener(control);
		vistaConf.registrarListener(controlConf,control);
		vistaPro.registrarListener(controlPro);
		vista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		vista.setSize(1280,720);
		vista.setVisible(true);
	}
	private String executeCommand(String command) {

		StringBuffer output = new StringBuffer();

		Process p;
		try {
			p = Runtime.getRuntime().exec(command);
			BufferedReader reader = 
                            new BufferedReader(new InputStreamReader(p.getInputStream()));

                        String line = "";			
			while ((line = reader.readLine())!= null) {
				output.append(line + "\n");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return output.toString();

	}	
}
