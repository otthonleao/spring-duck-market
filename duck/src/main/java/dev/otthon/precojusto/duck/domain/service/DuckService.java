package dev.otthon.precojusto.duck.domain.service;

import dev.otthon.precojusto.duck.dto.request.CreateDuckRequest;
import dev.otthon.precojusto.duck.dto.response.DuckResponse;

public interface DuckService {

    DuckResponse create(final CreateDuckRequest request);

}
