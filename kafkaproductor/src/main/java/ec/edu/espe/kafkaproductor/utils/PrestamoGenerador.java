package ec.edu.espe.kafkaproductor.utils;

import ec.edu.espe.kafkaproductor.dto.Prestamo;

import java.util.*;

public class PrestamoGenerador {

    private Random random;

    public PrestamoGenerador(){
        random = new Random();
    }

    public String generarId(Integer id){
        return String.format("%07d", id);
    }

    public Long generarValorPago(){
        Long limiteMinimo = 25l, limiteMaximo = 5000l;
        return limiteMinimo + random.nextLong(limiteMaximo - limiteMinimo);
    }

    public Date generarFechaPago(){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, random.nextInt(365 * 5) * -1);
        return calendar.getTime();
    }

    public Integer generarNumeroCuota(){
        return 1 + random.nextInt(12 * 10 -1);
    }

    public List<Prestamo> generar(Integer numeroRegistros){
        List<Prestamo> resultado = new ArrayList<Prestamo>();

        for (Integer i=0; i<numeroRegistros; i++){
            resultado.add(Prestamo.builder()
                    .id(generarId(i))
                    .valorPago(generarValorPago())
                    .fechaPago(generarFechaPago())
                    .numeroCuota(generarNumeroCuota())
                    .build());

        }
        return resultado;
    }
}
