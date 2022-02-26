package ec.edu.espe.kafkaproductor.dto;

import ec.edu.espe.kafkaproductor.model.PrestamoModel;
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

    public PrestamoModel parseToModel(){
        return PrestamoModel.builder()
                .prestamoCode(id)
                .numeroCuota(numeroCuota)
                .valorPago(valorPago)
                .fechaPago(fechaPago)
                .build();
    }
}
