package com.tecomerce.appproductcategory.api.service.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MoneyDTO {

    @Schema(description = "Unique identifier of the money", example = "MONEY::BA0EE851-37C9-4518-A54F-FB69FCC6F891::DES")
    private String id;
    @Schema(description = "Currency of the money", example = "USD")
    private String currency;
    @Schema(description = "Amount of the money", example = "100.00")
    private BigDecimal amount;

}
