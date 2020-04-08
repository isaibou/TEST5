package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import com.example.demo.storage.StorageProperties;
import org.springframework.context.ApplicationContext;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.boot.context.properties.EnableConfigurationProperties;
//import org.springframework.context.annotation.Bean;

import com.example.demo.entities.*;
import com.example.demo.repository.*;


@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class Application {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Application.class, args);		
		//AssetTypeRepository assettypeRepository = ctx.getBean(AssetTypeRepository.class);
		//AssetRepository assetRepository = ctx.getBean(AssetRepository.class);
		//FrimwareRepository frimwareRepository = ctx.getBean(FrimwareRepository.class);
		//List<Assets> assets = assetRepository.findAll();
	}

}
