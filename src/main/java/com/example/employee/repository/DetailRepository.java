package com.example.employee.repository;

import java.util.List;

import com.example.employee.model.entity.Detail;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DetailRepository extends JpaRepository<Detail, Integer> {
  @Query(value = "select * from details where id_employee = ?", nativeQuery = true)
  List<Detail> findAllByIdEmployee(Integer idEmployee);
}
