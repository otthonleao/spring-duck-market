package dev.otthon.precojusto.duck.domain.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum SaleStatusEnum {

    AVAILABLE(1),
    SOLD(2);

    private final int index;

    public static SaleStatusEnum valueOf(int index) {
        for (SaleStatusEnum value : SaleStatusEnum.values()) {
            if (value.getIndex() == index) {
                return value;
            }
        }
        throw new IllegalArgumentException(String.format("Código[ %d ] de status de venda inválido ", index));
    }

}
