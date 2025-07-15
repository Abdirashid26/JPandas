package org.faisaldev.core;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class DataFrame {
    private List<Column<?>> columns;
    private List<Row> rows;

    public DataFrame(List<Column<?>> columns, List<Row> rows) {
        this.columns = columns;
        this.rows = rows;
    }

    public void show(int numberOfRows) {
        if (columns == null || columns.isEmpty()) {
            System.out.println("Empty DataFrame");
            return;
        }

        for (Column<?> col : columns) {
            System.out.print(col.getName() + "\t");
        }
        System.out.println();

        // Print first 10 rows
        for (int i = 0; i < Math.min(numberOfRows, rows.size()); i++) {
            Row row = rows.get(i);
            for (Column<?> col : columns) {
                System.out.print(row.get(col.getName()) + "\t");
            }
            System.out.println();
        }
    }

    public List<Column<?>> getColumns() {
        return columns;
    }

    public List<Row> getRows() {
        return rows;
    }


    public DataFrame filter(Predicate<Row> condition) {
        List<Row> filteredRows = rows.stream()
                .filter(condition)
                .toList();

        return new DataFrame(columns, filteredRows);
    }


    public DataFrame select(String... columnNames) {
        List<Column<?>> selectedColumns = new ArrayList<>();
        List<Row> selectedRows = new ArrayList<>();

        // Create new column definitions
        for (String name : columnNames) {
            Column<?> col = columns.stream()
                    .filter(c -> c.getName().equals(name))
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("Column not found: " + name));
            selectedColumns.add(new Column<>(col.getName(), col.getType()));
        }

        for (Row row : rows) {
            Row newRow = new Row();
            for (String name : columnNames) {
                newRow.put(name, row.get(name));
            }
            selectedRows.add(newRow);
        }

        return new DataFrame(selectedColumns, selectedRows);
    }


}

