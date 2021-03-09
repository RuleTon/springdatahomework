package ru.gb.springdatahomework.services;


import org.springframework.stereotype.Service;
import ru.gb.springdatahomework.model.Product;
import ru.gb.springdatahomework.repository.ProductRepository;

import java.util.List;

@Service
public class productService {


    private ProductRepository productRepository;

    public List<Product> getAll() {
        return productRepository.findAll();
    }

    public Product getById(Long id) {
        return productRepository.findById(id).get();
    }

    public Product add (Product product) {
        return productRepository.save(product);
    }

    public void delete (Long id) {
        productRepository.deleteById(id);
    }


}
