package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


import com.example.demo.repository.AssetRepository;
import com.example.demo.repository.AssetTypeRepository;
import com.example.demo.repository.FrimwareRepository;
import com.example.demo.repository.PurchisingRepository;

import com.example.demo.entities.*;
import com.example.demo.repository.*;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(Application.class, args);

		AssetTypeRepository assettypeRepository = ctx.getBean(AssetTypeRepository.class);
		AssetRepository assetRepository = ctx.getBean(AssetRepository.class);
		FrimwareRepository frimwareRepository = ctx.getBean(FrimwareRepository.class);

		PurchisingRepository purchisingRepository =ctx.getBean(PurchisingRepository.class);
		ContratRepository contratRepository =ctx.getBean(ContratRepository.class);
		VendorRepository vendorRepository =ctx.getBean(VendorRepository.class);
		
	}

}
