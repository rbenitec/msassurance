package NTTDATA.application.api.response;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AssuranceResponse {
    private String id;
    private BigDecimal minimumAmount;
    private BigDecimal maximumAmount;
    private BigDecimal price;
}
