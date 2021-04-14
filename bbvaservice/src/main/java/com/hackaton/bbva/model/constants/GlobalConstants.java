package com.hackaton.bbva.model.constants;

public class GlobalConstants {
    // ERROR MESSAGES CONFIG_QUERYS
    public static final String CONFIG_QUERY_NOT_FOUND = "No exite la configuración con el ID: %d";
    public static final String CONFIG_QUERY_NOT_FOUND_CODE = "No exite la configuración con el Código: %s";
    public static final String CONFIG_QUERY_SAVE_FAILED = "Error al guardar la configuración de la consulta";
    // ERROR EN EL INTERMEDIARIO
    public static final String CONFIG_API_ERROR = "Error al consultar la API";

    public static final String EMPTY = "";

    // PALABRAS RESERVADAS EN QUERYS
    public static final String WHERE = "<WHERE>";
    public static final String WHERE_TRUE = " WHERE 1 = 1 ";


    // COLUMN + OPERATOR + VALUE
    // TEXT, DATE, NUMBER
    public static final String AND = " AND " + GlobalConstants.META_COLUMN + " " + GlobalConstants.META_OPERATOR + " " + GlobalConstants.META_VALUE + " ";
    // TEXT, DATE, NUMBER
    public static final String AND_MULTIPLE = " AND " + GlobalConstants.META_COLUMN + " " + GlobalConstants.META_OPERATOR + " (" + GlobalConstants.META_VALUE + ") ";
    // TEXT
    public static final String AND_TEXT = " AND UPPER(TRIM(" + GlobalConstants.META_COLUMN + ")) " + GlobalConstants.META_OPERATOR + " " + GlobalConstants.META_VALUE + " ";

    // NUMBER
    public static final String VALUE = GlobalConstants.META_VALUE;
    // TEXT, DATE
    public static final String VALUE_TEXT = "'" + GlobalConstants.META_VALUE + "'";
    // TEXT
    public static final String VALUE_TEXT_LIKE = "'%" + GlobalConstants.META_VALUE + "%'";

    public static final String META_COLUMN = "<COLUMN>";
    public static final String META_OPERATOR = "<OPERATOR>";
    public static final String META_VALUE = "<VALUE>";
    public static final String META = "<%s>";

    // DELIMITER
    public static final String DELIMITER = ",";
}