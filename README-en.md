# Java Currency Converter

This is a project for the ONE G6 program in collaboration with Alura LATAM for the Backend specialization with Java.
The objective of this project is to develop a currency converter. In my development, the converter includes the following functions:

    1- Convert an amount from one currency to another (e.g., 436000.0 COP to USD).
    2- View the ISO codes that can be converted (e.g., COP, USD, JPY).
    3- View the current exchange rate of a currency (e.g., COP).
    4- View country information based on the ISO code of its currency (e.g., COP -> Colombia).
    5- View your conversion history.

The menu of options is available in both English and Spanish.

The [ExchangeRate-API](https://www.exchangerate-api.com/) was used to obtain the exchange rate values for currency conversion and to display a list of available currencies for conversion. In this case, a GET request was made to the link https://open.er-api.com/v6/latest/COP, where COP represents the ISO code for the currency of Colombia, obtaining the following response.

    {
        "result": "success",
        "provider": "https://www.exchangerate-api.com",
        "documentation": "https://www.exchangerate-api.com/docs/free",
        "terms_of_use": "https://www.exchangerate-api.com/terms",
        "time_last_update_unix": 1712707351,
        "time_last_update_utc": "Wed, 10 Apr 2024 00:02:31 +0000",
        "time_next_update_unix": 1712795581,
        "time_next_update_utc": "Thu, 11 Apr 2024 00:33:01 +0000",
        "time_eol_unix": 0,
        "base_code": "COP",
        "rates": {
            "COP": 1,
            "AED": 0.000977,
            "AFN": 0.01894,
            "ALL": 0.02504,
            "AMD": 0.103608,
            "ANG": 0.000476...
        }
    }


Furthermore, the [REST Countries](https://restcountries.com/) API was used to obtain information about a country based on the ISO code of its currency. In this case, a GET request was made to the link https://restcountries.com/v3.1/currency/COP?fields=name,capital,currencies,population,flags,timezones, which includes field filtering to avoid obtaining an overly extensive response.

    [
        {
            "flags": {
                "png": "https://flagcdn.com/w320/co.png",
                "svg": "https://flagcdn.com/co.svg",
                "alt": "The flag of Colombia is composed of three horizontal bands of yellow, blue and red, with the yellow band twice the height of the other two bands."
            },
            "name": {
                "common": "Colombia",
                "official": "Republic of Colombia",
                "nativeName": {
                    "spa": {
                        "official": "República de Colombia",
                        "common": "Colombia"
                    }
                }
            },
            "currencies": {
                "COP": {
                    "name": "Colombian peso",
                    "symbol": "$"
                }
            },
            "capital": [
                "Bogotá"
            ],
            "population": 50882884,
            "timezones": [
                "UTC-05:00"
            ]
        }
    ]

************************************************************

Once the program starts, the user is presented with the option to choose between Spanish or English language through the following text:

    Para iniciar el programa en idioma español ingrese 'español'.
    To start the program in English language enter 'english'.

Subsequently, the menu with the functionalities is presented:

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

Next, an example of usage is presented.

************************************************************
### 1. Convert an amount from one currency to another (e.g., 436000.0 COP to USD).

    Enter the ISO code of the source currency (e.g., COP).
    COP
    Enter the ISO code of the target currency (e.g., USD).
    USD
    Enter the amount for currency exchange (e.g., 436000.0).
    25500
    Result: 6.78402 USD
    To view conversion history, you can enter option 5.
    Enter a new option, or enter 'exit' to end the program.

************************************************************   
### 2. View the ISO codes that can be converted (e.g., COP, USD, JPY).

        COP  AED  AFN  ALL  AMD  ANG  AOA  ARS  AUD  AWG
        AZN  BAM  BBD  BDT  BGN  BHD  BIF  BMD  BND  BOB
        BRL  BSD  BTN  BWP  BYN  BZD  CAD  CDF  CHF  CLP
        CNY  CRC  CUP  CVE  CZK  DJF  DKK  DOP  DZD  EGP
        ERN  ETB  EUR  FJD  FKP  FOK  GBP  GEL  GGP  GHS
        GIP  GMD  GNF  GTQ  GYD  HKD  HNL  HRK  HTG  HUF
        IDR  ILS  IMP  INR  IQD  IRR  ISK  JEP  JMD  JOD
        JPY  KES  KGS  KHR  KID  KMF  KRW  KWD  KYD  KZT
        LAK  LBP  LKR  LRD  LSL  LYD  MAD  MDL  MGA  MKD
        MMK  MNT  MOP  MRU  MUR  MVR  MWK  MXN  MYR  MZN
        NAD  NGN  NIO  NOK  NPR  NZD  OMR  PAB  PEN  PGK
        PHP  PKR  PLN  PYG  QAR  RON  RSD  RUB  RWF  SAR
        SBD  SCR  SDG  SEK  SGD  SHP  SLE  SLL  SOS  SRD
        SSP  STN  SYP  SZL  THB  TJS  TMT  TND  TOP  TRY
        TTD  TVD  TWD  TZS  UAH  UGX  USD  UYU  UZS  VES
        VND  VUV  WST  XAF  XCD  XDR  XOF  XPF  YER  ZAR
        ZMW  ZWL
        
    For more information about the country of origin for any currency, you can enter option 4.
    Enter a new option, or enter 'exit' to end the program.

************************************************************   
### 3. View the current exchange rate of a currency (e.g., COP).

    Enter the ISO code of the currency (e.g., COP).
    COP

        COP: 1.000000  AED: 0.000977  AFN: 0.018940  ALL: 0.025040  AMD: 0.103608  ANG: 0.000476
        AOA: 0.224613  ARS: 0.230054  AUD: 0.000403  AWG: 0.000476  AZN: 0.000452  BAM: 0.000479
        BBD: 0.000532  BDT: 0.029170  BGN: 0.000479  BHD: 0.000100  BIF: 0.765841  BMD: 0.000266
        BND: 0.000358  BOB: 0.001839  BRL: 0.001339  BSD: 0.000266  BTN: 0.022141  BWP: 0.003615
        BYN: 0.000867  BZD: 0.000532  CAD: 0.000361  CDF: 0.738426  CHF: 0.000240  CLP: 0.251763
        CNY: 0.001924  CRC: 0.134210  CUP: 0.006385  CVE: 0.027026  CZK: 0.006214  DJF: 0.047280
        DKK: 0.001829  DOP: 0.015711  DZD: 0.035762  EGP: 0.012649  ERN: 0.003991  ETB: 0.015165
        EUR: 0.000245  FJD: 0.000599  FKP: 0.000210  FOK: 0.001829  GBP: 0.000210  GEL: 0.000712
        GGP: 0.000210  GHS: 0.003560  GIP: 0.000210  GMD: 0.018092  GNF: 2.276935  GTQ: 0.002070
        GYD: 0.055790  HKD: 0.002084  HNL: 0.006559  HRK: 0.001847  HTG: 0.035413  HUF: 0.095440
        IDR: 4.248214  ILS: 0.000981  IMP: 0.000210  INR: 0.022141  IQD: 0.350200  IRR: 11.690803
        ISK: 0.037020  JEP: 0.000210  JMD: 0.041076  JOD: 0.000189  JPY: 0.040395  KES: 0.034091
        KGS: 0.023837  KHR: 1.078319  KID: 0.000403  KMF: 0.120584  KRW: 0.360151  KWD: 0.000082
        KYD: 0.000222  KZT: 0.118872  LAK: 5.577491  LBP: 23.810141  LKR: 0.079466  LRD: 0.051536
        LSL: 0.004937  LYD: 0.001290  MAD: 0.002668  MDL: 0.004694  MGA: 1.170423  MKD: 0.014990
        MMK: 0.558582  MNT: 0.910471  MOP: 0.002146  MRU: 0.010592  MUR: 0.012285  MVR: 0.004100
        MWK: 0.462990  MXN: 0.004355  MYR: 0.001264  MZN: 0.017076  NAD: 0.004937  NGN: 0.340421
        NIO: 0.009777  NOK: 0.002845  NPR: 0.035425  NZD: 0.000440  OMR: 0.000102  PAB: 0.000266
        PEN: 0.000981  PGK: 0.001008  PHP: 0.015018  PKR: 0.073983  PLN: 0.001045  PYG: 1.952986
        QAR: 0.000968  RON: 0.001218  RSD: 0.028705  RUB: 0.024658  RWF: 0.342938  SAR: 0.000998
        SBD: 0.002226  SCR: 0.003595  SDG: 0.120613  SEK: 0.002813  SGD: 0.000358  SHP: 0.000210
        SLE: 0.006083  SLL: 6.082654  SOS: 0.152332  SRD: 0.009353  SSP: 0.413370  STN: 0.006005
        SYP: 3.441425  SZL: 0.004937  THB: 0.009699  TJS: 0.002869  TMT: 0.000917  TND: 0.000830
        TOP: 0.000631  TRY: 0.008551  TTD: 0.001796  TVD: 0.000403  TWD: 0.008532  TZS: 0.688658
        UAH: 0.010360  UGX: 1.024657  USD: 0.000266  UYU: 0.010158  UZS: 3.413405  VES: 0.009637
        VND: 6.697849  VUV: 0.031980  WST: 0.000733  XAF: 0.160778  XCD: 0.000718  XDR: 0.000200
        XOF: 0.160778  XPF: 0.029249  YER: 0.066584  ZAR: 0.004938  ZMW: 0.006593  ZWL: 0.003601

    To perform a conversion between different currencies, you can enter option 1.
    Enter a new option, or enter 'exit' to end the program.

************************************************************   
### 4. View country information based on the ISO code of its currency (e.g., COP -> Colombia).

    Enter the ISO code of the currency (e.g., COP).
    COP

    {
    "Name": {
        "Common": "Colombia",
        "Official": "Republic of Colombia",
        "NativeName": {
        "spa": {
            "Official": "República de Colombia",
            "Common": "Colombia"
        }
        }
    },
    "Flags": {
        "Png": "https://flagcdn.com/w320/co.png",
        "Svg": "https://flagcdn.com/co.svg",
        "Alt": "The flag of Colombia is composed of three horizontal bands of yellow, blue and red, with the yellow band twice the height of the other two bands."
    },
    "Currencies": {
        "COP": {
        "Name": "Colombian peso",
        "Symbol": "$"
        }
    },
    "Capital": [
        "Bogotá"
    ],
    "Population": 50882884,
    "Timezones": [
        "UTC-05:00"
    ]
    }

    Enter a new option, or enter 'exit' to end the program.

************************************************************   
### 5. View your conversion history.

    [{
        "FromCountry": "COP",
        "ToCountry": "USD",
        "Amount": 25500.0,
        "AmountConverted": 6.78402,
        "CreatedAt": "2024-04-10T18:34:25.650916200"
    }]
    
    Enter a new option, or enter 'exit' to end the program.