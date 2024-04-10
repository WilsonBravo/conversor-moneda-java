package com.aluracursos.conversormoneda.main;

import com.aluracursos.conversormoneda.models.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        APIQuery apiQuery = new APIQuery();
        CountryInfo country = new CountryInfo();

        CurrencyConversion converter = new CurrencyConversion();
        CurrencyList currencyList = new CurrencyList();
        currencyList.setCurrencyList(apiQuery.getCurrencyList("COP"));

        Scanner input = new Scanner(System.in);
        String option;
        List<CurrencyConversion> conversionHistoric = new ArrayList<>();

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
            String currencyNameFrom;
            // Español | Inglés
            try {
                option = input.next();

                if (option.equals("salir")) {
                    break;
                }

                // Switch Case
                switch (option) {
                    // Change currency
                    case "1":

                        System.out.println("Ingresa el código ISO de la moneda de origen (Ej: COP).");
                        currencyNameFrom = input.next();
                        System.out.println("Ingresa el código ISO de la moneda de destino (Ej: USD).");
                        String currencyNameTo = input.next();
                        System.out.println("Ingresa la cantidad para el cambio de divisa (Ej. 436000.0)");
                        String amount = input.next();

                        converter.setFromCountry(currencyNameFrom);
                        converter.setToCountry(currencyNameTo);
                        converter.setAmount(Double.parseDouble(amount));

                        apiQuery.getCurrencyConversion(converter);

                        conversionHistoric.add(converter);

                        System.out.println("Cantidad convertida: "+converter.getAmountConverted()+" "+currencyNameTo);
                        System.out.println("\nPara ver el historial de conversiones puede ingresar la opción 5.");
                        System.out.println("Ingrese una nueva opción, o ingrese 'salir' para finalizar el programa.");

                        break;
                    //
                    case "2":

                        System.out.println(currencyList.getCurrencyNames());
                        System.out.println("\nPara más información sobre el país de origen de cualquier moneda puede ingresar la opción 4.");
                        System.out.println("Ingrese una nueva opción, o ingrese 'salir' para finalizar el programa.");

                        break;
                    case "3":

                        System.out.println("Ingresa el código ISO de la moneda (Ej: COP).");
                        String currencyName = input.next();

                        currencyList.setCurrencyList(apiQuery.getCurrencyList(currencyName));
                        System.out.println(currencyList);

                        System.out.println("\nPara realizar una conversión entre diferentes monedas puede ingresar la opción 1.");
                        System.out.println("Ingrese una nueva opción, o ingrese 'salir' para finalizar el programa.");

                        break;
                    case "4":

                        System.out.println("Ingresa el código ISO de la moneda (Ej: COP).");
                        currencyName = input.next();

                        country = apiQuery.getCountryInfo(currencyName);
                        System.out.println(country);

                        System.out.println("\nIngrese una nueva opción, o ingrese 'salir' para finalizar el programa.");

                    break;
                    case "5":

                        if (!conversionHistoric.isEmpty()) {
                            System.out.println(conversionHistoric);
                            System.out.println("\nIngrese una nueva opción, o ingrese 'salir' para finalizar el programa.");
                        } else {
                            System.out.println("No hay historial.");
                        }

                        break;
                    default:

                        System.out.println("Ingrese una opción válida.");
                        break;

                }

            } catch (Exception e) {
                System.out.println("Nombre del error: " + e.getClass().getSimpleName());
                System.out.println("Mensaje del error: " + e.getMessage());

                System.out.println("\nIngrese una nueva opción, o ingrese 'salir' para finalizar el programa.");
            }
        }
    }
}
