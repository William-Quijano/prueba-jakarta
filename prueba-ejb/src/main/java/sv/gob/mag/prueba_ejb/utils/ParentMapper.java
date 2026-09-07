package sv.gob.mag.prueba_ejb.utils;

import sv.gob.mag.prueba.api.dto.ParentResponseDTO;
import sv.gob.mag.prueba_ejb.entities.Parent;


public class ParentMapper {


    public static ParentResponseDTO toResponseDTO(Parent entity) {
        if (entity == null) return null;


        return ParentResponseDTO.builder()
                .id(entity.getId())
                .code(entity.getCode())
                .name(entity.getName())
                .status(entity.getStatus() != null ? entity.getStatus().name() : null)
                .enabled(entity.getEnabled() != null ? entity.getEnabled() : null)
                .createdAt(entity.getCreatedAt() != null ? entity.getCreatedAt() : null)
                .build();
    }
}