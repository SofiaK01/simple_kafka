package ssklp.kafka.consumer.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ssklp.kafka.consumer.model.LoanPayment;

@Repository
public interface LoanPaymentRepository extends JpaRepository<LoanPayment, Long> {
}
