package fpt.aptech.practical_test_ead.seeder;

import com.github.javafaker.Faker;
import fpt.aptech.practical_test_ead.entity.Product;
import fpt.aptech.practical_test_ead.entity.Sale;
import fpt.aptech.practical_test_ead.repository.ProductRepository;
import fpt.aptech.practical_test_ead.repository.SaleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Component
//@RequiredArgsConstructor
public class ApplicationSeeder implements CommandLineRunner {
    boolean seed = true;
    final ProductRepository productRepository;
    final SaleRepository saleRepository;
    Faker faker;
    Random random = new Random();

    public ApplicationSeeder(ProductRepository productRepository, SaleRepository saleRepository) {
        this.productRepository = productRepository;
        this.saleRepository = saleRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        if (seed) {
            productRepository.deleteAll();
            saleRepository.deleteAll();
            seedProduct();
            seedSale();
        }
    }

    private void seedProduct() {
        Faker faker = new Faker();
        int maxPrice = 20000;
        int minPrice = 1000;
        Random random = new Random();
        int numberOfProduct = 10000;
        List<Product> products = new ArrayList<>();
        for (int i = 0; i < numberOfProduct; i++) {
            products.add(Product.builder()
                    .name(faker.name().title())
                    .description(faker.lorem().sentence())
                    .price(Double.valueOf(random.nextInt(maxPrice - minPrice)+minPrice))
                    .dateOfManf(LocalDateTime.now())
                    .build());
        }
        productRepository.saveAll(products);
    }

    private void seedSale() {
        List<Sale> saleList = new ArrayList<>();
        List<Product> productList = productRepository.findAll();
        for (int i = 0; i < 50; i++) {
            Sale sale = new Sale();
            Product product = productList.get(random.nextInt(productList.size()));
            sale.setSalesmanId(UUID.randomUUID().toString());
            sale.setProdID(product);
            sale.setSalesmanName(faker.name().firstName());
            sale.setDOS(faker.name().fullName());
            saleList.add(sale);
        }
        saleRepository.saveAll(saleList);
    }

    public static void main(String[] args) {

    }
}