package com.example.exam;

import com.example.exam.Album.AlbumEntity;
import com.example.exam.Album.AlbumGateway;
import com.example.exam.CSVExporter.CSVExporter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.ArrayList;

@SpringBootApplication
public class ExamApplication implements CommandLineRunner {

	@Autowired
	AlbumGateway gateway;

	CSVExporter exp = new CSVExporter();

    public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(ExamApplication.class, args);
		String[] objects = context.getBeanDefinitionNames();
		int count = context.getBeanDefinitionCount();
		System.out.println("Total: " + count);
    }

	@Override
	public void run(String... args) throws Exception {
		ArrayList<AlbumEntity> albums = gateway.getAlbumsByRange(2, 10);
		exp.createCSVFile(args[0], albums);
	}
}
