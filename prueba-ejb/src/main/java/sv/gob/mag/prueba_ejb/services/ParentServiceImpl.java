package sv.gob.mag.prueba_ejb.services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import lombok.Builder;
import sv.gob.mag.prueba.api.dto.ParentRequestDTO;
import sv.gob.mag.prueba.api.dto.ParentResponseDTO;
import sv.gob.mag.prueba_ejb.entities.Parent;
import sv.gob.mag.prueba_ejb.repositories.impl.ParentRepositoryImpl;
import sv.gob.mag.prueba_ejb.utils.ParentMapper;

import java.util.List;

@ApplicationScoped
public class ParentServiceImpl implements ParentService {

    private final ParentRepositoryImpl parentRepository;

    @Inject
    public ParentServiceImpl(ParentRepositoryImpl parentRepository) {
        this.parentRepository = parentRepository;
    }

    @Override
    public List<Parent> listParent() {
        return parentRepository.listAll();
    }

    @Override
    public Parent saveParent(ParentRequestDTO parentRequestDto) {
        return null;
    }

    @Override
    public Parent findParentById(Long idParent) {
        return null;
    }

    @Override
    public Parent updateParent(Long idParent, ParentRequestDTO parentRequestDto) {
        return null;
    }

    @Override
    public Parent removeParent(Long idParent) {
        return null;
    }
}
