package org.faisaldev.core;

import java.util.ArrayList;
import java.util.List;

public class Column<T> {
    private String name;
    private DataType type;
    private List<T> data;

    public Column(String name, DataType type) {
        this.name = name;
        this.type = type;
        this.data = new ArrayList<>();
    }

    public void add(Object value) {
        data.add((T) value);
    }

    public String getName() {
        return name;
    }

    public List<T> getData() {
        return data;
    }

    public DataType getType() {
        return type;
    }
}