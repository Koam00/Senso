package Senso;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Censo censo = new Censo();
        int opcion = 0;

        while (true) {
            System.out.println("\n======= MENÚ DEL CENSO =======");
            System.out.println("1 Registrar persona");
            System.out.println("2  Ver todas las personas registradas");
            System.out.println("3  Buscar personas mayores de cierta edad");
            System.out.println("4  Salir del sistema");

            System.out.print("Seleccione una opción (1-4): ");
            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                scanner.nextLine(); 

                switch (opcion) {
                    case 1:
                        System.out.println("\n--- Registro de Persona ---");

                        System.out.print("Nombre: ");
                        String nombre = scanner.nextLine();

                        System.out.print("Cédula: ");
                        String cedula = scanner.nextLine();

                        int edad = leerEntero(scanner, "Edad");

                        System.out.print("Dirección: ");
                        String direccion = scanner.nextLine();

                        int estrato = 0;
                        do {
                            estrato = leerEntero(scanner, "Estrato (1 a 6)");
                            if (estrato < 1 || estrato > 6) {
                                System.out.println("El estrato debe estar entre 1 y 6.");
                            }
                        } while (estrato < 1 || estrato > 6);

                        boolean esDesplazado = false;
                        while (true) {
                            System.out.print("¿Es desplazado? (1. Sí / 2. No): ");
                            if (scanner.hasNextInt()) {
                                int respuesta = scanner.nextInt();
                                scanner.nextLine();
                                if (respuesta == 1) {
                                    esDesplazado = true;
                                    break;
                                } else if (respuesta == 2) {
                                    esDesplazado = false;
                                    break;
                                } else {
                                    System.out.println("Opción inválida. Ingrese 1 o 2.");
                                }
                            } else {
                                System.out.println("Entrada inválida. Debe ingresar un número (1 o 2).");
                                scanner.next();
                            }
                        }

                       
                        while (true){
                            System.out.println("Ingrese el valor del minimo: ");

                                if (scanner.hasNextDouble()) {
                                    double auxilioBase = scanner.nextDouble();
                                    scanner.nextLine();
                                    if (auxilioBase < 0) {
                                        System.out.println("El valor del minimo no puede ser negativo.");
                                    } else {
                                        break;
                                    }
                                } else {
                                    System.out.println("Entrada inválida. Debe ingresar un número.");
                                    scanner.next();
                                }
                            
                        }
                       
                        
                        censo.registrarPersona(nombre, cedula, edad, direccion, estrato, esDesplazado);
                        System.out.println("Persona registrada correctamente.");
                        break;

                    case 2:
                        System.out.println("\n--- Personas Registradas ---");
                        censo.mostrarCenso();
                        break;

                    case 3:
                        int edadMinima = leerEntero(scanner, "Edad mínima para filtrar");
                        System.out.println("\n--- Personas con edad >= " + edadMinima + " ---");
                        censo.filtrarPorEdad(edadMinima);
                        break;

                    case 4:
                        System.out.println("Gracias por usar el sistema del censo. ¡Hasta luego!");
                        scanner.close();
                        return;

                    default:
                        System.out.println("Opción no válida. Intente de nuevo.");
                }
            } else {
                System.out.println("Debe ingresar un número (1 a 4).");
                scanner.next(); 
            }
        }
    }

    public static int leerEntero(Scanner scanner, String mensaje) {
        int numero = 0;
        boolean valido = false;
        while (!valido) {
            System.out.print(mensaje + ": ");
            if (scanner.hasNextInt()) {
                numero = scanner.nextInt();
                scanner.nextLine();
                valido = true;
            } else {
                System.out.println("Entrada inválida. Debe ingresar un número.");
                scanner.next(); 
            }
        }
        return numero;
    }
}