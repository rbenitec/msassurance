package NTTDATA.application.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document(collection = "assurances")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Assurance {
    @Id
    private String id;
    private String description;
    private BigDecimal minimumAmount;
    private BigDecimal maximumAmount;
    private BigDecimal price;
    private String status; // 0 =>Inactive  |  1 => active

    public boolean isActive(){
        return this.status.equals("1");
    }

}
