package com.example.exam.CSVExporter;

import com.example.exam.Album.AlbumEntity;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class CSVExporter {
    private final String CSV_FILE = "./employee_info.csv";

    public void createCSVFile(String employeeId, ArrayList<AlbumEntity> album)  throws IOException {
        try (
                BufferedWriter writer = Files.newBufferedWriter(Paths.get(CSV_FILE));
                CSVPrinter printer = new CSVPrinter(writer, CSVFormat.DEFAULT.withHeader("EmployeeId", "Id", "AlbumId", "Title", "Url", "ThumbnailUrl", "Error"));
        ) {
            album.forEach(alb -> {
                try {
                    printer.printRecord(employeeId, alb.getId(), alb.getAlbumId(), alb.getTitle(), alb.getUrl(), alb.getThumbnailUrl());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            printer.flush();
            System.out.println("CSV exported");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
