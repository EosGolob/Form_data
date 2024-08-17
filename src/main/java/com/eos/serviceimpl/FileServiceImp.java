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

/**	@Override
	public String uploadImage(String path, MultipartFile file ,String aadhaarNumber) throws IOException {
	    String name = file.getOriginalFilename();
	    if (name == null || name.isEmpty()) {
	        throw new IOException("Invalid file name");
	    }

	    String randomID = UUID.randomUUID().toString();
	    String fileExtension = name.substring(name.lastIndexOf("."));
//	    String fileName1 = randomID.concat(name.substring(name.lastIndexOf(".")));
//	    String fileName = aadhaarNumber + "_" + randomID + fileExtension;
	    String fileName = aadhaarNumber + fileExtension;
	    String filePath = path + File.separator + fileName;
//	    String filePath = path + File.separator + fileName1;
	    File f = new File(path);
	    if (!f.exists()) {
	        if (!f.mkdirs()) {
	            throw new IOException("Failed to create directory: " + path);
	        }
	    }
	    Files.copy(file.getInputStream(), Paths.get(filePath));
	    return fileName;
	}
	*/
	@Override
	public String uploadImage(String path, MultipartFile file, String aadhaarNumber) throws IOException {
	    String name = file.getOriginalFilename();
	    if (name == null || name.isEmpty()) {
	        throw new IOException("Invalid file name");
	    }

	    String fileExtension = name.substring(name.lastIndexOf("."));
	    String fileName = aadhaarNumber + fileExtension;
	    String filePath = path + File.separator + fileName;

	    // Log the file path for debugging
	    System.out.println("File Path: " + filePath);

	    // Ensure the directory exists
	    File directory = new File(path);
	    if (!directory.exists()) {
	        if (!directory.mkdirs()) {
	            throw new IOException("Failed to create directory: " + path);
	        }
	    }

	    try {
	        Files.copy(file.getInputStream(), Paths.get(filePath));
	    } catch (IOException e) {
	        e.printStackTrace();  // Log the exception for debugging
	        throw new IOException("Failed to upload file", e);
	    }

	    return fileName;
	}


}
