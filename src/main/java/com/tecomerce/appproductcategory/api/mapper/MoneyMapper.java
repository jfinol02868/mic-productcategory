package com.tecomerce.appproductcategory.api.mapper;

import com.tecomerce.appproductcategory.api.service.dto.MoneyDTO;
import com.tecomerce.appproductcategory.domain.entity.Money;
import com.tecomerce.appproductcategory.domain.util.mapper.BaseDtoMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MoneyMapper extends BaseDtoMapper<Money, MoneyDTO> {
}
