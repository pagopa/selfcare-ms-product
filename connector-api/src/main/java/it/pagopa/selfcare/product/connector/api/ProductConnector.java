package it.pagopa.selfcare.product.connector.api;

import it.pagopa.selfcare.product.connector.model.ProductOperations;

import java.util.List;
import java.util.Optional;

public interface ProductConnector {

    ProductOperations insert(ProductOperations entity);

    ProductOperations save(ProductOperations entity);

    Optional<ProductOperations> findById(String id);

    boolean existsById(String id);

    boolean existsByIdAndEnabledFalse(String id);

    List<ProductOperations> findAll();

    void deleteById(String id);

    List<ProductOperations> findByEnabled(boolean enabled);

    List<ProductOperations> findByParentAndEnabled(String parent, boolean enabled);

}
