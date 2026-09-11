package sv.gob.mag.dto.request;

import jakarta.validation.constraints.*;
import lombok.*;
import sv.gob.mag.dto.enums.StatusEnum;

import java.io.Serial;
import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ParentUpdateRequestDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Positive(message = "El id no puede ser negativo")
    @NotNull(message = "El id es obligatorio")
    private Long id;

    @NotBlank(message = "El nombre es obligatorio")
    @Size(max = 100, message = "El nombre no debe exceder los 100 caracteres")
    private String name;

    @NotNull(message = "El estado es obligatorio")
    private StatusEnum status;
}
