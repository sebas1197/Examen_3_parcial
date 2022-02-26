package ec.edu.espe.kafkaproductor.controller;

import ec.edu.espe.kafkaproductor.dto.GeneradorRequest;
import ec.edu.espe.kafkaproductor.dto.Prestamo;
import ec.edu.espe.kafkaproductor.utils.PrestamoGenerador;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Data
@Slf4j
@RestController
@RequestMapping(value = "api/v1/prestamoGenerador")
public class Controller {
    private final KafkaTemplate<String, Object> kafkaTemplate;

    @PostMapping(value = "/")
    public ResponseEntity test(@RequestBody GeneradorRequest request){
        PrestamoGenerador prestamoGenerador = new PrestamoGenerador();
        List<Prestamo> prestamos = prestamoGenerador.generar(request.getNumeroRegistros());

        kafkaTemplate.send("events", prestamos);
        return ResponseEntity.ok().build();
    }
}
