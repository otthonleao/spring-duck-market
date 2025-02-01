package dev.otthon.precojusto.duck.domain.service;

import dev.otthon.precojusto.duck.dto.request.CreateCustomerRequest;
import dev.otthon.precojusto.duck.dto.response.CustomerResponse;

public interface CustomerService {

    CustomerResponse create(final CreateCustomerRequest request);

}
