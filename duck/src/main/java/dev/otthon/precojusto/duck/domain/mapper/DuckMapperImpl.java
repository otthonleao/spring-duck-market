package dev.otthon.precojusto.duck.domain.mapper;

import dev.otthon.precojusto.duck.domain.entity.Duck;
import dev.otthon.precojusto.duck.domain.enums.SaleStatusEnum;
import dev.otthon.precojusto.duck.dto.request.CreateDuckRequest;
import dev.otthon.precojusto.duck.dto.response.DuckResponse;
import org.springframework.stereotype.Component;

@Component
public class DuckMapperImpl implements DuckMapper{

    @Override
    public Duck fromDTOToEntity(CreateDuckRequest request) {
        if (request == null) return null;

        Duck.DuckBuilder duckBuilder = Duck.builder()
                .name(request.getName())
                .status(SaleStatusEnum.AVAILABLE);

        if (request.getMotherId() != null) {
            Duck motherIdRequest = Duck.builder().id(request.getMotherId()).build();
            duckBuilder.motherId(motherIdRequest);
        }
        return duckBuilder.build();
    }

    @Override
    public DuckResponse fromEntityToDTO(Duck entity) {
        if (entity == null) return null;

        return DuckResponse.builder()
                .id(entity.getId())
                .name(entity.getName())
                .status(entity.getStatus())
                .motherId(entity.getMotherId() != null ? entity.getMotherId().getId() : null)
                .build();
    }
}
