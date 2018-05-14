package lt.vu.usecases.cdi.DataFormatDecorator;

import javax.enterprise.context.RequestScoped;
import java.time.LocalDate;

public class SimpleData implements IDataFormat {
    @Override
    public String Format() {
        String date = String.valueOf(LocalDate.now());
        return  date;
    }
}
