package sv.gob.mag.prueba.controller;

import jakarta.faces.view.ViewScoped;

import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.Getter;

import sv.gob.mag.prueba.api.dto.ParentResponseDTO;
import sv.gob.mag.prueba.api.facades.ParentFacade;

import java.util.List;

@Named("parentController")
@ViewScoped
public class ParentController {


    private final ParentFacade parentFacade;

    @Getter
    private List<ParentResponseDTO> listParent;

    @Inject
    public ParentController(ParentFacade parentFacade) {
        this.parentFacade = parentFacade;
    }


    public void loadParent() {
        try {
            this.listParent = parentFacade.getListParent();
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
}