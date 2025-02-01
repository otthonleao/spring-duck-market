package dev.otthon.precojusto.duck.domain.service;

import dev.otthon.precojusto.duck.dto.request.CreateSellerRequest;
import dev.otthon.precojusto.duck.dto.response.SellerResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SellerService {

    SellerResponse create(final CreateSellerRequest request);

    Page<SellerResponse> findAll(Pageable pageable);
}
