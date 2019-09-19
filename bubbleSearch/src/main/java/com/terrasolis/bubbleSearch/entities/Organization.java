package com.terrasolis.bubbleSearch.entities;

import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Organization {
    public Organization(){
    }

    public Organization(String name, String mission, String domain, String address, String contact, String website, String typo, String logo, String twitter){
        this.name = name;
        this.mission = mission;
        this.domain = domain;
        this.address = address;
        this.contact = contact;
        this.website = website;
		this.typo = typo;
		this.logo = logo;
		this.twitter = twitter;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String mission;
    private String domain;
    private String address;
    private String contact;
    private String website;
	private String typo;
	private String logo;
	private String twitter;
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMission() {
		return mission;
	}

	public void setMission(String mission) {
		this.mission = mission;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getTypo() {
		return typo;
	}

	public void setTypo(String typo) {
		this.typo = typo;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getTwiter() {
		return twitter;
	}

	public void setTwiter(String twitter) {
		this.twitter = twitter;
	}
}
