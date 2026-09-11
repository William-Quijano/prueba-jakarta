package sv.gob.mag.prueba.web.controller;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;
import sv.gob.mag.dto.request.ParentDetailCreateRequestDTO;
import sv.gob.mag.ejb.exceptions.BusinessException;
import sv.gob.mag.prueba.web.services.ParentDetailService;

import java.io.Serial;
import java.io.Serializable;

@Named("parentDetailController")
@ViewScoped
@Getter
@Setter
public class ParentDetailController implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private final ParentDetailService parentDetailService;

    private ParentDetailCreateRequestDTO parentDetailRequest = new ParentDetailCreateRequestDTO();

    @Inject
    public ParentDetailController(ParentDetailService parentDetailService) {
        this.parentDetailService = parentDetailService;
    }

    public void createRegister(ParentDetailCreateRequestDTO parentDetailCreateRequestDTO){
        try {
            parentDetailService.registerParentDetail(parentDetailCreateRequestDTO);
            parentDetailRequest = new ParentDetailCreateRequestDTO();
//            PrimeFaces.current().executeScript("PF('formDialogCreate').hide();");
//            this.resetParentRequest();
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Éxito", "Registro guardado correctamente"));
        } catch (BusinessException e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", e.getMessage()));
        }
    }
}
