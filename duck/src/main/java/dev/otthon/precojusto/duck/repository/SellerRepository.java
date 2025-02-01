package dev.otthon.precojusto.duck.repository;

import dev.otthon.precojusto.duck.domain.entity.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerRepository extends JpaRepository<Seller, Long> {

    boolean existsByCpf(String cpf);
    boolean existsByRegistration(String registration);

}
