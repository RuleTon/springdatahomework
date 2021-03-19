package ru.gb.springdatahomework.services;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ru.gb.springdatahomework.model.Product;
import ru.gb.springdatahomework.model.Productdto;
import ru.gb.springdatahomework.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class productService {


    private ProductRepository productRepository;

  //  public List<Product> getAll(int page, int size) {

    //    return productRepository.findAll(Sort.by("cost").descending());

        // return productRepository.findAll(Sort.by("cost").ascending());  //Возрастание

        //return productRepository.findAll();  //Стандартное отображиение

        // return productRepository.findAll(PageRequest.of(page, size).toList());

 //   }


    public Page<Productdto> getAll(Specification<Product> spec, int page, int size) {
        if(page < 0)
            throw  new RuntimeException();
        return productRepository.findAll(spec, PageRequest.of(page - 1, size)).map(Productdto::new);
    }

    public Optional<Productdto> getById(Long id) {
        return productRepository.findById(id).map(Productdto::new);
    }





 //   public Product getById(Long id) {
 //       return productRepository.findById(id).get();
 //   }

    public Product add (Product product) {
        return productRepository.save(product);
    }

    public void delete (Long id) {
        productRepository.deleteById(id);
    }

    public  Product saveOrUpdate (Product product) {return productRepository.save(product);}


}
