package ru.gb.springdatahomework.contoller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;


import ru.gb.springdatahomework.exceptions.ResourceNotFound;
import ru.gb.springdatahomework.model.Product;
import ru.gb.springdatahomework.model.Productdto;
import ru.gb.springdatahomework.services.productService;
import ru.gb.springdatahomework.sprecifications.ProductSpecifications;

@RestController
@RequestMapping("/products")
public class productcontroller {

    @Autowired
    private productService productService;

//    @GetMapping
//   public List<Product> getAll(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "5") Integer size) {
//        return productService.getAll(page-1, size);
//    }

    @GetMapping
    public Page<Productdto> getAll(
            @RequestParam MultiValueMap<String,String> params,
            @RequestParam (name = "p", defaultValue = "1") Integer page
            ) {
        if (page < 1) page = 1;
        return productService.getAll(ProductSpecifications.build(params), page, 2);
    }


    @GetMapping("/{id}")
    public Productdto getById(@PathVariable Long id) {

        return productService.getById(id).orElseThrow(() -> new ResourceNotFound("This id:" + id + "doesn't exist"));

    }

    @PostMapping
    public Product add(@RequestBody Product product) {
        return productService.add(product);
    }

    @DeleteMapping("/{id}")
    public  void delete (@PathVariable Long id) {
        productService.delete(id);
    }

    @PutMapping
    public Product updateProduct(@RequestBody Product product) {
        return productService.saveOrUpdate(product);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product save (@RequestBody Product product) {
        product.setId(null);
        return productService.saveOrUpdate(product);
    }




}
