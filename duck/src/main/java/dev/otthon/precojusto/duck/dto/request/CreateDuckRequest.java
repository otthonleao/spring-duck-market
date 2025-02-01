package dev.otthon.precojusto.duck.dto.request;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CreateDuckRequest {

    @NotBlank(message = "O nome do pato é obrigatório")
    @Size(min = 2, max = 50, message = "O nome do pato deve ter entre 2 e 50 caracteres")
    private String name;

    private Long motherId;

}
