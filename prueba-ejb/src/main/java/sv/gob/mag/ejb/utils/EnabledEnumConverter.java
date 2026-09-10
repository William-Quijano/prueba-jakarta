package sv.gob.mag.ejb.utils;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import sv.gob.mag.dto.enums.EnabledEnum;

@Converter(autoApply = true)
public class EnabledEnumConverter implements AttributeConverter<EnabledEnum, String> {
    @Override
    public String convertToDatabaseColumn(EnabledEnum attribute) {
        return attribute == null ? null : attribute.getCode();
    }

    @Override
    public EnabledEnum convertToEntityAttribute(String dbData) {
        return dbData == null ? null : EnabledEnum.codeToString(dbData);
    }
}
