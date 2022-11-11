package com.github.luccassantos.uploadfiles.services;

import java.net.URL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.github.luccassantos.uploadfiles.dto.UriDTO;

@Service
public class FileService {
	
	@Autowired
	private S3Service s3Service;

	public UriDTO uploadFile(MultipartFile file) {
		URL url = s3Service.uploadFile(file);
		
		return new UriDTO(url.toString());
	}

}
