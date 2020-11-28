package com.example.employee.assembler;

import com.example.employee.model.dto.Request;
import com.example.employee.model.entity.Position;

import org.springframework.stereotype.Component;

@Component
public class PositionAssembler implements InterfaceAssembler<Position, Request> {

  @Override
  public Position fromDto(Request dto) {
    // TODO Auto-generated method stub
    if (dto == null)
      return null;

    Position position = new Position();

    if (dto.getPositionName() != null)
      position.setPositionName(dto.getPositionName());

    return position;
  }

  @Override
  public Request fromEntity(Position entity) {
    // TODO Auto-generated method stub
    if (entity == null)
      return null;
    
    return Request.builder().positionName(entity.getPositionName()).build();
  }

}
