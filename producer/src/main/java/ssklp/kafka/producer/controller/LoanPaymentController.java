package ssklp.kafka.producer.controller;

import com.fasterxml.jackson.core.JsonProcessingException;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ssklp.kafka.producer.model.LoanPayment;
import ssklp.kafka.producer.service.LoanPaymentService;

@Slf4j
@RestController
@RequestMapping("/payments")
public class LoanPaymentController {

    private final LoanPaymentService loanPayment;

    @Autowired
    public LoanPaymentController(LoanPaymentService loanPayment) {
        this.loanPayment = loanPayment;
    }

    @PostMapping
    public String createPayment(@RequestBody LoanPayment loanPayment) throws JsonProcessingException {
        log.info("create payment request received");
        return this.loanPayment.createPayment(loanPayment);
    }
}
