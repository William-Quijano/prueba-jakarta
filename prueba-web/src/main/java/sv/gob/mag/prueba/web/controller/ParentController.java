package sv.gob.mag.prueba.web.controller;

import jakarta.annotation.PostConstruct;
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
import sv.gob.mag.dto.request.ParentRequestDTO;
import sv.gob.mag.dto.response.ParentResponseDTO;
import sv.gob.mag.ejb.exceptions.BusinessException;
import sv.gob.mag.prueba.web.model.ParentLazyDataModel;
import sv.gob.mag.prueba.web.services.ParentService;


import java.io.Serial;
import java.io.Serializable;
import java.util.List;


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

    private ParentRequestDTO parentRequest = new ParentRequestDTO();

    @PostConstruct
    public void init() {
        this.parentList = new ParentLazyDataModel(parentService);
    }

    public ParentResponseDTO saveParent() {
        try {
            parentService.saveParent(parentRequest);
            parentRequest = new ParentRequestDTO();
            PrimeFaces.current().executeScript("PF('formDialog').hide();");
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Éxito", "Registro guardado correctamente"));
        } catch (BusinessException e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", e.getMessage()));
        }
        return null;
    }


}