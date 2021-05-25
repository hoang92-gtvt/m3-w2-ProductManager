package controller;

import model.Product;
import service.ProductService;
import service.ProductSeviceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServletProduct", value = "/products")
public class ServletProduct extends HttpServlet {
    ProductService productService = new ProductSeviceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         String action = request.getParameter("action");
         if(action==null){
             action ="";
         }
         switch(action){
             case "create":
                 showCreatProduct(request,response);
                 break;
             case "update":
                 break;
             case "delete" :
                 break;
             case "find" :
                 break;
             default :
                 showAllProduct(request, response);
                 break;

         }
//        System.out.println("inphuongthuc get");
    }

    private void showCreatProduct(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/products/create.jsp");



        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void showAllProduct(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("products/list.jsp");
        List<Product> productsList = productService.findAll();
        request.setAttribute("dssp", productsList);
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action==null){
            action ="";
        }
        switch(action){
            case "create":
                CreatProduct(request,response);
                break;
            case "update":
                break;
            case "delete" :
                break;
            case "find" :
                break;
//            default :
//                showAllProduct(request, response);
//                break;

        }
    }

    private void CreatProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int price = Integer.parseInt(request.getParameter("price"));
        String description = request.getParameter("description");
        String producer = request.getParameter("producer");

        Product product = new Product(id,name,price, description, producer);

        productService.creatProduct(product);

//        showAllProduct(request,response);

        response.sendRedirect("/products");

    }
}
