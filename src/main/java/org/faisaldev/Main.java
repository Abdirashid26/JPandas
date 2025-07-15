package org.faisaldev;


import org.faisaldev.core.CsvReader;
import org.faisaldev.core.DataFrame;

public class Main {
    public static void main(String[] args) {

        CsvReader reader = new CsvReader();
        DataFrame df = reader.read("data/students.csv");
        df.show(10);
    }
}