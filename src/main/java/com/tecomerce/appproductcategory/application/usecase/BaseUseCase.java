package com.tecomerce.appproductcategory.application.usecase;

import java.util.List;

public interface BaseUseCase<T, ID> {

    default T create(T entity) {
        return null;
    }

    default T createAll(List<T> entities) {
        return null;
    }

    default T update(T entity, ID id){
        return null;
    }

    default T updateAll(List<T> entities){
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

    default void deleteAll(List<ID> ids) {

    }

    default List<T> findAll(int page, int size, String sort, String direction, String search, String filter) {
        return null;
    }
}
