package app.comp.entity.audit;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class StringToDateTimeConvert implements Converter<String, DateTime> {


    private String DEFAULT_DATE_PATTERN = "yyyy-MM-dd";
    private DateTimeFormatter dateTimeFormatter;
    private String datePattern = DEFAULT_DATE_PATTERN;


    @Autowired(required = false)
    public void setDatePattern(String datePattern) {
        this.datePattern = datePattern;
    }


    @PostConstruct
    public void init() {
        dateTimeFormatter = DateTimeFormat.forPattern(datePattern);
    }

    @Override
    public DateTime convert(String s) {
        return dateTimeFormatter.parseDateTime(s);
    }
}
