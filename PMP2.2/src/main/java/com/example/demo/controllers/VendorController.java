package com.example.demo.controllers;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entities.Assets;
import com.example.demo.entities.Purchasing;
import com.example.demo.entities.Vendor;
import com.example.demo.repository.AssetRepository;
import com.example.demo.repository.VendorRepository;

@Controller
public class VendorController {
	
	@Autowired
	private VendorRepository vendorRepository;
	

	@Value("${dir.vendor}")
	private String certificate;
	
	@RequestMapping(value="/vendor")
	public String vendor(Model model, Vendor vendor) {
		
		List<Vendor> vendo = vendorRepository.findAll();
		model.addAttribute("vend",vendo);
		model.addAttribute("vendor", new Vendor());
		
		return "vendor";
	}
	
	@RequestMapping(value="/SaveVendor" , method= RequestMethod.POST)
	private String SaveVendor(@Valid Vendor addVen, @RequestParam(name="certificate")MultipartFile file) throws IllegalStateException, IOException {
		addVen.setStatus("Actif");
		
		
if (!(file.isEmpty())) {
			
			addVen.setPartnershipCertificate((file.getOriginalFilename()));

			file.transferTo(new File(certificate+file.getOriginalFilename()));
		}

		vendorRepository.save(addVen);
		
		

		return "redirect:/vendor";
		
	}
	
	@RequestMapping(value = "/editVendor",method = { RequestMethod.GET, RequestMethod.POST })
	public String updateVendor(Model model, @Valid Vendor vend, BindingResult bindingResult, @RequestParam(name="certificate")MultipartFile file) throws IllegalStateException, IOException{
        
		vend.setStatus("Actif");
		
		
if (!(file.isEmpty())) {
			
			vend.setPartnershipCertificate((file.getOriginalFilename()));

			file.transferTo(new File(certificate+file.getOriginalFilename()));
		}
		vendorRepository.save(vend);
		
		return "redirect:/vendor";
		
		
	}
	
	
	@RequestMapping(value="/file/{fileName}")
	@ResponseBody
	public void getFileCertificate(@PathVariable("fileName")String fileName, HttpServletResponse response) {
		
		if (fileName.indexOf(".doc")>-1) response.setContentType("application/msword");
		if (fileName.indexOf(".docx")>-1) response.setContentType("application/msword");
		if (fileName.indexOf(".xls")>-1) response.setContentType("application/vnd.ms-excel");
		if (fileName.indexOf(".csv")>-1) response.setContentType("application/vnd.ms-excel");
		if (fileName.indexOf(".ppt")>-1) response.setContentType("application/ppt");
		if (fileName.indexOf(".pdf")>-1) response.setContentType("application/pdf");
		if (fileName.indexOf(".zip")>-1) response.setContentType("application/zip");

		response.setHeader("Content-Disposition","attachment; filename=" +fileName);
		response.setHeader("Content-Transfer-Encoding", "binary");
		
		try {
			BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());
			FileInputStream fis = new FileInputStream(certificate+fileName);
			int len; 
			byte[] buf = new byte[1024];
			while ((len = fis.read(buf)) >0) {
				bos.write(buf,0,len);
			}
			bos.close();
			response.flushBuffer();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	@RequestMapping(value ="/updateVendor")
	public String updateVendorForm( Model model, Integer id ) {
		
		Vendor	vendor = vendorRepository.getOne(id);
		 model.addAttribute("vendor",vendor);
		 
		
			return "updateVendorForm";
			
	}
	
	@RequestMapping(value ="/archiverVendor" )
	private String archiverAssets( Model model, Integer id ) {
	
		Vendor vendor = vendorRepository.getOne(id);
		vendor.setStatus("Archived");
		vendorRepository.save(vendor);
	    System.out.println(vendor.getStatus());
		
			return "redirect:/vendor";	
			
	}
	
	@RequestMapping(value ="/detailVendor")
	public String detailPurchasing( Model model, Integer id ) {
		
		Vendor	vendor = vendorRepository.getOne(id);
		 model.addAttribute("Vendor",vendor);
		
			return "detailVendor";
			
	}

}
