package Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductController
{
    @Autowired
    private ProductService productService;
    @GetMapping("/products")
    public ResponseEntity<List<ProductModel>>  getAllProduct()
    {
        List<ProductModel> ProductList= productService.AllProduct();
        if(ProductList.size()<=0)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(ProductList));

    }
    @GetMapping("/products/{id}")
    public ResponseEntity<ProductModel> getProductByID(@PathVariable long id)
    {
        ProductModel productModel= (ProductModel) productService.ProductById(id);
        {
            if(productModel==null)
            {
               return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
            return ResponseEntity.of(Optional.of(productModel));
        }
    }
    @PostMapping("/products")
    public ProductModel addProduct(@RequestBody ProductModel productModel){
        ProductModel p=this.productService.addproduct(productModel);
        return p;
    }
    @DeleteMapping("/product/{Productid}")
    public void deleteProduct(@PathVariable("ProductId") int Productid){
        this.productService.deleteProduct(Productid);
    }
    @PutMapping("/product/{id}")
    public ProductModel updateProduct(@RequestBody ProductModel productModel,@PathVariable("Id") int pid)
    {
        this.productService.updateProduct(productModel,pid);
        return productModel;
    }

}
