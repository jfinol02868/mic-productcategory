package com.tecomerce.appproductcategory.api.mapper;

import com.tecomerce.appproductcategory.api.service.dto.MoneyDTO;
import com.tecomerce.appproductcategory.domain.entity.Money;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MoneyDtoMapper {

    public Money toEntity(MoneyDTO moneyDTO);

    public MoneyDTO toDto(Money money);

    public List<Money> toEntityList(List<MoneyDTO> moneyDTOS);

    public List<MoneyDTO> toDtoList(List<Money> moneys);
}
