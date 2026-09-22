/**
 * @author Sergio Andrés García, Santiago Patiño y Jerónimo Rueda.
 */

package com.mycompany.menunomina;

import java.util.Scanner;

public class MenuNomina {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int option;

        do {
            System.out.println("\n---------- MENU ----------");
            System.out.println("Elige al trabajador para conocer su nómina:");
            System.out.println("1. Vendedor");
            System.out.println("2. Contador");
            System.out.println("3. Administrador");
            System.out.println("4. Jefe");
            System.out.println("5. Salir");
            System.out.print("Selecciona una opción: ");

            option = sc.nextInt();

            switch (option) {
                case 1:
                    System.out.println("Escogiste la nómina del vendedor.");
                    System.out.println("Valor a pagar: $2.000.000");
                    break;

                case 2:
                    System.out.println("Escogiste la nómina del contador.");
                    System.out.println("Valor a pagar: $3.000.000");
                    break;

                case 3:
                    System.out.println("Escogiste la nómina del administrador.");
                    System.out.println("Valor a pagar: $4.000.000");
                    break;

                case 4:
                    System.out.println("Escogiste la nómina del jefe.");
                    System.out.println("Valor a pagar: $7.000.000");
                    break;

                case 5:
                    System.out.println("Programa finalizado.");
                    break;

                default:
                    System.out.println("No seleccionaste un valor válido.");
                    break;
            }

        } while (option != 5);

        sc.close();
    }
}
