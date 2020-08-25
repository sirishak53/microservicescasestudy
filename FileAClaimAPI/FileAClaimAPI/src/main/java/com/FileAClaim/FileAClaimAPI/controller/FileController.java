package com.FileAClaim.FileAClaimAPI.controller;

import com.FileAClaim.FileAClaimAPI.model.UploadFileResponse;
import com.FileAClaim.FileAClaimAPI.service.FileStorageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


@RestController
@RequestMapping(value = "/api")
public class FileController {

    private static final Logger logger = LoggerFactory.getLogger(FileController.class);

    @Autowired
    private FileStorageService fileStorageService;

    /**
     * This is invoked when user uploads the claim documents
     *
     * @param file
     * @param customer_id
     * @param policy_number
     * @return
     */
    @PostMapping("/uploadFile")
    public UploadFileResponse uploadFile(@RequestParam("file") MultipartFile file, String customer_id, String policy_number) {

        try {

            String fileName = fileStorageService.storeFile(file, customer_id, policy_number);

            String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("/downloadFile/")
                    .path(fileName)
                    .toUriString();

            return new UploadFileResponse(fileName, fileDownloadUri, file.getContentType(), file.getSize());


        } catch (Exception e) {
            e.printStackTrace();
            return new UploadFileResponse("Invalid inputs");
        }

    }


//    @GetMapping("/downloadFile/{fileName:.+}")
//    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request) {
//        Resource resource = fileStorageService.loadFileAsResource(fileName);
//        String contentType = null;
//
//        try {
//            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
//        } catch (IOException ex) {
//            logger.info("could not determine file type.");
//        }
//        if (contentType == null) {
//            contentType = "application/octet-stream";
//        }
//        return ResponseEntity.ok()
//                .contentType(MediaType.parseMediaType(contentType))
//                .header(HttpHeaders.CONTENT_DISPOSITION, "attachement; file=\"" + resource.getFilename() + "\"")
//                .body(resource);
//    }
}
