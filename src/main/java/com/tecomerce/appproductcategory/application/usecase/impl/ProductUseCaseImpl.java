package com.tecomerce.appproductcategory.application.usecase.impl;

import com.tecomerce.appproductcategory.application.usecase.ProductUseCase;
import com.tecomerce.appproductcategory.domain.entity.Product;
import com.tecomerce.appproductcategory.domain.entity.Size;
import com.tecomerce.appproductcategory.domain.repository.ProductRepository;
import com.tecomerce.appproductcategory.domain.util.MapperUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductUseCaseImpl implements ProductUseCase {

    private final MapperUtil mapperUtil;
    private final ProductRepository repository;

    @Override
    public Product create(Product entity) {
        entity.dateOfCreation();
        return repository.create(entity);
    }

    @Override
    public List<Product> createAll(List<Product> entities) {
        entities.forEach(Product::dateOfCreation);
        return repository.createAll(entities);
    }

    @Override
    public Product update(Product entity, String id) {
        return repository.update(entity, id);
    }

    @Override
    public List<Product> updateAll(List<Product> entities) {
        return repository.updateAll(entities);
    }

    @Override
    public Product findById(String id) {
        return repository.findById(id);
    }

    @Override
    public List<Product> findByIds(List<String> ids) {
       return repository.findByIds(ids);
    }

    @Override
    public void delete(String id) {
        repository.delete(id);
    }

    @Override
    public void deleteAll(List<String> ids) {
        repository.deleteAll(ids);
    }

    @Override
    public List<Product> findAllPaginated(int page, int size, String sort, String direction) {
        return repository.findAllPaginated(page, size, sort, direction);
    }

    @Override
    public List<Product> filterColors(String id, String name, String code, String hex, String rgb, int page, int size, String direction, String... properties) {
        return repository.filterColors(id, name, code, hex, rgb, page, size, direction, properties);
    }

    @Override
    public List<Product> filters(String filterProperties, int page, int size, String direction, String... sortProperties) {
        Product product = (Product) mapperUtil.mappingEntity(filterProperties, Product.class);
        return repository.filters(product, page, size, direction, sortProperties);
    }
}
