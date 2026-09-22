/**
 * @author Sergio Andrés García, Santiago Patiño y Jerónimo Rueda.
 */

package com.mycompany.serviragua;

import java.util.Scanner;

public class ServirAgua {

    public static void main(String[] args) {
        int agua = 0;
        int capacidadvaso = 100;
        Scanner sc = new Scanner(System.in);
        System.out.println("Presiona enter para servir agua");
        sc.nextLine();
        while (agua < capacidadvaso) {
            agua += 20;
            System.out.println("Sirviendo aguita....Nivel actual de agua: " + agua + "ml");
            System.out.println("Presiona enter para seguir sirviendo agua");
            sc.nextLine();
        }
        System.out.println("El vaso está lleno!");     
    }
}
