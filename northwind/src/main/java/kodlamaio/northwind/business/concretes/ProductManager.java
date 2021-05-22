package kodlamaio.northwind.business.concretes;

import kodlamaio.northwind.business.abstracts.ProductService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.core.utilities.results.SuccessDataResult;
import kodlamaio.northwind.core.utilities.results.SuccessResult;
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
    public DataResult<List<Product>> getAll() {
        return new SuccessDataResult<>(this.dao.findAll(), "Tüm ürünler getirildi ");
    }

    @Override
    public Result add(Product product) {
        this.dao.save(product);
        return new SuccessResult("Ürün eklendi");
    }
}
