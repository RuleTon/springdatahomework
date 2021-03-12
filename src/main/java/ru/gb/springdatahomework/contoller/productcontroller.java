package ru.gb.springdatahomework.contoller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import ru.gb.springdatahomework.model.Product;
import ru.gb.springdatahomework.model.Sort;
import ru.gb.springdatahomework.services.productService;


import java.util.List;

@RestController
@RequestMapping("/products")
public class productcontroller {

    @Autowired
    private productService productService;

    @GetMapping
    public List<Product> getAll(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "5") Integer size) {
        return productService.getAll(page-1, size);
    }


    @GetMapping("/{id}")
    public Product getById(@PathVariable Long id) {
        return productService.getById(id);
    }

    @PostMapping
    public Product add(@RequestBody Product product) {
        return productService.add(product);
    }

    @DeleteMapping("/{id}")
    public  void delete (@PathVariable Long id) {
        productService.delete(id);
    }




}
