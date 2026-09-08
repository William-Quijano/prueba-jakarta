package sv.gob.mag.prueba.web.controller;

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;

import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sv.gob.mag.dto.response.ParentResponseDTO;
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

    private List<ParentResponseDTO> parentList;

    @PostConstruct
    public void init() {
        this.parentList = getAllParent();
    }


    public List<ParentResponseDTO> getAllParent() {

        return this.parentService.getAllParent(1, 10);
    }
}