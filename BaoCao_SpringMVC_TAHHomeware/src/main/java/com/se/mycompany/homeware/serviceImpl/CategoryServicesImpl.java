package com.se.mycompany.homeware.serviceImpl;

import com.se.mycompany.homeware.dao.CategoryDao;
import com.se.mycompany.homeware.daoImpl.CategoryDaoImpl;
import com.se.mycompany.homeware.model.Catalog;
import com.se.mycompany.homeware.service.CategoryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoryServicesImpl implements CategoryService {

    @Autowired
    CategoryDao categoryDao = new CategoryDaoImpl();
          
    @Override
    @Transactional
    public void insert(Catalog category) {
        categoryDao.insert(category);
    }

    @Override
    @Transactional
    public void edit(Catalog newCategory) {
        Catalog oldCate = categoryDao.get((newCategory.getId()));
        oldCate.setName(newCategory.getName());
        oldCate.setParent_id(newCategory.getParent_id());
        categoryDao.edit(oldCate);

    }

    @Override
    @Transactional
    public void delete(String id) {
        categoryDao.delete(id);

    }

    @Override
    @Transactional
    public Catalog get(int id) {
        return categoryDao.get(id);
    }

    @Override
    @Transactional
    public Catalog get(String name) {
        return categoryDao.get(name);
    }

    @Override
    @Transactional
    public List<Catalog> getAll() {
        return categoryDao.getAll();
    }

    public List<Catalog> getCateByProduct(int id) {
        return categoryDao.getCateByProduct(id);
    }

}
