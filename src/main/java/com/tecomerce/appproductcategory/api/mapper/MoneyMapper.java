package com.tecomerce.appproductcategory.api.mapper;

import com.tecomerce.appproductcategory.domain.entity.Money;
import com.tecomerce.appproductcategory.domain.util.mapper.BaseMapper;
import com.tecomerce.appproductcategory.infrastructure.bd.document.MoneyDocument;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MoneyMapper extends BaseMapper<Money, MoneyDocument> {
}
