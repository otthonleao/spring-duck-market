package dev.otthon.precojusto.duck.domain.mapper;

import dev.otthon.precojusto.duck.domain.entity.Duck;
import dev.otthon.precojusto.duck.dto.request.CreateDuckRequest;
import dev.otthon.precojusto.duck.dto.response.DuckResponse;

public interface DuckMapper {

    DuckResponse fromEntityToDTO(final Duck entity);
    Duck fromDTOToEntity(final CreateDuckRequest dto);

}
