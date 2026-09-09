package sv.gob.mag.prueba.web.model;

import jakarta.inject.Inject;
import org.primefaces.model.FilterMeta;
import org.primefaces.model.SortMeta;
import org.primefaces.model.LazyDataModel;
import sv.gob.mag.dto.response.ParentResponseDTO;
import sv.gob.mag.prueba.web.services.ParentService;

import java.util.List;
import java.util.Map;

public class ParentLazyDataModel extends LazyDataModel<ParentResponseDTO> {

    private final ParentService parentService;

    @Inject
    public ParentLazyDataModel(ParentService parentService) {
        this.parentService = parentService;
    }

    @Override
    public List<ParentResponseDTO> load(int first, int pageSize,
                                        Map<String, SortMeta> sortBy,
                                        Map<String, FilterMeta> filterBy) {
        int page = (first / pageSize) + 1;
        return parentService.getAllParent(page, pageSize);
    }

    @Override
    public int count(Map<String, FilterMeta> filterBy) {
        return parentService.countAll().intValue();
    }

    @Override
    public String getRowKey(ParentResponseDTO parent) {
        return parent.getCode();
    }
}