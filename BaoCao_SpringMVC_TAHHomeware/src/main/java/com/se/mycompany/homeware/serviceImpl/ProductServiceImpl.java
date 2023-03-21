package com.se.mycompany.homeware.serviceImpl;

import com.se.mycompany.homeware.dao.ProductDao;
import com.se.mycompany.homeware.model.Product;
import com.se.mycompany.homeware.service.ProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public void insert(Product product) {
        productDao.insert(product);
    }

    @Override
    public void edit(Product newProduct) {
        Product oldProduct = productDao.get(newProduct.getId());
        oldProduct.setName(newProduct.getName());
        oldProduct.setCatalog_id(newProduct.getCatalog_id());
        oldProduct.setStatus(newProduct.getStatus());
        oldProduct.setPrice(newProduct.getPrice());
        oldProduct.setDescription(newProduct.getDescription());
        oldProduct.setContent(newProduct.getContent());
        oldProduct.setDiscount(newProduct.getDiscount());
        oldProduct.setImage_link(newProduct.getImage_link());
        oldProduct.setCreated(newProduct.getCreated());

        productDao.edit(oldProduct);

    }

    @Override
    public void delete(String id) {
        productDao.delete(id);

    }

    @Override
    public Product get(int id) {
        return productDao.get(id);
    }

    @Override
    public Product get(String name) {
        return productDao.get(name);
    }

    @Override
    @Transactional
    public List<Product> getAll() {
        return productDao.getAll();
    }

    @Override
    @Transactional
    public List<Product> getProductById(int id) {
        return productDao.getProductById(id);
    }

    @Override
    @Transactional
    public List<Product> searchByName(String productName) {
        return productDao.searchByName(productName);
    }

    @Override
    public List<Product> getProductByIdCate(int idCate) {
        // TODO Auto-generated method stub
        return null;
    }

}
