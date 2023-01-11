package ssklp.kafka.producer.service.producer;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import ssklp.kafka.producer.model.LoanPayment;

@Slf4j
@Component
public class Producer {

    @Value("${topic.name}")
    private String orderTopic;

    private final ObjectMapper objectMapper;
    private final KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public Producer(KafkaTemplate<String, String> kafkaTemplate, ObjectMapper objectMapper) {
        this.kafkaTemplate = kafkaTemplate;
        this.objectMapper = objectMapper;
    }

    public String sendMessage(LoanPayment loanPayment) throws JsonProcessingException {
        String paymentAsMessage = objectMapper.writeValueAsString(loanPayment);
        kafkaTemplate.send(orderTopic, paymentAsMessage);

        log.info("loan payment produced {}", paymentAsMessage);

        return "message sent";
    }
}
