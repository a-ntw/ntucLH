/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demos.model;

import demos.db.Product;
import java.time.LocalDate;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.Valid;

/**
 *
 * @author antw
 */
@Stateless
@LocalBean
public class ProductFacade implements ProductFacadeRemote {
    
    @PersistenceContext(unitName = "ProductApp-ejbPU")
    private EntityManager em;
    
    @Override
    public void create(@Valid Product product) {
        //throw new UnsupportedOperationException("Not supported yet."); 
        em.persist(product);
    }

    @Override
    public void update(@Valid Product product) {
        //throw new UnsupportedOperationException("Not supported yet."); 
        em.merge(product);
    }

    @Override
    public void delete(Product product) {
        //throw new UnsupportedOperationException("Not supported yet."); 
        em.remove(product);
    }

    @Override
    public Product findProduct(Integer id) {
        return em.find(Product.class,id);
    }

    @Override
    public List<Product> findProductByName(String name) {
        Query productNameQuery = em.createNamedQuery("Product.findByName");
        productNameQuery.setParameter("name", name);
        return productNameQuery.getResultList();
    }

    public List<Product> findProductByDate(LocalDate date) {
        Query productDateQuery = 
                em.createNamedQuery("Product.findByBestBefore");
        productDateQuery.setParameter("bestBefore", date);
        return productDateQuery.getResultList();
    }

    public Object[] findTotal(List<Integer> ids) {
        Query productTotalQuery = em.createNamedQuery("Product.findTotal");
        productTotalQuery.setParameter("ids",ids);
        return (Object[])productTotalQuery.getSingleResult();
    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public void validateProduct(@Valid Product product) {
    }

}
