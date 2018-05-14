package lt.vu.usecases.cdi.DataFormatDecorator;

import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.RequestScoped;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
@RequestScoped
public class LongData implements IDataFormat {
    @Override
    public String Format() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formatDateTime = now.format(formatter);
        return formatDateTime;
    }
}
