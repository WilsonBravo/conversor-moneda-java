package com.aluracursos.conversormoneda.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private final CurrencyConversion converter = new CurrencyConversion();
    private final APIQuery apiQuery = new APIQuery();

    // Lists
    private final List<CurrencyConversion> conversionHistoric = new ArrayList<>();
    private final CurrencyList currencyList = new CurrencyList();


    public String establecerEleccion (String option, Scanner input) {
        currencyList.setCurrencyList(apiQuery.getCurrencyList("COP"));

        String currencyNameFrom;
        String currencyNameTo;
        String currencyName;
        String amount;

        try {
            // Switch Case
            switch (option) {
                // Change currency
                case "1":

                    System.out.println("Ingresa el código ISO de la moneda de origen (Ej: COP).");
                    currencyNameFrom = input.next();
                    System.out.println("Ingresa el código ISO de la moneda de destino (Ej: USD).");
                    currencyNameTo = input.next();
                    System.out.println("Ingresa la cantidad para el cambio de divisa (Ej. 436000.0).");
                    amount = input.next();

                    converter.setFromCountry(currencyNameFrom);
                    converter.setToCountry(currencyNameTo);
                    converter.setAmount(Double.parseDouble(amount));

                    apiQuery.getCurrencyConversion(converter);

                    conversionHistoric.add(new CurrencyConversion().setValues(converter));

                    return "Resultado: "+converter.getAmountConverted()+" "+currencyNameTo+
                    "\nPara ver el historial de conversiones puede ingresar la opción 5."+
                    "\nIngrese una nueva opción, o ingrese 'salir' para finalizar el programa.";

                // Get Currency Names
                case "2":

                    return currencyList.getCurrencyNames()+"""

                            Para más información sobre el país de origen de cualquier moneda puede ingresar la opción 4.
                            Ingrese una nueva opción, o ingrese 'salir' para finalizar el programa.""";

                // Get Currency Rate
                case "3":

                    System.out.println("Ingresa el código ISO de la moneda (Ej: COP).");
                    currencyName = input.next();

                    currencyList.setCurrencyList(apiQuery.getCurrencyList(currencyName));

                    return currencyList+"""

                            Para realizar una conversión entre diferentes monedas puede ingresar la opción 1.
                            Ingrese una nueva opción, o ingrese 'salir' para finalizar el programa.""";

                // Get Country Info
                case "4":

                    System.out.println("Ingresa el código ISO de la moneda (Ej: COP).");
                    currencyName = input.next();

                    // Objects
                    CountryInfo country = apiQuery.getCountryInfo(currencyName);
                    return country+"\nIngrese una nueva opción, o ingrese 'salir' para finalizar el programa.";

                // Get Historical Data
                case "5":

                    if (!conversionHistoric.isEmpty()) {
                        return conversionHistoric+"\nIngrese una nueva opción, o ingrese 'salir' para finalizar el programa.";
                    } else {
                        return "No hay historial.";
                    }

                default:

                    return "Ingrese una opción válida.";

            }

        } catch (Exception e) {
            return "Nombre del error: " + e.getClass().getSimpleName()+
            "\nMensaje del error: " + e.getMessage()+
            "\nIngrese una nueva opción, o ingrese 'salir' para finalizar el programa.";
        }
    }

    public String setChoice (String option, Scanner input) {
        currencyList.setCurrencyList(apiQuery.getCurrencyList("COP"));

        String currencyNameFrom;
        String currencyNameTo;
        String currencyName;
        String amount;

        try {
            // Switch Case
            switch (option) {
                // Change currency
                case "1":

                    System.out.println("Enter the ISO code of the source currency (e.g., COP).");
                    currencyNameFrom = input.next();
                    System.out.println("Enter the ISO code of the target currency (e.g., USD).");
                    currencyNameTo = input.next();
                    System.out.println("Enter the amount for currency exchange (e.g., 436000.0).");
                    amount = input.next();

                    converter.setFromCountry(currencyNameFrom);
                    converter.setToCountry(currencyNameTo);
                    converter.setAmount(Double.parseDouble(amount));

                    apiQuery.getCurrencyConversion(converter);

                    conversionHistoric.add(new CurrencyConversion().setValues(converter));

                    return "Result: "+converter.getAmountConverted()+" "+currencyNameTo+
                            "\nTo view conversion history, you can enter option 5."+
                            "\nEnter a new option, or enter 'exit' to end the program.";

                // Get Currency Names
                case "2":

                    return currencyList.getCurrencyNames()+"""

                            For more information about the country of origin for any currency, you can enter option 4.
                            Enter a new option, or enter 'exit' to end the program.""";

                // Get Currency Rate
                case "3":

                    System.out.println("Enter the ISO code of the currency (e.g., COP).");
                    currencyName = input.next();

                    currencyList.setCurrencyList(apiQuery.getCurrencyList(currencyName));

                    return currencyList+"""

                            To perform a conversion between different currencies, you can enter option 1.
                            Enter a new option, or enter 'exit' to end the program.""";

                // Get Country Info
                case "4":

                    System.out.println("Enter the ISO code of the currency (e.g., COP).");
                    currencyName = input.next();

                    // Objects
                    CountryInfo country = apiQuery.getCountryInfo(currencyName);
                    return country+"\nEnter a new option, or enter 'exit' to end the program.";

                // Get Historical Data
                case "5":

                    if (!conversionHistoric.isEmpty()) {
                        return conversionHistoric+"\nEnter a new option, or enter 'exit' to end the program.";
                    } else {
                        return "There is no history.";
                    }

                default:

                    return "Please enter a valid option.";

            }

        } catch (Exception e) {
            return "Error name: " + e.getClass().getSimpleName()+
                    "\nError message: " + e.getMessage()+
                    "\nEnter a new option, or enter 'exit' to end the program.";
        }
    }

    public String getInitialMenu() {
        return """
                ************************************************************
                Welcome to the currency converter!
                Please choose one of the following options:
                        
                    1- Convert an amount from one currency to another (e.g., 436000.0 COP to USD).
                    2- View the ISO codes that can be converted (e.g., COP, USD, JPY).
                    3- View the current exchange rate of a currency (e.g., COP).
                    4- View country information based on the ISO code of its currency (e.g., COP -> Colombia).
                    5- View your conversion history.
                    
                To exit the program, please enter 'exit'.
                ************************************************************
                """;
    }

    public String getMenuInicial() {
        return """
                ************************************************************
                Bienvenido/a al conversor de divisa!
                Escoja una de las opciones:
                        
                    1- Convertir cantidad de una divisa a otra (Ej: 436000.0 COP a USD).
                    2- Ver los códigos ISO que se pueden convertir (Ej: COP, USD, JPY).
                    3- Ver la taza de cambio actual de una moneda (Ej: COP).
                    4- Ver información del país a partir del código ISO de su moneda (Ej: COP -> Colombia).
                    5- Ver tu historial de conversiones.
                    
                Para finalizar el programa, por favor ingrese 'salir'.
                ************************************************************
                """;
    }
}
