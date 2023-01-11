package ssklp.kafka.producer.model;


import lombok.Data;
import lombok.Value;

@Data
@Value
public class LoanPayment {
    String debtor;
    Double amount;
}