package ru.gb.lesson1.lesson1;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "lesson1Servlet", value = "/lesson-1-servlet")
public class Lesson1Servlet extends HttpServlet {
    private String message;
    private Product[] products;

    public void init() {
        products = new Product[10];
        for (int i = 0; i < products.length; i++) {
            products[i] = new Product(i, "Product " + i, i*100f);
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        //формируем объекты
        message = "";
        for (Product prod : products) {
            message += "<p><ul>";
            message += "<li>ID: " + prod.getId();
            message += "<li>Title: " + prod.getTitle();
            message += "<li>Price: " + prod.getCost();
            message += "</ul></p>";
        }
        PrintWriter out = response.getWriter();
        out.println("<html><head><meta charset = \"utf-8\" ></head><body>");
        out.println(message);
        out.println("</body></html>");
    }

    public void destroy() {
    }
}