package dev.otthon.precojusto.duck.controller;

import dev.otthon.precojusto.duck.controller.routes.ApiRoutes;
import dev.otthon.precojusto.duck.domain.service.SaleService;
import dev.otthon.precojusto.duck.dto.request.SaleRequest;
import dev.otthon.precojusto.duck.dto.response.SaleResponse;
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
@RequestMapping(ApiRoutes.SALES)
public class SaleController {

    private final SaleService saleService;

    @PostMapping
    public ResponseEntity<SaleResponse> order(@RequestBody final SaleRequest request) {

        SaleResponse created = saleService.orderBuy(request);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(created.getId())
                .toUri();
        return ResponseEntity.created(uri).body(created);

    }
}
