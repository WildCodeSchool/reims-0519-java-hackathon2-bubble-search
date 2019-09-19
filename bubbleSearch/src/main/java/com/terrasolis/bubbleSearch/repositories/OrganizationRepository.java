package com.terrasolis.bubbleSearch.repositories;

import java.util.List;

import com.terrasolis.bubbleSearch.entities.Organization;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Long>{
    @Query(value="SELECT distinct domain from organization " , nativeQuery = true)
    List<Organization> findAllByDistinctAndByDomain();
}