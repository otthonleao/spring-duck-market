package dev.otthon.precojusto.duck.domain.service;

import dev.otthon.precojusto.duck.domain.mapper.SellerMapper;
import dev.otthon.precojusto.duck.dto.request.CreateSellerRequest;
import dev.otthon.precojusto.duck.dto.response.SellerResponse;
import dev.otthon.precojusto.duck.repository.SellerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SellerServiceImpl implements SellerService {

    private final SellerRepository repository;
    private final SellerMapper mapper;

    @Override
    @Transactional
    public SellerResponse create(CreateSellerRequest request) {

        checkIfCpfAlreadyExists(request.getCpf());
        checkIfRegistrationAlreadyExists(request.getRegistration());

        var toEntity = mapper.fromDTOToEntity(request);
        var savedDatabase = repository.save(toEntity);
        return mapper.fromEntityToDTO(savedDatabase);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<SellerResponse> findAll(Pageable pageable) {
        Page<SellerResponse> all = repository.findAll(pageable).map(mapper::fromEntityToDTO);
        return all;
    }

    private void checkIfCpfAlreadyExists(String cpf) {
        if (repository.existsByCpf(cpf)) {
            throw new IllegalArgumentException(String.format("CPF %s already exists", cpf));
        }
    }

    private void checkIfRegistrationAlreadyExists(String registration) {
        if (repository.existsByRegistration(registration)) {
            throw new IllegalArgumentException(String.format("Registration %s already exists", registration));
        }
    }

}
