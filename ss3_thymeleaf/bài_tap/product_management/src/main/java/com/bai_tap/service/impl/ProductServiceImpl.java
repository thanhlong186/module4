package com.bai_tap.service.impl;

import com.bai_tap.model.Product;
import com.bai_tap.service.IProductService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class ProductServiceImpl implements IProductService {
    private static final Map<Integer, Product> products;

    static {
        products = new HashMap<>();
        products.put(1, new Product(1,"Apple", 23000.0, "Macbook Pro", "Mỹ"));
        products.put(2, new Product(2, "Asus", 19000.0, "Asus VivoBook", "Đài Loan"));
        products.put(3, new Product(3,"Razer", 20000.0, "Razer Blade", "Mỹ"));
        products.put(4, new Product(4, "Acer ", 28960.0, "Acer Nitro 5 Gaming", "Đài Loan"));
        products.put(5, new Product(5,"Dell", 25000.0, "Dell Inspiron", "Mỹ"));
    }
    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(), product);

    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id, product);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }

    @Override
    public List<Product> searchByName(String name) {
            List<Product> products = this.findAll();
            List<Product> productList = new ArrayList<>();
            String productName;
            name = name.toLowerCase();
            for (Product product : products) {
                productName = product.getName().toLowerCase();
                if(productName.contains(name)){
                    productList.add(product);
                }
            }
//        List<Product> productList = new ArrayList<>();
//        for(Product product : products.values()){
//            if (product.getName().equals(name)){
//                productList.add(product);
//            }
//
//        }

            return productList;
    }
}
