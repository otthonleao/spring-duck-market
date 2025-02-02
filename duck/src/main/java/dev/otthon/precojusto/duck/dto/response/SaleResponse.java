package dev.otthon.precojusto.duck.dto.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import dev.otthon.precojusto.duck.domain.entity.Duck;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class SaleResponse {

    private Long id;
    private Long customer;
    private Long seller;
    private List<Duck> ducks;
    private BigDecimal totalValue;
    private BigDecimal discountApplied;
    private LocalDateTime saleDate;

}
