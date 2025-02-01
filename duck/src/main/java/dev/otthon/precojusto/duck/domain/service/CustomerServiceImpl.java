package dev.otthon.precojusto.duck.domain.service;

import dev.otthon.precojusto.duck.domain.mapper.CustomerMapper;
import dev.otthon.precojusto.duck.dto.request.CreateCustomerRequest;
import dev.otthon.precojusto.duck.dto.response.CustomerResponse;
import dev.otthon.precojusto.duck.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository repository;
    private final CustomerMapper mapper;

    @Transactional
    @Override
    public CustomerResponse create(CreateCustomerRequest request) {
        var toEntity = mapper.fromDTOToEntity(request);
        var savedDatabase = repository.save(toEntity);
        return mapper.fromEntityToDTO(savedDatabase);
    }

}
