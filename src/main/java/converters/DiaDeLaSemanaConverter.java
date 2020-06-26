package converters;

import javax.persistence.AttributeConverter;
import java.time.DayOfWeek;

public class DiaDeLaSemanaConverter implements AttributeConverter<DayOfWeek,String> {
    @Override
    public String convertToDatabaseColumn(DayOfWeek dayOfWeek) {
        return null;
    }

    @Override
    public DayOfWeek convertToEntityAttribute(String s) {
        if (s == null)
            return null;
        DayOfWeek day;
        switch (s){
            case "Lunes" : day = DayOfWeek.MONDAY; break;
            case "Martes" : day = DayOfWeek.MONDAY; break;
            case "Miesrcoles" : day = DayOfWeek.MONDAY; break;
            case "Jueves" : day = DayOfWeek.MONDAY; break;
            case "Viernes" : day = DayOfWeek.MONDAY; break;
        }
    }
}
