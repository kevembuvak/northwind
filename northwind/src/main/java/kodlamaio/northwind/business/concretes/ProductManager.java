package kodlamaio.northwind.business.concretes;

import kodlamaio.northwind.business.abstracts.ProductService;
import kodlamaio.northwind.dataAccess.abstracts.ProductDao;
import kodlamaio.northwind.entities.concretes.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductManager implements ProductService {

    private ProductDao dao;

    @Autowired
    public ProductManager(ProductDao dao) {
        this.dao = dao;
    }


    @Override
    public List<Product> getAll() {
        return dao.findAll();
    }
}