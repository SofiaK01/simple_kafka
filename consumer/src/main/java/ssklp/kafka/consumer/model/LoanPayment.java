package ssklp.kafka.consumer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class LoanPayment {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String debtor;
    private Double amount;
    private LocalDate date;
}
