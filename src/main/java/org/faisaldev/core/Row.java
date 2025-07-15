package org.faisaldev.core;

import java.util.HashMap;
import java.util.Map;

public class Row {
    private Map<String, Object> values;

    public Row() {
        values = new HashMap<>();
    }

    public Object get(String columnName) {
        return values.get(columnName);
    }

    public void put(String columnName, Object value) {
        values.put(columnName, value);
    }

    public Map<String, Object> getValues() {
        return values;
    }

    @Override
    public String toString() {
        return values.toString();
    }
}