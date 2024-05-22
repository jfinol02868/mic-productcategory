package com.tecomerce.appproductcategory.domain.util.mapper;

import java.util.List;

public interface BaseMapper<E,D> {

    public E toEntity(D dto);

    public D toDocument(E entity);

    public List<E> toEntityList(List<D> dtos);

    public List<D> toDocumentList(List<E> entities);
}
