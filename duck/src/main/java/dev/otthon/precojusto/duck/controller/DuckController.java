package dev.otthon.precojusto.duck.controller;

import dev.otthon.precojusto.duck.controller.routes.ApiRoutes;
import dev.otthon.precojusto.duck.domain.service.DuckService;
import dev.otthon.precojusto.duck.dto.request.CreateDuckRequest;
import dev.otthon.precojusto.duck.dto.response.DuckResponse;
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
@RequestMapping(ApiRoutes.DUCKS)
public class DuckController {

    private final DuckService duckService;

    @PostMapping
    public ResponseEntity<DuckResponse> create(@RequestBody final CreateDuckRequest request) {

        DuckResponse created = duckService.create(request);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(created.getId())
                .toUri();
        return ResponseEntity.created(uri).body(created);

    }
}
