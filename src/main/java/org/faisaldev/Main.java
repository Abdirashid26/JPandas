package org.faisaldev;


import org.faisaldev.core.CsvReader;
import org.faisaldev.core.DataFrame;

public class Main {
    public static void main(String[] args) {

        CsvReader reader = new CsvReader();
        DataFrame df = reader.read("data/students.csv");

        System.out.println("📋 Full Data:");
        df.show(10);

        System.out.println("\n🔍 Filtered Data (age >= 11):");
        DataFrame filtered = df.filter(row -> {
            Object value = row.get("age");
            return value instanceof Integer && (int) value >= 11;
        });

        filtered.show(10);
    }
}