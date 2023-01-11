package ssklp.kafka.consumer.model.dto;


import lombok.Data;
import lombok.Value;

@Data
@Value
public class LoanPaymentDto {
    String debtor;
    Double amount;
}
