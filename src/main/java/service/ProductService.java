package service;

import model.Product;

import java.util.ArrayList;

public interface ProductService {

    ArrayList<Product> findAll();

    void creatProduct(Product product);
    void updateProduct(int index, Product product);
    void deleteProduct(int index);


    Product findByName(String name);


}
