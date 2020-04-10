package com.example.demo;

import java.util.Date;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import com.example.demo.storage.StorageProperties;
import org.springframework.context.ApplicationContext;
//import org.springframework.boot.CommandLineRunner;

//import org.springframework.boot.context.properties.EnableConfigurationProperties;
//import org.springframework.context.annotation.Bean;

import com.example.demo.entities.AssetType;
//<<<<<<< HEAD
import com.example.demo.repository.AssetRepository;
import com.example.demo.repository.AssetTypeRepository;
import com.example.demo.repository.FrimwareRepository;

import com.example.demo.entities.Assets;

import com.example.demo.entities.Customer;
import com.example.demo.entities.Frimware;
import com.example.demo.repository.AssetRepository;
import com.example.demo.repository.AssetTypeRepository;



import com.example.demo.entities.*;
import com.example.demo.repository.*;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class Application {

	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(Application.class, args);
		AssetTypeRepository assettypeRepository = ctx.getBean(AssetTypeRepository.class);
		AssetRepository assetRepository = ctx.getBean(AssetRepository.class);
		FrimwareRepository frimwareRepository = ctx.getBean(FrimwareRepository.class);
		
		//AssetTypeRepository assettypeRepository = ctx.getBean(AssetTypeRepository.class);
		//AssetRepository assetRepository = ctx.getBean(AssetRepository.class);
		//FrimwareRepository frimwareRepository = ctx.getBean(FrimwareRepository.class);
		//List<Assets> assets = assetRepository.findAll();

		/*
		 * 
		 * 
		 * assettypeRepository.save(new AssetType("sasa", "ddd", new Date(), new
		 * Date(),"sss", "Status1"));
		 * 
		 * 
		 * 
		 * 
		 * assetRepository.save(new Assets("asset1", "asset2", "asset3", "asset4",
		 * "asset5", new Date(), "asset6", "asset7", "asset8", 0, new Date()));
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * List<Assets> assets = assetRepository.findAll();
		 * 
		 * 
		 * 
		 * 
		 * 
		 * assetRepository.save(new Assets("asset1", "asset2", "asset3", "asset4",
		 * "asset5", new Date(), "asset6", "asset7", "asset8", 0, new Date()));
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * List<AssetType> assettype = assettypeRepository.findAll();
		 * 
		 * 
		 */		 //assettype.forEach(c->System.out.println(c.getName()));


	}

}
