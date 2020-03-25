package com.example.demo;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.demo.entities.AssetType;
import com.example.demo.repository.AssetRepository;
import com.example.demo.repository.AssetTypeRepository;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext ctx =  SpringApplication.run(Application.class, args);
		AssetTypeRepository assetTypeRepository = ctx.getBean(AssetTypeRepository.class);
		
		
		assetTypeRepository.save(new AssetType("AST1", "BRA1", new Date(), new Date(), "FRU1"));
		assetTypeRepository.save(new AssetType("AST2", "BRA2", new Date(), new Date(), "FRU2"));
		assetTypeRepository.save(new AssetType("AST3", "BRA3", new Date(), new Date(), "FRU3"));
		assetTypeRepository.save(new AssetType("AST3", "BRA3", new Date(), new Date(), "FRU4"));
		
	}

}
