package ssklp.kafka.consumer.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ssklp.kafka.consumer.model.LoanPayment;
import ssklp.kafka.consumer.repository.LoanPaymentRepository;

import java.time.LocalDate;

@Slf4j
@Service
public class LoanPaymentService {

    private final LoanPaymentRepository loanPaymentRepository;

    @Autowired
    public LoanPaymentService(LoanPaymentRepository loanPaymentRepository) {
        this.loanPaymentRepository = loanPaymentRepository;
    }

    public void persistLoanPayment(LoanPayment loanPayment) {
        loanPayment.setDate(LocalDate.now());
        LoanPayment persistedLoanPayment = loanPaymentRepository.save(loanPayment);
        log.info("loan payment persisted {}", persistedLoanPayment);
    }

}