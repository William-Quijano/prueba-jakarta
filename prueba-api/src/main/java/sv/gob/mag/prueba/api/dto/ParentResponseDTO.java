package sv.gob.mag.prueba.api.dto;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ParentResponseDTO implements Serializable {
    private Long id;
    private UUID code;
    private String name;
    private String status;
    private Integer enabled;
    private List<ParentResponseDTO> parentDetails;

    private LocalDateTime createdAt;
}
