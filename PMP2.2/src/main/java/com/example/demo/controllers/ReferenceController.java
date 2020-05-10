package com.example.demo.controllers;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entities.AssetType;
import com.example.demo.entities.Deliverable;
import com.example.demo.entities.Project;
import com.example.demo.entities.Purchasing;
import com.example.demo.entities.Reference;
import com.example.demo.entities.Users;
import com.example.demo.repository.ProjetRepository;
import com.example.demo.repository.ReferenceRepository;
import com.example.demo.repository.UserRepository;

@Controller
public class ReferenceController {
	
	@Autowired
	private ReferenceRepository referencerepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ProjetRepository projectRepository;
	@Value("${dir.referenceFile}")
	private String refFile;
	@Value("${dir.referencePicture}")
	private String refPicture;
	

	
	@RequestMapping(value="/reference")
	public String ReferenceManage(Model model, Authentication auth) {
		 
		Users u = userRepository.getOne(auth.getName());
		
		List<Reference> reference = referencerepository.findAll();
		List<Project> project =  projectRepository.findAll();
		model.addAttribute("reference", new Reference());
		model.addAttribute("totalReference", reference.size());
		model.addAttribute("user", u);
		model.addAttribute("listRef", reference);
		model.addAttribute("project", project);
		return "reference_manage";
	}

	@RequestMapping(value="/SaveReference")
	public String SaveReference(Model model, Reference ref, @RequestParam(name="file") MultipartFile file , @RequestParam(name="picture") MultipartFile picture) throws IllegalStateException, IOException {
		
if (!(file.isEmpty())) {
			
			ref.setReferenceFile((file.getOriginalFilename()));

			file.transferTo(new File(refFile+file.getOriginalFilename()));
		}
referencerepository.save(ref);

if (!(picture.isEmpty())) {
	
	ref.setPreviewPicture((picture.getOriginalFilename()));

	picture.transferTo(new File(refPicture+ref.getReference_ID()));
}

referencerepository.save(ref);
		
		return "redirect:/reference";
	}	
	
	@RequestMapping(value ="/addRef")
	public String addRef( Model model) {
		 model.addAttribute("ref",new Reference());
		 model.addAttribute("project", projectRepository.findAll());	
			return "addRefP";	
	}

	@RequestMapping(value ="/updateReference")
	public String updateReference( Model model, Integer id ) {
		
		Reference	ref = referencerepository.getOne(id);
		 model.addAttribute("ref",ref);
		 model.addAttribute("project", projectRepository.findAll());	
			return "updateReference";	
	}
	
	
	@RequestMapping(value="/editReference")
	public String editReference(Model model, Reference ref, @RequestParam(name="file") MultipartFile file , @RequestParam(name="picture") MultipartFile picture) throws IllegalStateException, IOException {
		
if (!(file.isEmpty())) {
			
			ref.setReferenceFile((file.getOriginalFilename()));

			file.transferTo(new File(refFile+file.getOriginalFilename()));
		}

if (!(picture.isEmpty())) {
	
	ref.setPreviewPicture((picture.getOriginalFilename()));

	picture.transferTo(new File(refPicture+ref.getReference_ID()));
}

referencerepository.save(ref);
		
		return "redirect:/reference";
	}	
	
	@RequestMapping(value ="/detailReference")
	public String detailReference( Model model, Integer id ) {
		
		 Reference	reference = referencerepository.getOne(id);
		 model.addAttribute("refere",reference);

		 model.addAttribute("project", projectRepository.findAll());
		
		
		 System.out.println(reference.getSignedBy());

		
			return "detailReference";
		
	}	
	
	@RequestMapping(value ="/deleteReference" )
	private String deleteReference( Model model, Integer id ) {
	
		referencerepository.deleteById(id);
		
		 return "redirect:/reference";	
	}
	
	@RequestMapping(value="/getReferenceFile" , produces= MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	private byte[] getDeliverable(String id) throws  IOException {
		File f = new File(refPicture+id);
		return  IOUtils.toByteArray(new FileInputStream(f));
	}



@RequestMapping(value="/ReferenceFile/{fileName}")
@ResponseBody
public void getdeliveryCertificate(@PathVariable("fileName")String fileName, HttpServletResponse response) {
	
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
		FileInputStream fis = new FileInputStream(refFile+fileName);
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
}
