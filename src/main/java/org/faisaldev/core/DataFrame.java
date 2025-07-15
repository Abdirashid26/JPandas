package org.faisaldev.core;

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

}

