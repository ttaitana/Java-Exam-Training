package com.example.exam.CSVExporter;

import com.example.exam.Album.AlbumEntity;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CSVExporter {
    private final String CSV_FILE = "./employee_info.csv";

    public void createCSVFile(AlbumEntity album) throws IOException {
        try (
                BufferedWriter writer = Files.newBufferedWriter(Paths.get(CSV_FILE));
                CSVPrinter printer = new CSVPrinter(writer, CSVFormat.DEFAULT.withHeader("Id", "AlbumId", "Title", "Url", "ThumbnailUrl"));
        ) {
            printer.printRecord(album.getId(), album.getAlbumId(), album.getTitle(), album.getUrl(), album.getThumbnailUrl());
            printer.flush();
            System.out.println("CSV exported");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
