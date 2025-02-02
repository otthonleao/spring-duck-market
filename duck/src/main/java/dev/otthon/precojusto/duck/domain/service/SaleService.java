package dev.otthon.precojusto.duck.domain.service;

import dev.otthon.precojusto.duck.dto.request.SaleRequest;
import dev.otthon.precojusto.duck.dto.response.SaleResponse;

public interface SaleService {

    SaleResponse orderBuy(SaleRequest request);

}
