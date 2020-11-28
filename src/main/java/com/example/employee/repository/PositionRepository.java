package com.example.employee.repository;

import com.example.employee.model.entity.Position;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PositionRepository extends JpaRepository<Position, Integer> {
  @Query(value = "select position_id from positions where position_name = ?", nativeQuery = true)
  Integer findIdByPositionName(String positionName);

  Position findByPositionName(String positionName);
}
