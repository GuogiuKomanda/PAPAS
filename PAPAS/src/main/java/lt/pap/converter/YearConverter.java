package lt.pap.converter;

import java.time.Year;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class YearConverter implements AttributeConverter<Year, Integer> {

    @Override
    public Integer convertToDatabaseColumn(Year entityValue) {
        if (entityValue == null)
            return null;
        return entityValue.getValue();
    }

    @Override
    public Year convertToEntityAttribute(Integer databaseValue) {
        if (databaseValue == null)
            return null;
        return Year.of(databaseValue);
    }
}