package com.tecomerce.appproductcategory.domain.repository;

import com.tecomerce.appproductcategory.domain.entity.Color;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

public interface BaseRepository<T, ID> {

    default T create(T entity) {
        return null;
    }

    default List<T> createAll(List<T> entities) {
        return null;
    }

    default T update(T entity, ID id){
        return null;
    }

    default List<T> updateAll(List<T> entities){
        return null;
    }

    default T findById(ID id) {
        return null;
    }

    default List<T> findByIds(List<ID> id) {
        return null;
    }

    default void delete(ID id) {
    }

    default List<Color> deleteAll(List<ID> ids) {
        return null;
    }

    default List<T> findAll(int page, int size, String sort, String direction) {
        return null;
    }

    default List<T> filterColors(String id, String name, String code, String hex, String rgb){
        return null;
    }
}
