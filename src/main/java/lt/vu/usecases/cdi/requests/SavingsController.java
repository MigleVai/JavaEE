package lt.vu.usecases.cdi.requests;

//package lt.vu.usecases.cdi.requests.JPA;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import lt.vu.entities.Savings;
import lt.vu.usecases.cdi.DataFormatDecorator.FormatDecorator;
import lt.vu.usecases.cdi.DataFormatDecorator.IDataFormat;
import lt.vu.usecases.cdi.DataFormatDecorator.LongData;
import lt.vu.usecases.cdi.SavingAmountsAlternative.SavingAmount;
import lt.vu.usecases.cdi.SavingSenderSpecializes.SendSavings;
import lt.vu.usecases.cdi.dao.SavingsDAO;

import javax.annotation.PostConstruct;
import javax.decorator.Delegate;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Model
@Slf4j
public class SavingsController {

    @Getter
    private Savings save = new Savings();
    @Getter
    private Set<Savings> saves;
    @Getter
    private String messageSend = "Nothing";
    @PostConstruct
    public void init() {
        loadSavings();
    }

    @Inject
    private IDataFormat formatter;
    @Inject
    private SendSavings sender;
    @Inject
    private SavingAmount counter;
    @Inject
    private SavingsDAO savingsDAO;

    @Transactional
    public void createSave() {
        Set<Integer> ids = getSavesIds();
        int tempID = 1;
        while(ids.contains(tempID))
        {
            tempID++;
        }
        save.setId(tempID);
        setFormattedDate();
        savingsDAO.create(save);
        loadSavings();
    }

    @Transactional
    public String getCount(){
        return String.valueOf(counter.CountSavings(saves));
    }

    private void setFormattedDate(){
        String date = formatter.Format();
        save.setUpdate(date);
    }

    public Set<Integer> getSavesIds() {
        List sav = saves.stream().map(Savings::getId).collect(Collectors.toList());
        Set<Integer> s = new HashSet<>(sav);
        return s;
    }

    private void loadSavings() {
        saves = savingsDAO.getAllSaves();
    }

    @Transactional
    public void sendSavings(){
        Double amount = counter.CountSavings(saves);
        String message = sender.Send(amount);
        log.info(String.valueOf(sender.success()));
        if(sender.success()){
            messageSend = message;
        }else{
            messageSend = "Something went wrong...";
        }
    }
}
