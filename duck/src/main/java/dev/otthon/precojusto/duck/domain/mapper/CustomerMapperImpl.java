package dev.otthon.precojusto.duck.domain.mapper;

import dev.otthon.precojusto.duck.domain.entity.Customer;
import dev.otthon.precojusto.duck.dto.request.CreateCustomerRequest;
import dev.otthon.precojusto.duck.dto.response.CustomerResponse;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapperImpl implements CustomerMapper{

    @Override
    public Customer fromDTOToEntity(CreateCustomerRequest request) {
        if (request == null) return null;

        return Customer.builder()
                .name(request.getName())
                .hasDiscount(request.isHasDiscount())
                .build();

    }

    @Override
    public CustomerResponse fromEntityToDTO(Customer entity) {
        return CustomerResponse.builder()
                .id(entity.getId())
                .name(entity.getName())
                .hasDiscount(entity.isHasDiscount())
                .build();
    }
}
