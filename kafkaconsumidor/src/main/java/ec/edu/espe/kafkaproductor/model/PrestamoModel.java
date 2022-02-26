package ec.edu.espe.kafkaproductor.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(value = "prestamo")
@Builder
@Data
public class PrestamoModel {
    @Id
    private String id;

    private String prestamoCode;
    private Long valorPago;
    private Date fechaPago;
    private Integer numeroCuota;
}
