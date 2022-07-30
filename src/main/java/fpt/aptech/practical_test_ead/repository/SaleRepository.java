package fpt.aptech.practical_test_ead.repository;

import fpt.aptech.practical_test_ead.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Integer> {
}
