package fpt.aptech.practical_test_ead.controller;

import fpt.aptech.practical_test_ead.entity.Sale;
import fpt.aptech.practical_test_ead.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/sales")
public class SaleAPI {
    @Autowired
    SaleService saleService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Sale> findAll(){
        return saleService.findAll();
    }
}