package sv.gob.mag.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ParentResponseDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;
    private UUID code;
    private String name;
    private String status;
    private Integer enabled;

    private ParentDetailResponseDTO parentDetails;

    private Long createdBy;
    private LocalDateTime createdAt;

    private Long updatedBy;
    private LocalDateTime updatedAt;

}
