package Senso;
import java.util.LinkedList;
import java.util.Queue;

public class Censo {
    private Queue<Persona> colaCenso;

    public Censo() {
        colaCenso = new LinkedList<>();
    }

    public void registrarPersona(String nombre, String cedula, int edad, String direccion, int estrato, boolean esDesplazado) {
        Persona persona = new Persona(nombre, cedula, edad, direccion, estrato, esDesplazado);
        colaCenso.offer(persona); 
    }

    public void mostrarCenso() {
        if (colaCenso.isEmpty()) {
            System.out.println("No hay personas registradas.");
        } else {
            for (Persona persona : colaCenso) {
                System.out.println(persona);
            }
        }
    }

    public void filtrarPorEdad(int edadMinima) {
        boolean encontrado = false;
        for (Persona persona : colaCenso) {
            if (persona.getEdad() >= edadMinima) {
                System.out.println(persona);
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontraron personas con esa edad mínima.");
        }
    }
}
