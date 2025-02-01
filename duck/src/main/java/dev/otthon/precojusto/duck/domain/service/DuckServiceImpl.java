package dev.otthon.precojusto.duck.domain.service;

import dev.otthon.precojusto.duck.domain.entity.Duck;
import dev.otthon.precojusto.duck.domain.mapper.DuckMapper;
import dev.otthon.precojusto.duck.dto.request.CreateDuckRequest;
import dev.otthon.precojusto.duck.dto.response.DuckResponse;
import dev.otthon.precojusto.duck.repository.DuckRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DuckServiceImpl implements DuckService {

    private final DuckRepository duckRepository;
    private final DuckMapper duckMapper;

    @Override
    public DuckResponse create(CreateDuckRequest request) {
        if (request.getMotherId() != null) {
            Duck motherRequest = checkIfMotherExists(request.getMotherId());
        }
        var toEntity = duckMapper.fromDTOToEntity(request);
        var savedDatabase = duckRepository.save(toEntity);
        return duckMapper.fromEntityToDTO(savedDatabase);
    }

    private Duck checkIfMotherExists(Long motherId) {
        return duckRepository.findById(motherId)
                .orElseThrow(() -> new RuntimeException(String.format("Mother with id:[ %d ] not exists", motherId)));
    }
}
