# Java Currency Converter

Este es un proyecto para el programa ONE G6 junto con Alura LATAM para la especialización BackEnd con Java. 
El objetivo de este proyecto es desarrollar un conversor de divisa, en mi desarrollo, el conversor cuenta con diferentes funciones, incluyendo las siguientes:

    1- Convertir cantidad de una divisa a otra (Ej: 436000.0 COP a USD).
    2- Ver los códigos ISO que se pueden convertir (Ej: COP, USD, JPY).
    3- Ver la taza de cambio actual de una moneda (Ej: COP).
    4- Ver información del país a partir del código ISO de su moneda (Ej: COP -> Colombia).
    5- Ver tu historial de conversiones.

El menú de opciones está disponible en inglés y español.

Se hizo uso de la API [ExchangeRate-API](https://www.exchangerate-api.com/) para obtener la tasa de cambio de los valores de divisa y así mismo mostrar un listado de las monedas disponibles para la conversión. En este caso se realizó una petición GET al enlace https://open.er-api.com/v6/latest/COP, en dónde COP representa el código ISO de la moneda de Colombia, obteniendo así la siguiente respuesta.

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


Por otra parte, se hizo uso de la API [REST Countries](https://restcountries.com/) para obtener información de un país a partir del código ISO de su moneda. En este caso se realizó una petición GET al enlace https://restcountries.com/v3.1/currency/COP?fields=name,capital,currencies,population,flags,timezones, el cual cuenta con un filtrado por campos para evitar obtener una respuesta demasiado extensa.

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

Una vez iniciado el programa, se le presenta al usuario la opción de elegir entre idioma español o inglés a través del siguiente texto:

    Para iniciar el programa en idioma español ingrese 'español'.
    To start the program in English language enter 'english'.

Seguidamente se presenta el menu con las funcionalidades:

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

A continuación se presenta un ejemplo de uso.

************************************************************
### 1. Convertir cantidad de una divisa a otra (Ej: 436000.0 COP a USD).

    Ingresa el código ISO de la moneda de origen (Ej: COP).
    COP
    Ingresa el código ISO de la moneda de destino (Ej: USD).
    USD
    Ingresa la cantidad para el cambio de divisa (Ej. 436000.0).
    25500
    Resultado: 6.78402 USD
    Para ver el historial de conversiones puede ingresar la opción 5.
    Ingrese una nueva opción, o ingrese 'salir' para finalizar el programa.

************************************************************   
### 2. Ver los códigos ISO que se pueden convertir (Ej: COP, USD, JPY).

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

    Para más información sobre el país de origen de cualquier moneda puede ingresar la opción 4.
    Ingrese una nueva opción, o ingrese 'salir' para finalizar el programa.

************************************************************   
### 3. Ver la taza de cambio actual de una moneda (Ej: COP).

    Ingresa el código ISO de la moneda (Ej: COP).
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

    Para realizar una conversión entre diferentes monedas puede ingresar la opción 1.
    Ingrese una nueva opción, o ingrese 'salir' para finalizar el programa.

************************************************************   
### 4. Ver información del país a partir del código ISO de su moneda (Ej: COP -> Colombia).

    Ingresa el código ISO de la moneda (Ej: COP).
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

    Ingrese una nueva opción, o ingrese 'salir' para finalizar el programa.

************************************************************   
### 5. Ver tu historial de conversiones.

    [{
        "FromCountry": "COP",
        "ToCountry": "USD",
        "Amount": 25500.0,
        "AmountConverted": 6.78402,
        "CreatedAt": "2024-04-10T15:29:21.169090600"
    }]

    Ingrese una nueva opción, o ingrese 'salir' para finalizar el programa.