package sv.gob.mag.prueba.web.services;

import jakarta.ejb.EJB;
import jakarta.enterprise.context.ApplicationScoped;
import org.modelmapper.ModelMapper;
import sv.gob.mag.dto.response.ParentResponseDTO;
import sv.gob.mag.ejb.facades.ParentFacadeLocal;


import java.util.List;

@ApplicationScoped
public class ParentService {

    @EJB
    private ParentFacadeLocal parentFacade;

    ModelMapper modelMapper = new ModelMapper();


    public List<ParentResponseDTO> getAllParent(Integer page, Integer prePage) {
        return this.parentFacade.listAll(page, prePage)
                .stream()
                .map(parent -> modelMapper.map(parent, ParentResponseDTO.class))
                .toList();
    }
}
