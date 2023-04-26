package com.example.test.configuration;

import com.example.test.entity.Customer;
import com.example.test.entity.Product;
import com.example.test.repository.CustomerRepository;
import com.example.test.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadData {
    private static final Logger log = LoggerFactory.getLogger(LoadData.class);

    @Bean
    CommandLineRunner initDatabase(ProductRepository productRepository, CustomerRepository customerRepository){
        return args -> {
            productRepository.deleteAll();
            customerRepository.deleteAll();
            log.info("Preloading " + productRepository.save(new Product(18156,"Product 1", "Description 1", (byte) 1)));
            log.info("Preloading " + productRepository.save(new Product(10200,"Product 2", "Description 2", (byte) 1)));
            log.info("Preloading " + productRepository.save(new Product(25020,"Product 3", "Description 3", (byte) 1)));
            log.info("Preloading " + productRepository.save(new Product(10170,"Product 4", "Description 4", (byte) 1)));
            log.info("Preloading " + productRepository.save(new Product(10280,"Product 5", "Description 5", (byte) 1)));
            log.info("Preloading " + productRepository.save(new Product(30001,"Product 6", "Description 6", (byte) 1)));
            log.info("Preloading " + customerRepository.save(new Customer(720010, "Ferreteria Alex S.A de C.V", (byte) 1)));
        };
    }
}
