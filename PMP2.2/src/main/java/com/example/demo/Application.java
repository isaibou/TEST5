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
//=======
import com.example.demo.entities.Assets;

import com.example.demo.entities.Customer;
import com.example.demo.repository.AssetRepository;
import com.example.demo.repository.AssetTypeRepository;

//>>>>>>> branch 'master' of https://github.com/isaibou/TEST5

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
//<<<<<<< HEAD
	
//=======
		ApplicationContext ctx = SpringApplication.run(Application.class, args);
		AssetTypeRepository assettypeRepository = ctx.getBean(AssetTypeRepository.class);
		AssetRepository assetRepository = ctx.getBean(AssetRepository.class);
		
		
		
		 List<AssetType> assettype = assettypeRepository.findAll();
		 
		 
		 assettype.forEach(c->System.out.println(c.getName()));
//>>>>>>> branch 'master' of https://github.com/isaibou/TEST5
	}

}
