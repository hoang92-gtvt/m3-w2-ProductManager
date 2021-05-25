package service;

import model.Product;

import java.util.ArrayList;

public class ProductSeviceImpl implements ProductService{
    private static ArrayList<Product> productList;
    static {
        productList = new ArrayList<>();
        productList.add(new Product(1, "Bút bi", 5,"5mm","VietNam"));
        productList.add(new Product(2, "Bút chì", 10,"2B","VietNam"));
        productList.add(new Product(3, "Bút mực", 15,"con mèo","VietNam"));
        productList.add(new Product(4, "Bảng",25 ,"297x210mm","VietNam"));
        productList.add(new Product(5, "Phấn", 12,"Hộp","VietNam"));
        productList.add(new Product(6, "Khăn", 20,"Vải","VietNam"));
    }


    @Override
    public ArrayList<Product> findAll() {
        return productList;
    }

    @Override
    public void creatProduct(Product product) {
        productList.add(product);
    }

    @Override
    public void updateProduct(int index, Product product) {
        productList.set(index,product);
    }

    @Override
    public void deleteProduct(int index) {
        productList.remove(index);
    }



    @Override
    public Product findByName(String name) {
        for (Product p:productList ) {
            if(p.getName().equals(name)){
                return p;
            }

        }
        return null;
    }

    @Override
    public Product getProductByIndex(int index){
        return productList.get(index);

    }




}
