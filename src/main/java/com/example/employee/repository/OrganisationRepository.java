package com.example.employee.repository;

import com.example.employee.model.entity.Organisation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganisationRepository extends JpaRepository<Organisation, Integer> {
  @Query(value = "select organisation_id from organisations where organisation_code = ?", nativeQuery = true)
  Integer findIdByOrganisationCode(String organisationCode);

  Organisation findByOrganisationCode(String organisationCode);
}
