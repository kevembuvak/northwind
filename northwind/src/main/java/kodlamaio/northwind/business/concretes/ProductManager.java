package kodlamaio.northwind.business.concretes;

import kodlamaio.northwind.business.abstracts.ProductService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.core.utilities.results.SuccessDataResult;
import kodlamaio.northwind.core.utilities.results.SuccessResult;
import kodlamaio.northwind.dataAccess.abstracts.ProductDao;
import kodlamaio.northwind.entities.concretes.Product;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
    public DataResult<List<Product>> getAllSorted() {
        Sort sort = Sort.by(Sort.Direction.DESC, "productName");

        return new SuccessDataResult<>(this.dao.findAll(sort));

    }

    @Override
    public DataResult<List<Product>> getAll(int pageNo, int pageSize) {

        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);

        return new SuccessDataResult<>(this.dao.findAll(pageable).getContent());
    }

    @Override
    public Result add(Product product) {
        this.dao.save(product);
        return new SuccessResult("Ürün eklendi");
    }

    @Override
    public DataResult<Product> getByProductName(String productName) {
        return new SuccessDataResult<>(this.dao.getByProductName(productName), "İsme göre ürün getirildi ");
    }

    @Override
    public DataResult<Product> getByProductNameAndCategory_CategoryId(String productName, int categoryId) {
        return new SuccessDataResult<>(this.dao.getByProductNameAndCategory_CategoryId(productName, categoryId), "İsme ve kategoriye göre ürün getirildi ");
    }

    @Override
    public DataResult<List<Product>> getByProductNameOrCategory(String productName, int categoryId) {
        return new SuccessDataResult<>(this.dao.getByProductNameOrCategory(productName, categoryId), "İsme veya kategoriye göre ürün getirildi ");
    }

    @Override
    public DataResult<List<Product>> getByCategoryIn(List<Integer> categories) {
        return new SuccessDataResult<>(this.dao.getByCategoryIn(categories), "Kategori listesine göre ürün getirildi ");
    }

    @Override
    public DataResult<List<Product>> getByProductNameContains(String productName) {
        return new SuccessDataResult<>(this.dao.getByProductNameContains(productName), "İsmi içermesine göre ürün getirildi ");
    }

    @Override
    public DataResult<List<Product>> getByProductNameStartsWith(String productName) {
        return new SuccessDataResult<>(this.dao.getByProductNameStartsWith(productName), "İsimle başlamasına göre ürün getirildi ");
    }

    @Override
    public DataResult<List<Product>> getByProductNameEndsWith(String productName) {
        return new SuccessDataResult<>(this.dao.getByProductNameEndsWith(productName), "İsimle bitmesine göre ürün getirildi ");
    }

    @Override
    public DataResult<List<Product>> getByNameAndCategory(String productName, int categoryId) {
        return new SuccessDataResult<>(this.dao.getByNameAndCategory(productName, categoryId), "İsme ve kategoriye göre ürün getirildi ");
    }
}
