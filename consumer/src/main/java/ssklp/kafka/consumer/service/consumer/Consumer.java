package ssklp.kafka.consumer.service.consumer;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import ssklp.kafka.consumer.model.LoanPayment;
import ssklp.kafka.consumer.model.dto.LoanPaymentDto;
import ssklp.kafka.consumer.service.LoanPaymentService;

@Slf4j
@Component
public class Consumer {

    @Autowired
    private Environment env;
    private static final String orderTopic = "t.loan.payment";
    private final ObjectMapper objectMapper;
    private final ModelMapper modelMapper;
    private final LoanPaymentService loanPaymentService;

    @Autowired
    public Consumer(ObjectMapper objectMapper, ModelMapper modelMapper, LoanPaymentService loanPaymentService) {
        this.objectMapper = objectMapper;
        this.modelMapper = modelMapper;
        this.loanPaymentService = loanPaymentService;
    }

    @KafkaListener(topics = orderTopic)
    public void consumeMessage(String message) throws JsonProcessingException {
        log.info("message consumed {}", message);

        LoanPaymentDto loanPaymentDto = objectMapper.readValue(message, LoanPaymentDto.class);
        LoanPayment loanPayment = modelMapper.map(loanPaymentDto, LoanPayment.class);

        loanPaymentService.persistLoanPayment(loanPayment);
    }

}