package sv.gob.mag.prueba.web.services;

import jakarta.ejb.EJB;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import lombok.NoArgsConstructor;
import sv.gob.mag.dto.request.ParentDetailCreateRequestDTO;
import sv.gob.mag.dto.response.ParentDetailResponseDTO;
import sv.gob.mag.ejb.entities.Parent;
import sv.gob.mag.ejb.entities.ParentDetail;
import sv.gob.mag.ejb.exceptions.BusinessException;
import sv.gob.mag.ejb.facades.ParentDetailFacadeLocal;
import sv.gob.mag.ejb.facades.ParentFacadeLocal;

@ApplicationScoped

public class ParentDetailService {

    @EJB
    private ParentDetailFacadeLocal parentDetailFacade;

    @EJB
    private ParentFacadeLocal parentFacade;

    public void registerParentDetail(ParentDetailCreateRequestDTO parentDetailCreateRequestDTO){
        ParentDetail parentDetail = new ParentDetail();
        parentDetail.setName(parentDetailCreateRequestDTO.getName());
        parentDetail.setQuantity(parentDetailCreateRequestDTO.getQuantity());

        Parent parent = this.parentFacade.findById(parentDetailCreateRequestDTO.getIdParent())
                .orElseThrow(() -> new BusinessException("El id del parent brindado no existe"));

        parentDetail.setParent(parent);

        this.parentDetailFacade.save(parentDetail);
    }
}
