package fpt.aptech.practical_test_ead.service;
import fpt.aptech.practical_test_ead.entity.Product;
import fpt.aptech.practical_test_ead.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }
}
