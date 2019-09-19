package com.terrasolis.bubbleSearch.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/* Import your Organization Entity there */

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Long>{

}