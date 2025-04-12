package Senso;

public class Persona {
    private String nombre;
    private String cedula;
    private int edad;
    private String direccion;
    private int estrato; 
    private double auxilio;
    private boolean esDesplazado;

    
    public Persona(String nombre, String cedula, int edad, String direccion, int estrato, boolean esDesplazado) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.edad = edad;
        this.direccion = direccion;
        this.estrato = estrato;
        this.esDesplazado = esDesplazado;
        calcularAuxilio();
    }

    
    private void calcularAuxilio() {
        double auxilioBase = 0;  
        if (edad < 18) {
            this.auxilio = auxilioBase + (auxilioBase * 0.8);
            
        } else {
            this.auxilio = auxilioBase;
            
        }
        
    
    }
    
    
    
    public String getNombre(){
        return nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public int getEdad() {
        return edad;
    }

    public String getDireccion() {
        return direccion;
    }

    public int getEstrato() {
        return estrato;
    }

    public double getAuxilio() {
        return auxilio;
    }

    public boolean isEsDesplazado() {
        return esDesplazado;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", cedula='" + cedula + '\'' +
                ", edad=" + edad +
                ", direccion='" + direccion + '\'' +
                ", estrato=" + estrato + 
                ", auxilio=" + auxilio +
                ", esDesplazado=" + esDesplazado +
                '}';
    }
}