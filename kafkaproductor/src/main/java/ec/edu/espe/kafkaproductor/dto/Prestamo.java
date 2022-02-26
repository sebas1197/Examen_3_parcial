package ec.edu.espe.kafkaproductor.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class Prestamo {
    private String id;
    private Long valorPago;
    private Date fechaPago;
    private Integer numeroCuota;
}
