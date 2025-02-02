package dev.otthon.precojusto.duck.controller;

import dev.otthon.precojusto.duck.controller.routes.ApiRoutes;

import dev.otthon.precojusto.duck.domain.service.SellerService;
import dev.otthon.precojusto.duck.dto.request.CreateSellerRequest;
import dev.otthon.precojusto.duck.dto.response.SellerResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping(ApiRoutes.SELLERS)
public class SellerController {

    private final SellerService service;

    @PostMapping
    public ResponseEntity<SellerResponse> create(@RequestBody final CreateSellerRequest request) {
        SellerResponse created = service.create(request);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(created.getId())
                .toUri();
        return ResponseEntity.created(uri).body(created);
    }

    @GetMapping
    public ResponseEntity<Page<SellerResponse>> findAll(Pageable pageable) {
        Page<SellerResponse> all = service.findAll(pageable);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .replaceQueryParam("page", pageable.getPageNumber())
                .replaceQueryParam("size", pageable.getPageSize())
                .build()
                .toUri();
        return ResponseEntity.ok().header("X-Page-URI", uri.toString()).body(all);
    }

}
