import org.dozer.DozerConverter;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.util.StringUtils;

// comment 
public class StringToJodaDateTimeConverter extends
                                          DozerConverter<String, DateTime> { // (1)
    public StringToJodaDateTimeConverter() {
        super(String.class, DateTime.class); // (2)
    }

    @Override
    public DateTime convertTo(String source, DateTime destination) {// (3)
        if (!StringUtils.hasLength(source)) {
            return null;
        }
        DateTimeFormatter formatter = DateTimeFormat
                .forPattern("yyyy-MM-dd HH:mm:ss");
        DateTime dt = formatter.parseDateTime(source);
        return dt;
    }

    @Override
    public String convertFrom(DateTime source, String destination) {// (4)
        if (source == null) {
            return null;
        }
        return source.toString("yyyy-MM-dd HH:mm:ss");
    }

}
