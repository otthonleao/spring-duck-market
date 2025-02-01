package dev.otthon.precojusto.duck.domain.mapper;

import dev.otthon.precojusto.duck.domain.entity.Seller;
import dev.otthon.precojusto.duck.dto.request.CreateSellerRequest;
import dev.otthon.precojusto.duck.dto.response.SellerResponse;
import org.springframework.stereotype.Component;

@Component
public class SellerMapperImpl implements SellerMapper{

    @Override
    public SellerResponse fromEntityToDTO(Seller entity) {
        return SellerResponse.builder()
                .id(entity.getId())
                .name(entity.getName())
                .cpf(entity.getCpf())
                .registration(entity.getRegistration())
                .build();
    }

    @Override
    public Seller fromDTOToEntity(CreateSellerRequest request) {
        if (request == null) return null;

        return Seller.builder()
                .name(request.getName())
                .cpf(request.getCpf())
                .registration(request.getRegistration())
                .build();
    }

}
