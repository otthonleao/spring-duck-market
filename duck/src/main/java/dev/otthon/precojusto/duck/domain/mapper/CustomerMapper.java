package dev.otthon.precojusto.duck.domain.mapper;

import dev.otthon.precojusto.duck.domain.entity.Customer;
import dev.otthon.precojusto.duck.dto.request.CreateCustomerRequest;
import dev.otthon.precojusto.duck.dto.response.CustomerResponse;

public interface CustomerMapper {

    CustomerResponse fromEntityToDTO(final Customer entity);
    Customer fromDTOToEntity(final CreateCustomerRequest request);

}
