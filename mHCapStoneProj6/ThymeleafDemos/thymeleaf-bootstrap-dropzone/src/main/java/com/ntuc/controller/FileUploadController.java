package com.ntuc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping("/upload")
public class FileUploadController {
	
	Logger log =  LoggerFactory.getLogger(getClass());

    @PostMapping
    public void upload(@RequestParam("file") MultipartFile file) {
        log.info("uploaded file " + file.getOriginalFilename());
    }
}