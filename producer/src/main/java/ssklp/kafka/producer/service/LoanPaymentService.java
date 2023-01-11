package ssklp.kafka.producer.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ssklp.kafka.producer.service.producer.Producer;
import ssklp.kafka.producer.model.LoanPayment;

@Slf4j
@Service
public class LoanPaymentService {

    private final Producer producer;

    @Autowired
    public LoanPaymentService(Producer producer) {
        this.producer = producer;
    }

    public String createPayment(LoanPayment loanPayment) throws JsonProcessingException {
        return producer.sendMessage(loanPayment);
    }
}
