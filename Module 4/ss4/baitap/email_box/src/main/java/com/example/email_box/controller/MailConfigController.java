package com.example.email_box.controller;

import com.example.email_box.model.MailConfig;
import com.example.email_box.service.IMailConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MailConfigController {

    @Autowired
    private IMailConfigService mailConfigService;

    @RequestMapping("/")
    public String redirectToMailConfig() {
        return "redirect:/mail-config";
    }

    @GetMapping("/mail-config")
    public String showConfigPage(Model model) {
        model.addAttribute("mailConfig", mailConfigService.getConfig());
        model.addAttribute("languages", new String[]{"English", "Vietnamese", "Japanese", "Chinese"});
        model.addAttribute("pageSizes", new int[]{5, 10, 15, 25, 50, 100});
        return "mail-config";
    }

    @PostMapping("/mail-config")
    public String updateConfig(@ModelAttribute("mailConfig") MailConfig mailConfig, Model model) {
        mailConfigService.updateConfig(mailConfig);
        model.addAttribute("resultConfig", mailConfig);
        return "result";
    }
}