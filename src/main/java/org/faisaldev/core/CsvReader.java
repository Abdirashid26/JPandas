package org.faisaldev.core;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvReader {

    public DataFrame read(String path) {
        List<Column<?>> columns = new ArrayList<>();
        List<Row> rows = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String headerLine = br.readLine();
            if (headerLine == null) throw new RuntimeException("Empty CSV file");

            String[] headers = headerLine.split(",");
            int colCount = headers.length;

            for (String header : headers) {
                columns.add(new Column<>(header.trim(), DataType.STRING)); // Temporary default type
            }

            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",", -1);
                Row row = new Row();

                for (int i = 0; i < colCount; i++) {
                    String colName = headers[i];
                    String raw = i < values.length ? values[i].trim() : "";
                    Object parsed = parse(raw);
                    columns.get(i).add(parsed);
                    row.put(colName, parsed);
                }

                rows.add(row);
            }

        } catch (IOException e) {
            throw new RuntimeException("Failed to read CSV: " + e.getMessage());
        }

        return new DataFrame(columns, rows);
    }

    private Object parse(String s) {
        if (s.isEmpty()) return null;

        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException ignored) {}

        try {
            return Double.parseDouble(s);
        } catch (NumberFormatException ignored) {}

        if (s.equalsIgnoreCase("true") || s.equalsIgnoreCase("false")) {
            return Boolean.parseBoolean(s);
        }

        return s;
    }
}
