package com.maurithiol.LoginSystem.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;

@Controller
public class UploadHandler {

    @GetMapping("/auth/dashboard/admin/profile/upload")
    public String showAdminUploadForm() {
        return "dashboard_admin_upload";
    }

    @GetMapping("/auth/dashboard/user/profile/upload")
    public String showUserUploadForm() {
        return "dashboard_user_upload";
    }

    @PostMapping("/auth/dashboard/admin/profile/upload/go")
    public String handleAdminFileUpload(@RequestParam("file")MultipartFile file, RedirectAttributes redirectAttributes) {
        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            return "redirect:/auth/dashboard/admin/profile/upload";
        }
        try {
            String rootPath = System.getProperty("user.dir") + "/src/main/resources";
            File uploadDir = new File(rootPath + File.separator + "static/uploads");
            if (!uploadDir.exists())
                uploadDir.mkdirs();
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            File destFile = new File(uploadDir.getAbsolutePath() + File.separator + authentication.getName() + ".jpg");
            file.transferTo(destFile);
            redirectAttributes.addFlashAttribute("message", "File uploaded successfully!");
        } catch (IOException e) {
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("message", "File upload failed!");
        }
        return "redirect:/auth/dashboard/admin/profile/upload";
    }

    @PostMapping("/auth/dashboard/user/profile/upload/go")
    public String handleUserFileUpload(@RequestParam("file")MultipartFile file, RedirectAttributes redirectAttributes) {
        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            return "redirect:/auth/dashboard/user/profile/upload";
        }
        try {
            String rootPath = System.getProperty("user.dir") + "/src/main/resources";
            File uploadDir = new File(rootPath + File.separator + "static/uploads");
            if (!uploadDir.exists())
                uploadDir.mkdirs();
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            File destFile = new File(uploadDir.getAbsolutePath() + File.separator + authentication.getName() + ".jpg");
            file.transferTo(destFile);
            redirectAttributes.addFlashAttribute("message", "File uploaded successfully!");
        } catch (IOException e) {
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("message", "File upload failed!");
        }
        return "redirect:/auth/dashboard/user/profile/upload";
    }

}