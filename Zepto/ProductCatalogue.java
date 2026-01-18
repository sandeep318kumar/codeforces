import java.util.List;
import java.util.ArrayList;
class ProductCatalogue implements Aggregate<Product> {
    private List<Product> products = new ArrayList<>();
    
    void addProduct(Product product) {
        products.add(product);
    }

    List<Product> getProducts() {
        return products;
    }

    @Override
    public Iterator<Product> createIterator() {
        return new ProuductIterator(this);
    }
}