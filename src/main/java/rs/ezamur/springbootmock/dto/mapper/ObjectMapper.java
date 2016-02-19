package rs.ezamur.springbootmock.dto.mapper;

import rs.ezamur.springbootmock.dto.DTO;
import rs.ezamur.springbootmock.entity.Entity;

public interface ObjectMapper<E extends Entity, T extends DTO> {

    T toDTO(E entity);

    E toEntity(T dto);

}
