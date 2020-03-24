package com.example.demo;

import java.util.Date;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.demo.entities.AssetType;
import com.example.demo.entities.Assets;

import com.example.demo.entities.Customer;
import com.example.demo.repository.AssetRepository;
import com.example.demo.repository.AssetTypeRepository;


@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Application.class, args);
		AssetTypeRepository assettypeRepository = ctx.getBean(AssetTypeRepository.class);
		AssetRepository assetRepository = ctx.getBean(AssetRepository.class);
		
		
		 
		
		 assettypeRepository.save(new AssetType("sasa", "ddd", new Date(), new Date(),"sss"));
		
		 assettypeRepository.save(new AssetType("sasa1", "ddd1", new Date(), new Date(),"sss1"));
		
		 assettypeRepository.save(new AssetType("sasa2", "ddd2", new Date(), new Date(),"sss2"));
		
		 
		assetRepository.save(new Assets("asset1", "asset2", "asset3", "asset4", "asset5", new Date(), "asset6", "asset7", "asset8", 0, new Date()));
		 
		assetRepository.save(new Assets("asset1", "asset2", "asset3", "asset4", "asset5", new Date(), "asset6", "asset7", "asset8", 0, new Date()));
		
		
		
		
		
		
		List<Assets> asset = assetRepository.findAll();
		
		
		 List<AssetType> assettype = assettypeRepository.findAll();
		 
		 
		 assettype.forEach(c->System.out.println(c.getName()));
	}

}
