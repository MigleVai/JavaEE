package lt.vu.usecases.cdi.SavingSenderSpecializes;

import javax.enterprise.context.RequestScoped;
import java.sql.Date;
import java.time.LocalDate;

@RequestScoped
public class SendSavings {
    boolean sendSuccess = false;
    public String Send(Double amount){
        if(amount > 0){
        String date = String.valueOf(Date.valueOf(LocalDate.now()));
        String mess = "Savings are getting ready to be sent. The amount was " + amount + ". The date is " + date;
        sendSuccess = true;
        return  mess;
        }
        return "Nothing to send";
    }
    public boolean success(){
        if(sendSuccess){
            return true;
        }else{
            return false;
        }
    }

}
