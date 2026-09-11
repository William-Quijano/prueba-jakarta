package sv.gob.mag.prueba.web.services;

import jakarta.ejb.EJB;
import jakarta.enterprise.context.ApplicationScoped;
import org.modelmapper.ModelMapper;
import sv.gob.mag.dto.enums.EnabledEnum;
import sv.gob.mag.dto.request.ParentCreateRequestDTO;
import sv.gob.mag.dto.request.ParentUpdateRequestDTO;
import sv.gob.mag.dto.response.ParentDetailResponseDTO;
import sv.gob.mag.dto.response.ParentResponseDTO;
import sv.gob.mag.ejb.entities.Parent;
import sv.gob.mag.ejb.exceptions.BusinessException;
import sv.gob.mag.ejb.facades.ParentFacadeLocal;


import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;


@ApplicationScoped
public class ParentService {

    @EJB
    private ParentFacadeLocal parentFacade;

    ModelMapper modelMapper = new ModelMapper();


    public List<ParentResponseDTO> getAllParent(Integer page, Integer prePage) {
        List<Parent> parents = this.parentFacade.getAll(page, prePage);
        return parents.stream().map(parent -> {
            ParentResponseDTO dto = modelMapper.map(parent, ParentResponseDTO.class);
            if (parent.getParentDetails() != null && !parent.getParentDetails().isEmpty()) {
                List<ParentDetailResponseDTO> detailDTOs = parent.getParentDetails().stream()
                        .map(detail -> modelMapper.map(detail, ParentDetailResponseDTO.class))
                        .toList();
                dto.setParentDetails(detailDTOs);
            }
            return dto;
        }).toList();
    }

    public Long countAll() {
        return this.parentFacade.countAll();
    }

    public void registerParent(ParentCreateRequestDTO parentCreateRequestDTO) {
        Parent parent = new Parent();
        if (parentCreateRequestDTO.getName().isEmpty()) {
            throw new BusinessException("El nombre es obligatorio");
        }
        parent.setName(parentCreateRequestDTO.getName());
        this.parentFacade.save(parent);
    }

    public ParentResponseDTO getParent(Long idParent) {
        if (idParent == null) {
            throw new BusinessException("El id del registro es requerido");
        }

        Parent parent = this.parentFacade.findById(idParent)
                .orElseThrow(() -> new BusinessException("El id brindado no existe"));

        modelMapper.typeMap(Parent.class, ParentResponseDTO.class)
                .addMappings(mapper -> mapper.skip(ParentResponseDTO::setParentDetails));

        return modelMapper.map(parent, ParentResponseDTO.class);
    }

    public void updateParent(ParentUpdateRequestDTO parentUpdateRequestDTO) {
        if (parentUpdateRequestDTO.getId() == null) {
            throw new BusinessException("El id del registro es requerido");
        }

        Parent parent = this.parentFacade.findById(parentUpdateRequestDTO.getId())
                .orElseThrow(() -> new BusinessException("El registro a actualizar no existe"));

        parent.setName(parentUpdateRequestDTO.getName());
        parent.setStatus(parentUpdateRequestDTO.getStatus());

        this.parentFacade.update(parent);
    }

    public void removeParent(Long idParent) {
        if (idParent == null) {
            throw new BusinessException("El id del registro es requerido");
        }
        Parent parent = this.parentFacade.findById(idParent)
                .orElseThrow(() -> new BusinessException("El registro a actualizar no existe"));

        this.parentFacade.remove(parent);
    }

    public void updateEnableParent(EnabledEnum enabled) {

        Parent parent = new Parent();
        parent.setEnabled(enabled);
        this.parentFacade.updateEnabled(parent);
    }
}
