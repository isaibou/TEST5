package com.example.demo.controllers;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.mail.Multipart;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entities.*;
import com.example.demo.repository.AssetRepository;
import com.example.demo.repository.ProjetRepository;
import com.example.demo.repository.RFPRepository;
import com.example.demo.repository.TechnologiePartnerRepository;
import com.example.demo.repository.TypeProjectRepository;

@Controller
public class ProjectController {
	
	@Autowired
	private TechnologiePartnerRepository technologiepartnerRepository;
	
	@Autowired
	private ProjetRepository ProjectRepository;
	@Autowired
	private TypeProjectRepository typeProjectRepository;
	@Autowired
	private RFPRepository rfprepository;
	@Autowired
	private AssetRepository assetRepository;
	
	@Value("${dir.project}")
	String projectFile;
	
	@RequestMapping(value="/projects")
	public String AllProject(Model model, Project project) {
		
			List<Project> projs = ProjectRepository.findAll();
			model.addAttribute("proj",projs);
			model.addAttribute("project", new Project());
			model.addAttribute("totalProject", projs.size());
			model.addAttribute("TechnoPart", technologiepartnerRepository.findAll());
			model.addAttribute("rfp",rfprepository.findAll() );
			model.addAttribute("TypeProject", typeProjectRepository.findAll());
			model.addAttribute("listAsset",assetRepository.findAll() );
			
			
		return "projects_manage";
	}

	@RequestMapping(value="/SaveProject" , method= RequestMethod.POST)
	private String SaveProject(@Valid  Project addProj, BindingResult bindingResult,  Model model,
			@RequestParam(name ="file")MultipartFile file )
			throws IllegalStateException, IOException {
		
		if(ProjectRepository.checkTitleExist(addProj.getName())) {
			
			model.addAttribute("unique", "must be unique");
			return "addProj";
		}
		
		if(bindingResult.hasErrors()) {
			return "addProj";
		}
		
		addProj.setStatus("Actif");

if (!(file.isEmpty())) {
			
			addProj.setDeliveryCertificate((file.getOriginalFilename()));

			file.transferTo(new File(projectFile+file.getOriginalFilename()));

}


		ProjectRepository.save(addProj);

		return "redirect:/projects";	
	}

	@RequestMapping(value ="/addProject")
	public String addProject( Model model ) {
		 model.addAttribute("project",new Project());
		 model.addAttribute("TechnoPart", technologiepartnerRepository.findAll());
		 model.addAttribute("rfp",rfprepository.findAll());
		 model.addAttribute("TypeProject", typeProjectRepository.findAll());
		 
		 model.addAttribute("TechnologiePartnerRepository", technologiepartnerRepository.findAll());

			return "addProj";
			
	}
	    
	@RequestMapping(value = "/editProject",method = { RequestMethod.GET, RequestMethod.POST })
	public String updateProject(Model model, @Valid Project proj, BindingResult bindingResult,
			@RequestParam(name ="file")MultipartFile file)  
					throws IllegalStateException, IOException{

if (!(file.isEmpty())) {
			
			proj.setDeliveryCertificate((file.getOriginalFilename()));

			file.transferTo(new File(projectFile+file.getOriginalFilename()));
		}
		ProjectRepository.save(proj);
		
		return "redirect:/projects";
	}
	
	@RequestMapping(value ="/updateProject")
	public String updateProjectForm( Model model, Integer id ) {
		
	Project	project = ProjectRepository.getOne(id);
		 model.addAttribute("project",project);
		 model.addAttribute("TechnoPart", technologiepartnerRepository.findAll());
		 model.addAttribute("rfp",rfprepository.findAll());
		 model.addAttribute("TypeProject", typeProjectRepository.findAll());
		 
		 model.addAttribute("TechnologiePartnerRepository", technologiepartnerRepository.findAll());
		 model.addAttribute("type",typeProjectRepository.findAll());
		 
		 System.out.println(project.getName());
		
			return "updateProj";
			
	}
	
	@RequestMapping(value ="/detailProject")
	public String detailProject( Model model, Integer id ) {
		
	     Project	project = ProjectRepository.getOne(id);
	     
		 model.addAttribute("project",project);
		 model.addAttribute("rfp", project.getRfp());

		// model.addAttribute("TechnPart", project.getTechnologypartner());
		 
		
		 
		// List<TechnologyPartner> Tp = (List<TechnologyPartner>) project.getTechnologypartner();
		 //model.addAttribute("listTp",Tp );
  
		 model.addAttribute("TechnPart", project.getTechnologypartner());

		 System.out.println(project.getTechnologypartner());
			return "detailProj";
			
	}

	@RequestMapping(value ="/archiverProject" )
	private String archiverProject( Model model, Integer id ) {
	
	Project proj = ProjectRepository.getOne(id);
	proj.setStatus("Archived");
	ProjectRepository.save(proj);
	System.out.println(proj.getStatus());
		
			return "redirect:/projects";	
	}
	
	
	@RequestMapping(value="/projectFile/{fileName}")
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
			FileInputStream fis = new FileInputStream(projectFile+fileName);
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