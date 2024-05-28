package org.sopt.carrot.repository;

import org.sopt.carrot.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
