package com.github.luccassantos.uploadfiles.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.github.luccassantos.uploadfiles.dto.UriDTO;
import com.github.luccassantos.uploadfiles.services.FileService;

@Controller
public class FileResource {

	@Autowired
	private FileService service;

	public static String UPLOAD_DIRECTORY = System.getProperty("user.dir") + "/uploads";

	@GetMapping("/index")
	public String displayUploadForm() {
		return "pages/index";
	}

	
	@PostMapping(value="/file/save")
	public String uploadFile(Model model, @RequestParam("file") MultipartFile file) {
		
		if (file.isEmpty()) {
        	model.addAttribute("msg", "Por favor selecione o arquivo para upload.");
            return "pages/index";
        }
		
		UriDTO dto = service.uploadFile(file);
		model.addAttribute("link",dto.getUri());
		
		return "pages/index";
		
	}


}
