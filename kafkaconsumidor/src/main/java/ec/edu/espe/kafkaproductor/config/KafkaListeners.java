package ec.edu.espe.kafkaproductor.config;

import ec.edu.espe.kafkaproductor.dto.Prestamo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class KafkaListeners {
    @KafkaListener(topics = "events", groupId = "spring")
    public void Listener(List<Prestamo> data){
        log.info("{}", data.size());
    }
}
