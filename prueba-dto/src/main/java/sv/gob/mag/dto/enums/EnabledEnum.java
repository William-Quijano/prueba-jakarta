package sv.gob.mag.dto.enums;

import lombok.Getter;

@Getter
public enum EnabledEnum {

    ACTIVE("1", "Activo"),
    INACTIVE("0", "Inactivo");

    private final String code;
    private final String description;

    EnabledEnum(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public static EnabledEnum codeToString(String codigo) {
        if ("1".equals(codigo)) return ACTIVE;
        if ("0".equals(codigo)) return INACTIVE;
        throw new IllegalArgumentException("Código de estado desconocido: " + codigo);
    }
}


