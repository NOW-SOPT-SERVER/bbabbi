package org.sopt.carrot.service;

import lombok.RequiredArgsConstructor;
import org.sopt.carrot.domain.Product;
import org.sopt.carrot.repository.ProductRepository;
import org.sopt.carrot.service.dto.ProductCreateDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    @Transactional
    public String createProduct(
            ProductCreateDto productCreate
    ){
        Product product = productRepository.save(Product.create(
                productCreate.title(), productCreate.price(),productCreate.note(),productCreate.spot()));
        return product.getId().toString();
    }

}
