package dev.otthon.precojusto.duck.domain.mapper;

import dev.otthon.precojusto.duck.domain.entity.Seller;
import dev.otthon.precojusto.duck.dto.request.CreateSellerRequest;
import dev.otthon.precojusto.duck.dto.response.SellerResponse;

public interface SellerMapper {

    SellerResponse fromEntityToDTO(final Seller entity);
    Seller fromDTOToEntity(final CreateSellerRequest request);

}
