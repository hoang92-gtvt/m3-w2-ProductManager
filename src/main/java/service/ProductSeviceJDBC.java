package service;

import model.Product;

import java.sql.*;
import java.util.ArrayList;

public class ProductSeviceJDBC implements ProductService{

    private Connection getConection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String url = "jdbc:mysql://localhost:3306/products";
        String user = "root";
        String pass = "123456";

        Connection co = null;
        try {
            co = DriverManager.getConnection(url,user, pass);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return co;
    }


    @Override
    public ArrayList<Product> findAll() {
        Connection co = getConection();
        String query = "select * from Products";
        ArrayList<Product> productList =new ArrayList<>();
        try {
            PreparedStatement preparedStatement = co.prepareStatement(query);
            ResultSet resultSet= preparedStatement.executeQuery();
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String name= resultSet.getString("name");
                int price = resultSet.getInt("price");
                String description = resultSet.getString("description");
                String producer = resultSet.getString("producer");
                Product getProduct = new Product(id, name, price, description, producer);

                productList.add(getProduct);


            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return productList;
    }

    @Override
    public void creatProduct(Product product) {
        Connection connection = getConection();

        String update = "insert into Products(name, price, description,producer) value " +
                "(?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(update);
            preparedStatement.setString(1,product.getName());
            preparedStatement.setInt(2,product.getPrice());
            preparedStatement.setString(3,product.getDescription());
            preparedStatement.setString(4,product.getProducer());

            System.out.println(preparedStatement);

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    public void updateProduct(int index, Product product) {
        Connection co = getConection();

        String update = "update Products set name=?, price=?, description=?, producer=? where id=?  ";
        try {
            PreparedStatement preparedStatement = co.prepareStatement(update);
            preparedStatement.setInt(5,index);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setInt(2, product.getPrice());
            preparedStatement.setString(3, product.getDescription());
            preparedStatement.setString(4, product.getProducer());

            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }

    @Override
    public void deleteProduct(int index) {
        Connection co =getConection();

        String delete = "delete from Products where id=? ";
        try {
            PreparedStatement preparedStatement = co.prepareStatement(delete);
            preparedStatement.setInt(1,index);
            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }




    }

    @Override
    public Product findByName(String name) {
        return null;
    }

    @Override
    public Product getProductByIndex(int index) {
        Connection co = getConection();

        Product product = null;

        String query = "select * from Products where id=?";
        try {
            PreparedStatement preparedStatement = co.prepareStatement(query);
            preparedStatement.setInt(1,index);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {

            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            int price = resultSet.getInt("price");
            String description = resultSet.getString("description");
            String producer = resultSet.getString("producer");

            product = new Product(id, name, price, description, producer);
        }

        }
        catch(SQLException e){
            e.printStackTrace();
        }

        return product;

    }



    @Override
    public Product getProdcutByID(int id) {
        return null;
    }
}
