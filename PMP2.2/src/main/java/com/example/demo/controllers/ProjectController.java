package com.example.demo.controllers;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.entities.*;
import com.example.demo.exception.OrderDate;
import com.example.demo.repository.ProjetRepository;
import com.example.demo.repository.TechnologiePartnerRepository;
//import com.example.demo.storage.StorageService;

@Controller
public class ProjectController {
	
	@Autowired
	private TechnologiePartnerRepository technologiepartnerRepository;
	
	@Autowired
	private ProjetRepository ProjectRepository;

	@RequestMapping(value="/projects_manage")
	public String AllProject(Model model, Project project) {
		
			List<Project> projs = ProjectRepository.findAll();
			model.addAttribute("proj",projs);
			model.addAttribute("project", new Project());
			
			model.addAttribute("TechnologiePartnerRepository", technologiepartnerRepository.findAll());
			
		return "projects_manage";
	}

	@RequestMapping(value="/SaveProject" , method= RequestMethod.POST)
	private String SaveProject(@Valid Project addProj, BindingResult bindingResult) {
		addProj.setStatus("Actif");

		/*if (addProj.getDeliveryDate().after(addProj.getTemporayAcceptanceDate()) && addProj.getTemporayAcceptanceDate().before(addProj.getFinalTemporaryDate())) {
			ProjectRepository.save(addProj);
		}
	 else {
		try {
		 throw new OrderDate("Vous devez saisir DeliveryDate sub a TemporayAcceptanceDate ou TemporayAcceptanceDate inf a FinalTemporaryDate" );
		 } 

		 catch (Exception e) {
				
			throw new OrderDate("Vous devez saisir DeliveryDate sub a TemporayAcceptanceDate ou TemporayAcceptanceDate inf a FinalTemporaryDate", e);
		}
	 }*/
		ProjectRepository.save(addProj);
		return "redirect:/projects_manage";	
	}

	/*private StorageService storageService;

    public ProjectController(StorageService storageService) {
        this.storageService = storageService;
    }

    @GetMapping("/")
    public String listAllFiles(Model model) {

        model.addAttribute("files", storageService.loadAll().map(
                path -> ServletUriComponentsBuilder.fromCurrentContextPath()
                        .path("/download/")
                        .path(path.getFileName().toString())
                        .toUriString())
                .collect(Collectors.toList()));

        return "listFiles";
    }

    @GetMapping("/download/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> downloadFile(@PathVariable String filename) {

        Resource resource = storageService.loadAsResource(filename);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }

    @PostMapping("/upload-file")
    @ResponseBody
    public Project uploadFile(@RequestParam("file") MultipartFile file, @Valid Project addProj) {
        String deliveryCertificate = storageService.store(file);

        String uri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/download/")
                .path(deliveryCertificate)
                .toUriString();

        ProjectRepository.save(addProj);
        return new Project(deliveryCertificate, uri, file.getContentType(), file.getSize());
    }*/

   /* @PostMapping("/upload-multiple-files")
    @ResponseBody
    public List<Project> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
        return Arrays.stream(files)
                .map(file -> uploadFile(file))
                .collect(Collectors.toList());
    }*/
    
	@RequestMapping(value = "/editProject",method = { RequestMethod.GET, RequestMethod.POST })
	public String updateProject(Model model, @Valid Project proj, BindingResult bindingResult){

		ProjectRepository.save(proj);
		
		return "redirect:/projects_manage";
	}
	
	@RequestMapping(value ="/updateProject")
	public String updateProjectForm( Model model, Integer id ) {
		
	Project	project = ProjectRepository.getOne(id);
		 model.addAttribute("project",project);
		 
		 model.addAttribute("TechnologiePartnerRepository", technologiepartnerRepository.findAll());
		 
		 System.out.println(project.getName());
		
			return "updateProj";
			
	}
	
	@RequestMapping(value ="/detailProject")
	public String detailProject( Model model, Integer id ) {
		
	Project	project = ProjectRepository.getOne(id);
		 model.addAttribute("project",project);
		 System.out.println(project.getName());
		
			return "detailProj";
			
	}

	@RequestMapping(value ="/archiverProject" )
	private String archiverProject( Model model, Integer id ) {
	
	Project proj = ProjectRepository.getOne(id);
	proj.setStatus("Archived");
	ProjectRepository.save(proj);
	System.out.println(proj.getStatus());
		
			return "redirect:/projects_manage";	
	}
}
