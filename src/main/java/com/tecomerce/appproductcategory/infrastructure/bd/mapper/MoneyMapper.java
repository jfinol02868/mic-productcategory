package com.tecomerce.appproductcategory.infrastructure.bd.mapper;

import com.tecomerce.appproductcategory.domain.entity.Money;
import com.tecomerce.appproductcategory.infrastructure.bd.document.MoneyDocument;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MoneyMapper {

    public Money toEntity(MoneyDocument moneyDocument);

    public MoneyDocument toDocument(Money money);

    public List<Money> toEntityList(List<MoneyDocument> moneyDocuments);

    public List<MoneyDocument> toDocumentList(List<Money> moneys);
}
