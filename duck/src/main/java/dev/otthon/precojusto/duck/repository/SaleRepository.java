package dev.otthon.precojusto.duck.repository;

import dev.otthon.precojusto.duck.domain.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepository extends JpaRepository<Sale, Long> {
}
