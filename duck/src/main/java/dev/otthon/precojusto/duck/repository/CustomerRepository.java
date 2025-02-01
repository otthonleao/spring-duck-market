package dev.otthon.precojusto.duck.repository;

import dev.otthon.precojusto.duck.domain.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
