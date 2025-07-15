package org.faisaldev.core;

public enum DataType {
    STRING,
    INTEGER,
    DOUBLE,
    BOOLEAN,
    DATE,
    LONG;

    public static DataType inferFrom(Object value) {
        if (value instanceof Integer) return INTEGER;
        if (value instanceof Double) return DOUBLE;
        if (value instanceof Long) return LONG;
        if (value instanceof Boolean) return BOOLEAN;
        if (value instanceof java.util.Date) return DATE;
        return STRING;
    }

    public static DataType inferFromString(String value) {
        try {
            Integer.parseInt(value);
            return INTEGER;
        } catch (NumberFormatException ignored) {}
        try {
            Double.parseDouble(value);
            return DOUBLE;
        } catch (NumberFormatException ignored) {}
        if (value.equalsIgnoreCase("true") || value.equalsIgnoreCase("false")) {
            return BOOLEAN;
        }
        return STRING;
    }
}
