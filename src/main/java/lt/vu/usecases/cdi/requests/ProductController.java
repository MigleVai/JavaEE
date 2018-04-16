package lt.vu.usecases.cdi.requests;

//package lt.vu.usecases.cdi.requests.JPA;

import jdk.nashorn.internal.objects.annotations.Setter;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import lt.vu.entities.Location;
import lt.vu.entities.Product;
import lt.vu.usecases.cdi.dao.ProductDAO;
import lt.vu.usecases.cdi.dao.LocationDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.lang.reflect.Array;
import java.util.List;
import java.util.stream.Collectors;

@Model
@Slf4j
public class ProductController {

    @Getter
    private Product product = new Product();
    @Getter
    private List<Product> products;
    @Getter
    @lombok.Setter
    private String locationName;

    @PostConstruct
    public void init() {
        loadProducts();
    }

    @Inject
    private ProductDAO productDAO;
    @Inject
    private LocationDAO locationDAO;
    @Transactional
    public void createProduct() {
        List<Integer> ids = getProductIds();
        int tempID = 0;
        while(ids.contains(tempID))
        {
            tempID++;
        }
        log.info("Hi!");
        Location loc = locationDAO.findByName(locationName);
        log.info("Hello " + loc.toString());
        product.setLocation(loc);
        product.setId(tempID);
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