package com.cigna.test;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@Component
public class SQLFileWriter {

    @Value("${file.path}")
    private String outputPath;

    public void write(final List<Employee> input) throws IOException {
        FileWriter out = new FileWriter(outputPath);

        try (CSVPrinter printer = new CSVPrinter(out, CSVFormat.DEFAULT)) {
            input.stream().forEach(s -> {
                try {
                    printer.printRecords(s.getEeid(), s.getfName(), s.getlName(), s.getLanId(), s.getEmail());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
