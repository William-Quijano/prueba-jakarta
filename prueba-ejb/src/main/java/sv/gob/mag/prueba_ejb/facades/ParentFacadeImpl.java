package sv.gob.mag.prueba_ejb.facades;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import sv.gob.mag.prueba.api.dto.ParentResponseDTO;
import sv.gob.mag.prueba.api.facades.ParentFacade;
import sv.gob.mag.prueba_ejb.services.ParentServiceImpl;
import sv.gob.mag.prueba_ejb.utils.ParentMapper;

import java.util.List;
import java.util.stream.Collectors;

@Stateless
public class ParentFacadeImpl  implements ParentFacade {

    private final ParentServiceImpl parentService;

    @Inject
    public ParentFacadeImpl(ParentServiceImpl parentService) {
        this.parentService = parentService;
    }


    @Override
    public List<ParentResponseDTO> getListParent() {
        return parentService.listParent()
                .stream()
                .map(ParentMapper::toResponseDTO)
                .collect(Collectors.toList());
    }
}
