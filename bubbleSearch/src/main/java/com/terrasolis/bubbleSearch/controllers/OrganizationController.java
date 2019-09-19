package com.terrasolis.bubbleSearch.controllers;

import java.util.List;

import javax.validation.Valid;

import com.terrasolis.bubbleSearch.entities.Organization;
import com.terrasolis.bubbleSearch.repositories.OrganizationRepository;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
class OrganizationController {
    @Autowired
    private OrganizationRepository organizationRepository;

    @GetMapping("/organizations")
    public List<Organization> browse() {
        return organizationRepository.findAll();
    }

    @GetMapping("/organizations/{id}")
    public Organization read(@PathVariable Long id) {
        return organizationRepository.findById(id).get();
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