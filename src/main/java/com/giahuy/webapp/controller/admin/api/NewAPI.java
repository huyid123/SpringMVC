package com.giahuy.webapp.controller.admin.api;

import com.giahuy.webapp.model.ProductModel;
import com.giahuy.webapp.service.IProductService;
import org.codehaus.jackson.map.ObjectMapper;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

import com.giahuy.webapp.utils.httpUtils;

@WebServlet(urlPatterns = {"/api-admin"})
public class NewAPI extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Inject
    private IProductService productService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       // super.doPost(req, resp);
        ObjectMapper mapper = new ObjectMapper();
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        BufferedReader body = req.getReader();
        ProductModel productModel = httpUtils.of(body).toModel(ProductModel.class);

        productModel = productService.save(productModel);
        mapper.writeValue(resp.getOutputStream(), productModel);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp);
        ObjectMapper mapper = new ObjectMapper();
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        ProductModel updateProduct = httpUtils.of(req.getReader()).toModel(ProductModel.class);
        updateProduct = productService.update(updateProduct);
        mapper.writeValue(resp.getOutputStream(), updateProduct);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp);
        ObjectMapper mapper = new ObjectMapper();
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        ProductModel deleteProduct = httpUtils.of(req.getReader()).toModel(ProductModel.class);
        productService.deleteProduct(deleteProduct.getIds());
        mapper.writeValue(resp.getOutputStream(), "{}");
    }


}
