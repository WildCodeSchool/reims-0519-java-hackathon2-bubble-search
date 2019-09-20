package com.terrasolis.bubbleSearch.controllers;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.terrasolis.bubbleSearch.entities.Organization;
import com.terrasolis.bubbleSearch.repositories.OrganizationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class OrganizationController {
    @Autowired
    private OrganizationRepository organizationRepository;

    @GetMapping("/")
    public String home(Model model) {
        List<String> organizations = organizationRepository.findDistinctDomain();
        model.addAttribute("organizations", organizations);
        return "index";
    }

    @GetMapping("/organizations")
    public String organizations(Model model) {
        List<Organization> organization = organizationRepository.findAll();
        model.addAttribute("organizations", organization);
        return "search";
    }   

    @GetMapping("/organizations/{id}")
    public String read(@PathVariable Long id, Model model) {
    Organization organization = organizationRepository.findById(id).get();
    model.addAttribute("organization", organization);
    return "terrasolis";
    } 

     @PutMapping("/organizations/{id}")
    public Organization edit(@Valid @ModelAttribute Organization organization) {
        return organizationRepository.save(organization);
    }   
     
    @PostMapping("/organizations")
    public Organization add(@Valid @ModelAttribute Organization organization) {
        return organizationRepository.save(organization);
    }   
    
    @DeleteMapping("/organizations/{id}")
    public void destroy(@PathVariable Long id) {
        organizationRepository.delete(
            organizationRepository.findById(id).get()
        );
    }
 }