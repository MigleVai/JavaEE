package lt.vu.usecases.cdi.SavingAmountsAlternative;

import lt.vu.entities.Savings;

import javax.enterprise.inject.Alternative;
import java.util.Set;

@Alternative
public class TaxCount implements SavingAmount {
    public Double CountSavings(Set<Savings> saves){
        long wholeCount = 0;
        for (Savings s:saves) {
            long temp = s.getAmount()/3;
            wholeCount += temp;
        }
        return Double.valueOf(wholeCount);
    }
}

