package com.example.demo;

import java.util.Date;
//
//<<<<<<< HEAD
//=======
import java.util.List;
//>>>>>>> branch 'master' of https://github.com/isaibou/TEST5

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.demo.entities.AssetType;
//<<<<<<< HEAD
import com.example.demo.repository.AssetRepository;
import com.example.demo.repository.AssetTypeRepository;
import com.example.demo.repository.FrimwareRepository;
//=======
import com.example.demo.entities.Assets;

import com.example.demo.entities.Customer;
import com.example.demo.entities.Frimware;
import com.example.demo.repository.AssetRepository;
import com.example.demo.repository.AssetTypeRepository;



@SpringBootApplication
public class Application {

	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(Application.class, args);
		AssetTypeRepository assettypeRepository = ctx.getBean(AssetTypeRepository.class);
		AssetRepository assetRepository = ctx.getBean(AssetRepository.class);
		FrimwareRepository frimwareRepository = ctx.getBean(FrimwareRepository.class);
		

		 
		 
		 frimwareRepository.save(new Frimware(new Date(), "Frimware1", "frimware2","Status1"));
		 
		 
		 



		 assettypeRepository.save(new AssetType("sasa", "ddd", new Date(), new Date(),"sss", "Status1"));
		
		 
		
		 
		assetRepository.save(new Assets("asset1", "asset2", "asset3", "asset4", "asset5", new Date(), "asset6", "asset7", "asset8", 0, new Date()));
		 
		
		
		
		
		
		
		
		List<Assets> assets = assetRepository.findAll();
	
		 
		
		
		 
		assetRepository.save(new Assets("asset1", "asset2", "asset3", "asset4", "asset5", new Date(), "asset6", "asset7", "asset8", 0, new Date()));
		 
		
		
		
		
		
		 List<AssetType> assettype = assettypeRepository.findAll();
		 
		 
		 //assettype.forEach(c->System.out.println(c.getName()));

	}

}
