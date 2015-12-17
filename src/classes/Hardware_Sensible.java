package classes;

public class Hardware_Sensible {
	private String medida;
    private double cantidad;
    private String nombre;
    private static String Kb="Kb";
    private static String Mb="Mb";
    private static String Gb="Gb";
    private boolean error;
    public Hardware_Sensible(String tipo){
        medida=Kb;
        cantidad=1024.0;
        nombre=tipo;
        error=false;
    }
    
    public void actualizar(String medida,double cantidad){
        double temp=cantidad*ajusteIncremento(medida);
        temp=temp+this.getCantidad();
        if(temp<0){
            setError(true);
        }
        else{
            if(temp>=0 && temp<1){
                temp=temp*1024;
                cambiarMedida(true);
            }
            else if(temp>1024){
                temp=temp/1024;
                cambiarMedida(false);
            }
            this.setCantidad(temp);
        } 
        
    }
    private double ajusteIncremento(String medida){
        double temp=0;
        if(medida.equals(this.getMedida())){
            temp=1;
        }
        else if((medida.equals(Mb) && this.getMedida().equals(Kb)) || (medida.equals(Gb) && this.getMedida().equals(Mb))){
            temp=1024;
        }
        else if((medida.equals(Mb) && this.getMedida().equals(Gb))||(medida.equals(Kb) && this.getMedida().equals(Mb))){
            temp=1/1024.0;
        }  
        else if(medida.equals(Kb) && this.getMedida().equals(Gb)){
            temp=1/(1024.0*1024);
        }
        else if(medida.equals(Gb) && this.getMedida().equals(Kb)){
            temp=1024*1024;
        }
        return temp;
    }

    private void cambiarMedida(boolean b) {
        if(!b){
            if(this.getMedida().equals(Kb)){
                this.setMedida(Mb);
            }
            else if(this.getMedida().equals(Mb)){
                this.setMedida(Gb);
            }
        }else{
            if(this.getMedida().equals(Gb)){
                this.setMedida(Mb);
            }
            else if(this.getMedida().equals(Mb)){
                this.setMedida(Kb);
            }
        }
    }    
    public boolean estado(){
        return isError();
    }
    public String tamano(){
        return this.getCantidad()+" "+this.getMedida();
    }
    public String getMedida() {
        return medida;
    }
    public void setMedida(String medida) {
        this.medida = medida;
    }
    public double getCantidad() {
        return cantidad;
    }
    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public boolean isError() {
        return error;
    }
    public void setError(boolean error) {
        this.error = error;
    }
}
