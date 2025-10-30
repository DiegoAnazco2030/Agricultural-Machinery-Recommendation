package org.flys.presentation;

import java.util.Scanner;

public class MenuObjects {
    private static final Scanner input = new Scanner(System.in); // solo una instancia

    // Leer un String válido (no vacío)
    public static String getString() {
        String text;
        do {
            System.out.print("Ingrese texto: ");
            text = input.nextLine().trim();
            if (text.isEmpty()) {
                System.out.println("⚠️ El texto no puede estar vacío. Intente nuevamente.");
            }
        } while (text.isEmpty());
        return text;
    }

    // Leer un entero (con manejo de errores)
    public static int getInt() {
        int number;
        while (true) {
            try {
                System.out.print("Ingrese un número entero: ");
                number = Integer.parseInt(input.nextLine());
                return number;
            } catch (NumberFormatException e) {
                System.out.println("⚠️ Entrada inválida. Debe ingresar un número entero.");
            }
        }
    }

    // Leer un entero dentro de un rango
    public static int getInt(int min, int max) {
        int number;
        while (true) {
            try {
                System.out.printf("Ingrese un número (%d - %d): ", min, max);
                number = Integer.parseInt(input.nextLine());
                if (number < min || number > max) {
                    System.out.println("⚠️ Número fuera de rango. Intente nuevamente.");
                } else {
                    return number;
                }
            } catch (NumberFormatException e) {
                System.out.println("⚠️ Entrada inválida. Debe ingresar un número entero.");
            }
        }
    }

    // Leer un número decimal
    public static double getDouble() {
        double number;
        while (true) {
            try {
                System.out.print("Ingrese un número decimal: ");
                number = Double.parseDouble(input.nextLine());
                return number;
            } catch (NumberFormatException e) {
                System.out.println("⚠️ Entrada inválida. Debe ingresar un número decimal.");
            }
        }
    }

    // Cerrar scanner al final del programa
    public static void close() {
        input.close();
    }
}
