package com.closestpair.controller;

import com.closestpair.service.DistanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class FileUploadController {

    @Autowired
    private DistanceService distanceService;

    @GetMapping("/")
    public String listUploadedFiles() throws IOException {
        return "uploadForm";
    }

    @PostMapping("/")
    public String handleFileUpload(@RequestParam("file") MultipartFile multipartFile, Model model) throws IOException {
        String message = distanceService.findClosestPointsAndConstructMessage(multipartFile);
        model.addAttribute("message", message);

        return "resultForm";
    }

    @ExceptionHandler(Exception.class)
    public String handleException(Model model) {
        model.addAttribute("message", "Invalid file! Error occured!");
        return "resultForm";
    }
}
