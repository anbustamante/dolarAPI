package com.anbustamante.dolarhoy.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlueDto {
    String type;
    LocalDateTime fecha;
    String compra;
    String venta;
}
