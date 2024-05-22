package com.tecomerce.appproductcategory.infrastructure.bd.mapper;

import com.tecomerce.appproductcategory.domain.entity.Money;
import com.tecomerce.appproductcategory.infrastructure.bd.document.MoneyDocument;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MoneyMapper extends BaseMapper<Money, MoneyDocument> {
}
