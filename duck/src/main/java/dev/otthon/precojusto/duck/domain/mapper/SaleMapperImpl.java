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

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class SaleMapperImpl implements SaleMapper {

    private final SellerRepository sellerRepository;
    private final CustomerRepository customerRepository;
    private final DuckRepository duckRepository;

    @Override
    public Sale fromDTOToEntity(SaleRequest request) {
        if (request == null) return null;

        // Buscar o vendedor completo pelo ID
        Seller seller = sellerRepository.findById(request.getSellerId())
                .orElseThrow(() -> new IllegalArgumentException("Seller not found"));

        // Buscar o cliente completo pelo ID
        Customer customer = customerRepository.findById(request.getCustomerId())
                .orElseThrow(() -> new IllegalArgumentException("Customer not found"));

        // Buscar os patos pelo ID
        List<Duck> ducks = duckRepository.findAllById(request.getDucks());

//        Sale.SaleBuilder saleBuilder = Sale.builder()
//                .customerId(dto.getCustomerId())
//                .sellerId(dto.getSellerId())
//                .ducks(dto.getDucks());
//        return saleBuilder.build();

        return Sale.builder()
            .customer(customer)  // ID do cliente
            .seller(seller)        // ID do vendedor
            .ducks(ducks)         // Lista de patos
            .build();


    }

    @Override
    public SaleResponse fromEntityToDTO(Sale entity) {

//        return SaleResponse.builder()
//                .id(entity.getId())
//                .customerId(entity.getCustomerId())
//                .sellerId(entity.getSellerId())
//                .ducks(entity.getDucks())
//                .build();

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
