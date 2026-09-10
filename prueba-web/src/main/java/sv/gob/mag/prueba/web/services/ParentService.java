package sv.gob.mag.prueba.web.services;

import jakarta.ejb.EJB;
import jakarta.enterprise.context.ApplicationScoped;
import org.modelmapper.ModelMapper;
import sv.gob.mag.dto.request.ParentCreateRequestDTO;
import sv.gob.mag.dto.request.ParentUpdateRequestDTO;
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
        return parents.stream()
                .map(parent -> modelMapper.map(parent, ParentResponseDTO.class))
                .toList();
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
        Parent parent = this.parentFacade.findById(idParent)
                .orElseThrow(() -> new BusinessException("El id brindado no existe"));

        modelMapper.typeMap(Parent.class, ParentResponseDTO.class)
                .addMappings(mapper -> mapper.skip(ParentResponseDTO::setParentDetails));

        return modelMapper.map(parent, ParentResponseDTO.class);
    }

    public ParentResponseDTO updateParent(ParentUpdateRequestDTO parentUpdateRequestDTO){
        Parent parent = this.parentFacade.findById(parentUpdateRequestDTO.getId())
                .orElseThrow(() -> new BusinessException("El registro a actualizar no existe"));

        parent.setName(request.getName());
        parent.setStatus(request.getStatus().name()); // O el tipo correspondiente en tu entidad

        this.parentFacade.update(parent); // O em.merge(parent) según tu implementación de EJB/Facade
    }
}
