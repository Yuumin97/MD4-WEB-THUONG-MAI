package threephone.group.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import threephone.group.dto.response.ResponseMessage;
import threephone.group.model.product.Product;
import threephone.group.service.product.IProductService;

import javax.swing.text.html.Option;
import java.awt.image.ImageProducer;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private IProductService productService;
    @GetMapping
    public ResponseEntity<?> showListProduct(Pageable pageable){
        Page<Product> products = productService.findAll(pageable);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<?> createProduct(@RequestBody Product product){
        if (product.getName().trim().equals("") || product.getName().length() < 1 || product.getName().length() > 20) {
            return new ResponseEntity<>(new ResponseMessage("The name product invalid"), HttpStatus.OK);
        }
        if (productService.existsByName(product.getName())) {
            return new ResponseEntity<>(new ResponseMessage("The name product exited"), HttpStatus.OK);
        }
        productService.save(product);
        return new ResponseEntity<>(new ResponseMessage("Create success!"), HttpStatus.OK);
    }

    @GetMapping("/page")
    public ResponseEntity<?> pageProduct(@PageableDefault(sort = "name", size = 5) Pageable pageable){
        return new ResponseEntity<>(productService.findAll(pageable),HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> detailProduct(@PathVariable Long id){
        if (!productService.findById(id).isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(productService.findById(id).get(),HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<?> updateProduct(@PathVariable Long id ,@RequestBody Product product){
        Optional<Product> product1 = productService.findById(id);
        if (!product1.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        if (product.getName().trim().equals("") || product.getName().length() < 1 || product.getName().length() > 10){
            return new ResponseEntity<>(new ResponseMessage("The name product invalid"),HttpStatus.OK);
        }
        if (productService.existsByName(product.getName())){
            return new ResponseEntity<>(new ResponseMessage("The name product exited !"),HttpStatus.OK);
        }
        product1.get().setName(product.getName());
        product1.get().setDescription(product.getDescription());
        product1.get().setManufacture(product.getManufacture());
        product1.get().setPrice(product.getPrice());
        productService.save(product1.get());
        return new ResponseEntity<>(new ResponseMessage("Update success !"),HttpStatus.OK);

    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id){
        Optional<Product> product = productService.findById(id);
        if(!product.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        productService.remote(id);
        return new ResponseEntity<>(new ResponseMessage("Delete success !"),HttpStatus.OK);
    }



    @GetMapping("/searchs")
    public ResponseEntity<?> searchByNamePage(@RequestParam String name,Pageable pageable){
        if (name.trim().equals("")){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(productService.findByNameContaining(name,pageable),HttpStatus.OK);
    }




}


