package sv.gob.mag.prueba.web.controller;

import jakarta.annotation.PostConstruct;
import jakarta.el.MethodExpression;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;

import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.primefaces.PrimeFaces;
import org.primefaces.model.LazyDataModel;
import sv.gob.mag.dto.enums.StatusEnum;
import sv.gob.mag.dto.request.ParentCreateRequestDTO;
import sv.gob.mag.dto.request.ParentUpdateRequestDTO;
import sv.gob.mag.dto.response.ParentResponseDTO;
import sv.gob.mag.ejb.exceptions.BusinessException;
import sv.gob.mag.prueba.web.model.ParentLazyDataModel;
import sv.gob.mag.prueba.web.services.ParentService;


import java.io.Serial;
import java.io.Serializable;


@Named("parentController")
@ViewScoped
@NoArgsConstructor
@Getter
@Setter
public class ParentController implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Inject
    private ParentService parentService;

    private LazyDataModel<ParentResponseDTO> parentList;
    private StatusEnum selectStatus;

    private ParentCreateRequestDTO parentRequest = new ParentCreateRequestDTO();
    private ParentUpdateRequestDTO parentSelect = new ParentUpdateRequestDTO();

    @PostConstruct
    public void init() {
        this.parentList = new ParentLazyDataModel(parentService);
    }

    public ParentResponseDTO createParent() {
        try {
            parentService.registerParent(parentRequest);
            parentRequest = new ParentCreateRequestDTO();
            PrimeFaces.current().executeScript("PF('formDialogCreate').hide();");
            this.resetParentRequest();
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Éxito", "Registro guardado correctamente"));
        } catch (BusinessException e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", e.getMessage()));
        }
        return null;
    }

    public void resetParentRequest() {
        this.parentRequest = new ParentCreateRequestDTO();
    }


    public ParentResponseDTO loadParent(Long idParent) {
        try {
            ParentResponseDTO parent = this.parentService.getParent(idParent);
            this.parentSelect.setName(parent.getName());
            this.parentSelect.setStatus(StatusEnum.valueOf(parent.getStatus()));
        } catch (BusinessException e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", e.getMessage()));
        }
        return null;
    }

    public void updateParent() {
        try {
            parentService.updateParent(parentSelect);
            PrimeFaces.current().executeScript("PF('formDialogUpdate').hide();");
            this.parentSelect = new ParentUpdateRequestDTO();
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Éxito", "Registro actualizado correctamente"));
        } catch (BusinessException e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", e.getMessage()));
        }
    }
}