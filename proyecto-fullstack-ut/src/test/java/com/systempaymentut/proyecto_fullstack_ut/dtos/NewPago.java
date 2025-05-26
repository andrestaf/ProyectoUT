package com.systempaymentut.proyecto_fullstack_ut.dtos;

import java.time.LocalDate;

import com.systempaymentut.proyecto_fullstack_ut.enums.TypePago;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class NewPago {
    
    private double cantidad;
    private TypePago typepago;
    private LocalDate date;

    private String codigoEstudiante;

}
