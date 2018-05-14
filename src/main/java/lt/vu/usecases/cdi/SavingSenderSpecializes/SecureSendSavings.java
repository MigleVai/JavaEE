package lt.vu.usecases.cdi.SavingSenderSpecializes;

import lombok.extern.slf4j.Slf4j;
import javax.enterprise.inject.Specializes;

@Slf4j
@Specializes
public class SecureSendSavings extends SendSavings {
    @Override
    public String Send(Double amount){
        sendSuccess = true;
        String mes = "Savings are encoded and are ready to be sent!";
        log.info(mes);
        return mes;
    }
}
