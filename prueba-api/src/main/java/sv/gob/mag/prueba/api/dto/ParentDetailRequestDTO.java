package sv.gob.mag.prueba.api.dto;

import jakarta.validation.constraints.*;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ParentDetailRequestDTO implements Serializable {

    @NotBlank(message = "El nombre es obligatorio")
    @Size(max = 210, message = "El nombre no debe exceder los 100 caracteres")
    private String name;

    @NotNull(message = "La cantidad es un campo obligatorio")
    @DecimalMin(value = "0.01", message = "La cantidad ingresada debe ser mayor a cero.")
    @Digits(integer = 15, fraction = 4, message = "Formato numérico inválido. Máximo 15 enteros y 4 decimales.")
    private BigDecimal quantity;

    @NotNull(message = "Debe seleccionar un registro Padre obligatoriamente.")
    @Positive(message = "El identificador del registro Padre no es válido.")
    private Long idParentDetail;


}
