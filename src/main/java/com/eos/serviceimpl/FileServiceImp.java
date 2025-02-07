package com.eos.serviceimpl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.eos.service.FileService;


@Service
public class FileServiceImp implements FileService {
	
	@Value("${file.upload-dir}")
	private String path;

	@Override
	public String uploadImage(String path, MultipartFile file, String aadhaarNumber) throws IOException {
	    String name = file.getOriginalFilename();
	    if (name == null || name.isEmpty()) {
	        throw new IOException("Invalid file name");
	    }

	    String fileExtension = name.substring(name.lastIndexOf("."));
	    String fileName = aadhaarNumber + fileExtension;
	    String filePath = path + File.separator + fileName;

//	    System.out.println("File Path: " + filePath);

	    File directory = new File(path);
	    if (!directory.exists()) {
	        if (!directory.mkdirs()) {
	            throw new IOException("Failed to create directory: " + path);
	        }
	    }

	    try {
	        Files.copy(file.getInputStream(), Paths.get(filePath));
	    } catch (IOException e) {
	        e.printStackTrace();  
	        throw new IOException("Failed to upload file", e);
	    }

	    return fileName;
	}


}
