package com.tecomerce.appproductcategory.domain.util.mapper;

import java.util.List;

public interface BaseDtoMapper<E,D> {

    public E toEntity(D dto);

    public D toDot(E entity);

    public List<E> toEntityList(List<D> dtos);

    public List<D> toDtoList(List<E> entities);
}
