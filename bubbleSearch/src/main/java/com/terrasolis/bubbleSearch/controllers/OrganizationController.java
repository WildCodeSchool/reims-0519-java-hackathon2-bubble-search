package com.terrasolis.bubbleSearch.controllers;

import java.util.List;

import com.terrasolis.bubbleSearch.entities.Organization;
import com.terrasolis.bubbleSearch.repositories.OrganizationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class OrganizationController {

    @Autowired
    private OrganizationRepository organizationRepository;

    @GetMapping("/")
    public String index(Model model) {
        List<String> organizations = organizationRepository.findDistinctDomain();
        model.addAttribute("organizations", organizations);
        return "index";
    }
    
    @GetMapping("/search")
    public String browse(Model model) {
        List<Organization> organizations = organizationRepository.findAll();
        model.addAttribute("organizations", organizations);
        return "search";
    }

    @GetMapping("/organization/{id}")
    public String read(@PathVariable Long id, Model model) {
    Organization organization = organizationRepository.findById(id).get();
    model.addAttribute("organization", organization);
    return "terrasolis";
    }

}