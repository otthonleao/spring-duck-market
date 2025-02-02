package dev.otthon.precojusto.duck.repository;

import dev.otthon.precojusto.duck.domain.entity.Duck;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DuckRepository extends JpaRepository<Duck, Long> {

    Long countByMotherId(Long motherId);

}
