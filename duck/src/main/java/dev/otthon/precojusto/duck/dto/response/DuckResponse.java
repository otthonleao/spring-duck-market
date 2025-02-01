package dev.otthon.precojusto.duck.dto.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import dev.otthon.precojusto.duck.domain.enums.SaleStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class DuckResponse {

    private Long id;
    private String name;
    private SaleStatusEnum status;
    private Long motherId;

}
