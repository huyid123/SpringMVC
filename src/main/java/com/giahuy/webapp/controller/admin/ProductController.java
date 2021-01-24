package com.giahuy.webapp.controller.admin;

import com.giahuy.webapp.constant.SystemConstant;
import com.giahuy.webapp.model.ProductModel;
import com.giahuy.webapp.service.IProductService;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/admin-product-list"})
public class ProductController extends HttpServlet {

    @Inject
    private IProductService productService;

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductModel model = new ProductModel();
        model.setListResult(productService.findAll());
        req.setAttribute(SystemConstant.MODEL, model);
        RequestDispatcher rd = req.getRequestDispatcher("/views/admin/new/list.jsp");
        rd.forward(req, resp);
        //super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        //super.doPost(req, resp);
    }

}