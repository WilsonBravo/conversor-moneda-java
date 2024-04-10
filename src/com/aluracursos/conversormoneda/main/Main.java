package com.aluracursos.conversormoneda.main;

import com.aluracursos.conversormoneda.models.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String option;

        Menu menu = new Menu();
        String language="";

        System.out.println("Para iniciar el programa en idioma español ingrese 'español'.");
        System.out.println("To start the program in English language enter 'english'.");

        while (!(language.equals("español")||language.equals("english"))) {
            language = input.next();

            switch (language) {
                case "español":
                    System.out.println(menu.getMenuInicial());
                    break;
                case "english":
                    System.out.println(menu.getInitialMenu());
                    break;
                default:
                    System.out.println("Ingrese una opción válida.");
                    System.out.println("Please enter a valid option.");
                    break;
            }

        }

        while (true) {

            option = input.next();

            if (option.equals("salir")||option.equals("exit")) {
                break;
            }

            try {
                // Switch Case
                if (language.equals("español")){
                    System.out.println(menu.establecerEleccion(option, input));
                } else if (language.equals("english")){
                    System.out.println(menu.setChoice(option, input));
                }

            } catch (Exception e) {
                System.out.println("Nombre del error: " + e.getClass().getSimpleName());
                System.out.println("Mensaje del error: " + e.getMessage());

                System.out.println("\nIngrese una nueva opción, o ingrese 'salir' para finalizar el programa.");
            }
        }
    }
}
