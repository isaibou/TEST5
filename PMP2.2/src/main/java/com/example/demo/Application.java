package com.example.demo;

import java.util.Date;
<<<<<<< HEAD
=======
import java.util.List;
>>>>>>> branch 'master' of https://github.com/isaibou/TEST5

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.demo.entities.AssetType;
<<<<<<< HEAD
import com.example.demo.repository.AssetRepository;
import com.example.demo.repository.AssetTypeRepository;
=======
import com.example.demo.entities.Assets;

import com.example.demo.entities.Customer;
import com.example.demo.repository.AssetRepository;
import com.example.demo.repository.AssetTypeRepository;

>>>>>>> branch 'master' of https://github.com/isaibou/TEST5

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
<<<<<<< HEAD
		ApplicationContext ctx =  SpringApplication.run(Application.class, args);
		AssetTypeRepository assetTypeRepository = ctx.getBean(AssetTypeRepository.class);
		
		
		assetTypeRepository.save(new AssetType("AST1", "BRA1", new Date(), new Date(), "FRU1"));
		assetTypeRepository.save(new AssetType("AST2", "BRA2", new Date(), new Date(), "FRU2"));
		assetTypeRepository.save(new AssetType("AST3", "BRA3", new Date(), new Date(), "FRU3"));
		assetTypeRepository.save(new AssetType("AST3", "BRA3", new Date(), new Date(), "FRU4"));
		
=======
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
>>>>>>> branch 'master' of https://github.com/isaibou/TEST5
	}

}
