package dev.otthon.precojusto.duck.domain.mapper;

import dev.otthon.precojusto.duck.domain.entity.Customer;
import dev.otthon.precojusto.duck.domain.entity.Duck;
import dev.otthon.precojusto.duck.domain.entity.Sale;
import dev.otthon.precojusto.duck.domain.entity.Seller;
import dev.otthon.precojusto.duck.dto.request.SaleRequest;
import dev.otthon.precojusto.duck.dto.response.SaleResponse;
import dev.otthon.precojusto.duck.repository.CustomerRepository;
import dev.otthon.precojusto.duck.repository.DuckRepository;
import dev.otthon.precojusto.duck.repository.SellerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class SaleMapperImpl implements SaleMapper {

    private final SellerRepository sellerRepository;
    private final CustomerRepository customerRepository;
    private final DuckRepository duckRepository;

    @Override
    public Sale fromDTOToEntity(SaleRequest request) {
        if (request == null) return null;

        Seller seller = sellerRepository.findById(request.getSellerId())
                .orElseThrow(() -> new IllegalArgumentException("Seller not found"));

        Customer customer = customerRepository.findById(request.getCustomerId())
                .orElseThrow(() -> new IllegalArgumentException("Customer not found"));

        List<Duck> ducks = duckRepository.findAllById(request.getDucks());

        return Sale.builder()
            .customer(customer)
            .seller(seller)
            .build();
    }

    @Override
    public SaleResponse fromEntityToDTO(Sale entity) {

        return SaleResponse.builder()
                .id(entity.getId())
                .customer(entity.getCustomer().getId())
                .seller(entity.getSeller().getId())
                .ducks(entity.getDucks())
                .totalValue(entity.getTotalValue())
                .discountApplied(entity.getDiscountApplied())
                .saleDate(entity.getSaleDate())
                .build();
    }
}
