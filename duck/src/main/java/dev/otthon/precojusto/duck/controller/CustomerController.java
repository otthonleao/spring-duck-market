package dev.otthon.precojusto.duck.controller;

import dev.otthon.precojusto.duck.controller.routes.ApiRoutes;
import dev.otthon.precojusto.duck.domain.service.CustomerService;
import dev.otthon.precojusto.duck.dto.request.CreateCustomerRequest;
import dev.otthon.precojusto.duck.dto.response.CustomerResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping(ApiRoutes.CUSTOMERS)
public class CustomerController {

    private final CustomerService Service;

    @PostMapping
    public ResponseEntity<CustomerResponse> create(@RequestBody final CreateCustomerRequest request) {
        CustomerResponse created = Service.create(request);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(created.getId())
                .toUri();
        return ResponseEntity.created(uri).body(created);
    }


}
