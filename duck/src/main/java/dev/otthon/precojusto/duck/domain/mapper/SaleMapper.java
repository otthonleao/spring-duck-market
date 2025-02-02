package dev.otthon.precojusto.duck.domain.mapper;

import dev.otthon.precojusto.duck.domain.entity.Sale;
import dev.otthon.precojusto.duck.dto.request.SaleRequest;
import dev.otthon.precojusto.duck.dto.response.SaleResponse;

public interface SaleMapper {

    SaleResponse fromEntityToDTO(final Sale entity);
    Sale fromDTOToEntity(final SaleRequest request);

}
