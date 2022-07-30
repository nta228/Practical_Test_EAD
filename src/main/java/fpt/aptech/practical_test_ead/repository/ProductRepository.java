package fpt.aptech.practical_test_ead.repository;

import fpt.aptech.practical_test_ead.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
}
