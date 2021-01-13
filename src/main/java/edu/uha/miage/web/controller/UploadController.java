package edu.uha.miage.web.controller;

import edu.uha.miage.core.service.StorageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UploadController {
    private final Logger LOGGER = LoggerFactory.getLogger(UploadController.class);
    private final StorageService storageService;
    @Autowired
    public UploadController(StorageService storageService) {
            this.storageService = storageService;
    }
    
    @GetMapping("/upload/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> getFile(@PathVariable String filename) {
        LOGGER.error("GET IN UPLOAD");
        Resource f = storageService.loadAsResource(filename);
        LOGGER.error(f.getFilename());
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + filename + "\"").body(f);
    }
}
