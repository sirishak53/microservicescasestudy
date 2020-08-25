package com.FileAClaim.FileAClaimAPI.service;

import com.FileAClaim.FileAClaimAPI.config.FileStorageProperties;
import com.FileAClaim.FileAClaimAPI.exception.FileStorageException;
import com.FileAClaim.FileAClaimAPI.exception.MyFileNotFoundException;
import com.FileAClaim.FileAClaimAPI.model.FileClaim;
import com.FileAClaim.FileAClaimAPI.repository.FileClaimRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class FileStorageService {

    private Path fileStorageLocation = Paths.get("uploads");

    @Autowired
    private FileClaimRepository fileClaimRepository;

    @Autowired
    public FileStorageService(FileStorageProperties fileStorageProperties) {

        try {
            Files.createDirectories(this.fileStorageLocation);
        } catch (Exception ex) {
            throw new FileStorageException("could not create the directory  where the uploaded files will be stored", ex);
        }
    }

    public String storeFile(MultipartFile file, String customer_id, String policy_number) {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        try {
            if (fileName.contains("..")) {
                throw new FileStorageException("Sorry file name contains invalid path sequence" + fileName);
            }
            Path targetLocation = this.fileStorageLocation.resolve(fileName);

            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

            FileClaim fileClaim = new FileClaim();
            //fileClaim.setFile(file.getBytes());
            fileClaim.setCustomer_id(customer_id);
            fileClaim.setPolicy_number(policy_number);
            fileClaim.setFile_name(file.getOriginalFilename());
            fileClaim.setClaim_status("Documents uploaded successfully");
            fileClaimRepository.save(fileClaim);

            return fileName;

        } catch (IOException ex) {
            throw new FileStorageException("could not store file" + fileName + ".please try again", ex);
        }
    }

    public Resource loadFileAsResource(String fileName) {
        try {
            Path filePath = this.fileStorageLocation.resolve(fileName).normalize();
            Resource resource = new UrlResource(filePath.toUri());
            if (resource.exists()) {
                return resource;
            } else {
                throw new MyFileNotFoundException("file not found" + fileName);
            }
        } catch (MalformedURLException ex) {
            throw new MyFileNotFoundException("file not found" + fileName);

        }
    }
}
