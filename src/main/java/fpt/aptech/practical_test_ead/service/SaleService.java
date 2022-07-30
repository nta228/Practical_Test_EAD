package fpt.aptech.practical_test_ead.service;

import fpt.aptech.practical_test_ead.entity.Sale;
import fpt.aptech.practical_test_ead.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleService {
    @Autowired
    SaleRepository saleRepository;

    public List<Sale> findAll() {
        return saleRepository.findAll();
    }
}
