package productclient;

import demos.db.Product;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.OptimisticLockException;
import javax.validation.ConstraintViolationException;
import demos.model.ProductManager;
import java.util.List;

public class ProductClient {

    private static final Logger logger = Logger.getLogger(ProductClient.class.getName());

    public static void main(String[] args) {
        try {
            ProductManager pm = new ProductManager("ProductClientPU");

//            Product p = pm.findProduct(1);
//            System.out.println(p);

            List<Product> products = pm.findProductByName("Co%");
            products.stream().forEach(p -> System.out.println(p));
            
            pm.closeEntityManager();
        } catch (Exception ex) {
            Throwable cause = ex.getCause();
            if (cause instanceof ConstraintViolationException) {
                ConstraintViolationException e = (ConstraintViolationException) cause;
                e.getConstraintViolations().stream().forEach(v -> logger.log(Level.INFO, v.getMessage()));
            } else if (cause instanceof OptimisticLockException) {
                OptimisticLockException e = (OptimisticLockException) cause;
                logger.log(Level.INFO, e.getMessage());
            } else {
                logger.log(Level.SEVERE, "Product Manager Error", ex);
            }
        }
    }
}
