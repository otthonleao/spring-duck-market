package dev.otthon.precojusto.duck.domain.service;

import dev.otthon.precojusto.duck.domain.entity.Duck;
import dev.otthon.precojusto.duck.domain.enums.SaleStatusEnum;
import dev.otthon.precojusto.duck.domain.mapper.SaleMapper;
import dev.otthon.precojusto.duck.dto.request.SaleRequest;
import dev.otthon.precojusto.duck.dto.response.SaleResponse;
import dev.otthon.precojusto.duck.repository.CustomerRepository;
import dev.otthon.precojusto.duck.repository.DuckRepository;
import dev.otthon.precojusto.duck.repository.SaleRepository;
import dev.otthon.precojusto.duck.repository.SellerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SaleServiceImpl implements SaleService {

    private final SaleRepository saleRepository;
    private final SellerRepository sellerRepository;
    private final CustomerRepository customerRepository;
    private final DuckRepository duckRepository;
    private final SaleMapper saleMapper;

    @Override
    @Transactional
    public SaleResponse orderBuy(SaleRequest request) {

        checkIfSellerExists(request.getSellerId());
        checkIfCostumerExists(request.getCustomerId());
        checkIfDuckExists(request.getDucks());
        checkIfDuckIsSold(request.getDucks());

        List<Duck> ducks = duckRepository.findAllById(request.getDucks());

        ducks.forEach(duck -> duck.setStatus(SaleStatusEnum.SOLD));
        duckRepository.saveAll(ducks);

        var toEntity = saleMapper.fromDTOToEntity(request);
        var savedDatabase = saleRepository.save(toEntity);

        return saleMapper.fromEntityToDTO(savedDatabase);
    }

    private void checkIfSellerExists(Long sellerId) {
        if (!sellerRepository.existsById(sellerId)) {
            throw new IllegalArgumentException(String.format("[ IMPORTANT ] Seller with id %s was not found ", sellerId));
        }
    }

    private void checkIfCostumerExists(Long customerId) {
        if (!customerRepository.existsById(customerId)) {
            throw new IllegalArgumentException(String.format("[ IMPORTANT ] Customer with id %s was not found", customerId));
        }
    }

    private void checkIfDuckExists(List<Long> ducks) {
        Set<Long> ducksNotFound = ducks.stream()
                .filter(duckId -> !duckRepository.existsById(duckId))
                .collect(Collectors.toSet());

        if (!ducksNotFound.isEmpty()) {
            throw new IllegalArgumentException(String.format("[ IMPORTANT ] Duck with id %s does not exist", ducksNotFound));
        }
    }

    private void checkIfDuckIsSold(List<Long> ducks) {
        Set<Long> ducksSold = ducks.stream()
                .filter(duckId -> !duckRepository.existsById(duckId))
                .collect(Collectors.toSet());

        if (!ducksSold.isEmpty()) {
            throw new IllegalArgumentException(String.format("[ IMPORTANT ] Duck with id %s has already been sold", ducksSold));
        }
    }
}
