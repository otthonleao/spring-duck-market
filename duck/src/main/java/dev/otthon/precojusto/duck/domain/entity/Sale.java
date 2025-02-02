package dev.otthon.precojusto.duck.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(onlyExplicitlyIncluded = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "TB_SALE")
public class Sale implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @ToString.Include
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "CUSTOMER_ID", nullable = false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "SELLER_ID", nullable = false)
    private Seller seller;

    @ManyToMany
    @JoinTable(
            name = "TB_SALE_DUCK",
            joinColumns = @JoinColumn(name = "SALE_ID"),
            inverseJoinColumns = @JoinColumn(name = "DUCK_ID")
    )
    private List<Duck> ducks;

    @Column(name = "TOTAL_VALUE")
    private BigDecimal totalValue;

    @Column(name = "DISCOUNT_APPLIED")
    private BigDecimal discountApplied;

    @Column(name = "SALE_DATE", nullable = false)
    private LocalDateTime saleDate;

    @PrePersist
    public void prePersist() {
        this.saleDate = LocalDateTime.now();
    }
}
