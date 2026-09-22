/**
* @author Jeronimo Rueda y Santiago Patiño
*/
package com.mycompany.trabajadores;
 
import java.util.Scanner;
 
public class Trabajadores {
 
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
 
        // Declaración de los vectores paralelos.
        String[] nombres = null;
        String[] apellidos = null;
        int[] diasTrabajados = null;
        double[] salario = null;
 
        int capacidadMaxima = 0;
        int cantidadRegistrados = 0;
        boolean vectoresIniciados = false;
        int opcion = 0;
 
        do {
 
            System.out.println("\n============================================");
            System.out.println("           SISTEMA DE NOMINA                  ");
            System.out.println("============================================");
            System.out.println("  1. [+] Ingresar nuevos trabajadores       ");
            System.out.println("  2. [=] Consultar trabajadores y pagos     ");
            System.out.println("  3. [?] Buscar trabajador                  ");
            System.out.println("  4. [x] Salir                              ");
            System.out.println("============================================");
            System.out.print(" -> Elige una opcion (1-4): ");
 
            opcion = scanner.nextInt();
            scanner.nextLine();
 
            switch (opcion) {
                case 1:
                    if (!vectoresIniciados) {
                        System.out.println("\n--- CONFIGURACION INICIAL ---");
                        System.out.print(" -> Cual sera la cantidad MAXIMA de trabajadores a registrar?: ");
                        capacidadMaxima = scanner.nextInt();
                        scanner.nextLine();
 
                        nombres = new String[capacidadMaxima];
                        apellidos = new String[capacidadMaxima];
                        diasTrabajados = new int[capacidadMaxima];
                        salario = new double[capacidadMaxima];
                        vectoresIniciados = true;
                    }
 
                    if (cantidadRegistrados >= capacidadMaxima) {
                        System.out.println("\n[!] Has alcanzado el limite maximo de memoria (" + capacidadMaxima + " trabajadores).");
                        break;
                    }
 
                    String respuesta;
                    do {
                        System.out.println("\n--- INGRESANDO TRABAJADOR " + (cantidadRegistrados + 1) + " DE " + capacidadMaxima + " ---");
 
                        System.out.print(" * Nombre: ");
                        nombres[cantidadRegistrados] = scanner.nextLine();
 
                        System.out.print(" * Apellido: ");
                        apellidos[cantidadRegistrados] = scanner.nextLine();
 
                        // Validación de días trabajados (0 a 30).
                        int dias;
                        do {
                            System.out.print(" * Dias trabajados (0-30): ");
                            dias = scanner.nextInt();
                            if (dias < 0 || dias > 30) {
                                System.out.println("   [!] Error: Los dias deben estar en un rango de 0 a 30. Intentalo de nuevo.");
                            }
                        } while (dias < 0 || dias > 30);
                        diasTrabajados[cantidadRegistrados] = dias;
 
                        // Validación de sueldo mensual.
                        double valor;
                        do {
                            System.out.print(" * Salario mensual: $");
                            valor = scanner.nextDouble();
                            if (valor < 0) {
                                System.out.println("   [!] Error: El sueldo no puede ser negativo.");
                            }
                        } while (valor < 0);
                        salario[cantidadRegistrados] = valor;
 
                        scanner.nextLine();
 
                        cantidadRegistrados++;
 
                        if (cantidadRegistrados < capacidadMaxima) {
                            System.out.print("\n -> Quieres continuar registrando ahora? (s/n): ");
                            respuesta = scanner.nextLine();
                        } else {
                            System.out.println("\n[i] Se ha llenado la capacidad maxima de los vectores.");
                            respuesta = "n";
                        }
 
                    } while (respuesta.equalsIgnoreCase("s") && cantidadRegistrados < capacidadMaxima);
 
                    System.out.println("\n[OK] Trabajadores guardados exitosamente!");
                    break;
 
                case 2:
                    if (cantidadRegistrados == 0) {
                        System.out.println("\n[!] Todavia no hay registros. Primero usa la opcion 1.");
                        break;
                    }
 
                    System.out.println("\n===============================================================================");
                    System.out.println("                         REPORTE DE NOMINA Y SALARIOS                          ");
                    System.out.println("===============================================================================");
                    System.out.printf("%-15s %-15s %-15s %-10s %-15s%n", "NOMBRE", "APELLIDO", "SALARIO", "DIAS", "SALARIO TOTAL");
                    System.out.println("-------------------------------------------------------------------------------");
 
                    double nominaTotal = 0;
 
                    for (int i = 0; i < cantidadRegistrados; i++) {
                        double totalPagar = (salario[i] / 30) * diasTrabajados[i];
 
                        // Bono si trabajó 20 días o más.
                        String extra = "";
                        if (diasTrabajados[i] >= 20) {
                            totalPagar += (totalPagar * 0.05);
                            extra = "(+Bono)";
                        }
 
                        nominaTotal += totalPagar;
 
                        System.out.printf("%-15s %-15s $%-14.2f %-10d $%-14.2f %s%n",
                                nombres[i], apellidos[i], salario[i], diasTrabajados[i], totalPagar, extra);
                    }
                    System.out.println("===============================================================================");
                    System.out.printf(" TOTAL NOMINA EMPRESA: $%.2f%n", nominaTotal);
                    break;
 
                case 3:
                    if (cantidadRegistrados == 0) {
                        System.out.println("\n[!] No hay registros para buscar.");
                        break;
                    }
 
                    System.out.print("\n -> Escribe el nombre o apellido a buscar: ");
                    String busqueda = scanner.nextLine().toLowerCase();
                    boolean encontrado = false;
 
                    System.out.println("\n----------------- RESULTADOS -----------------");
 
                    for (int i = 0; i < cantidadRegistrados; i++) {
                        if (nombres[i].toLowerCase().contains(busqueda) || apellidos[i].toLowerCase().contains(busqueda)) {
 
                            double totalPagar = (salario[i] / 30) * diasTrabajados[i];
                            if (diasTrabajados[i] >= 20) {
                                totalPagar += (totalPagar * 0.05);
                            }
 
                            System.out.println(" [*] " + nombres[i] + " " + apellidos[i]);
                            System.out.println("     |- Dias trabajados: " + diasTrabajados[i]);
                            System.out.println("     |- Salario mensual: $" + salario[i]);
                            System.out.println("     \\- Total a pagar:   $" + String.format("%.2f", totalPagar));
                            System.out.println("");
                            encontrado = true;
                        }
                    }
 
                    if (!encontrado) {
                        System.out.println(" [!] No se encontro ningun trabajador con ese dato.");
                    }
                    System.out.println("----------------------------------------------");
                    break;
 
                case 4:
                    System.out.println("\n[SALIENDO] Que tengas un excelente dia.");
                    break;
 
                default:
                    System.out.println("\n[!] Opcion no valida. Elige un numero del 1 al 4.");
                    break;
            }
 
        } while (opcion != 4);
 
        scanner.close();
    }
}