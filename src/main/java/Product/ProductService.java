package Product;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    public static List<ProductModel> ProductList = new ArrayList<>();

    static {
        ProductList.add(new ProductModel(100, "Mobile", "dfds23423", 9000, 6));
        ProductList.add(new ProductModel(101, "Smart TV", "frwer567642", 60000, 3));
        ProductList.add(new ProductModel(102, "Washing Machine", "23423df32", 8000, 7));
        ProductList.add(new ProductModel(103, "Laptop", "29ioofj3232", 24000, 1));
        ProductList.add(new ProductModel(104, "Air Conditioner", "230948fdf", 30000, 5));
        ProductList.add(new ProductModel(105, "Refrigerator ", "13423efsdff", 10000, 4));

    }

    public List<ProductModel> AllProduct()
    {
        return ProductList;
    }

    public List<ProductModel> ProductById(long id) {
        ProductModel product = null;
        try {
            product = ProductList.stream().filter(p -> p.getId() == id).findFirst().get();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return (List<ProductModel>) product;
    }

    public ProductModel addproduct(ProductModel p) {
        ProductList.add(p);
        return p;
    }

    public void deleteProduct(int id) {
        ProductList = ProductList.stream().filter(productModel -> productModel.getId() != id).collect(Collectors.toList());
    }

    public void updateProduct(ProductModel productModel, int pid) {
        ProductList.stream().map(p ->
        {
            if (p.getId() == pid) {
                p.setPname(productModel.getPname());
                p.setBatchno(productModel.getBatchno());
            }
            return p;
        }).collect(Collectors.toList());
    }
}


