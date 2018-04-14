package lt.vu.usecases.cdi.requests;

//package lt.vu.usecases.cdi.requests.JPA;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import lt.vu.entities.Product;
import lt.vu.usecases.cdi.dao.ProductDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Model
@Slf4j
public class ProductController {

    @Getter
    private Product product = new Product();
    @Getter
    private List<Product> products;

    @PostConstruct
    public void init() {
        loadProducts();
    }

    @Inject
    private ProductDAO productDAO;

    @Transactional
    public void createProduct() {
        productDAO.create(product);
        log.info("Product titled: " + product.getName() + " was created...");
        loadProducts();
    }

    public List<String> getProductNames() {
        return products.stream().map(Product::getName).collect(Collectors.toList());
    }

    public List<Integer> getProductIds() {
        return products.stream().map(Product::getId).collect(Collectors.toList());
    }

    private void loadProducts() {
        products = productDAO.getAllProducts();
    }
}