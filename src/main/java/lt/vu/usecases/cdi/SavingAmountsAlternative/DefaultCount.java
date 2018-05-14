package lt.vu.usecases.cdi.SavingAmountsAlternative;

import lt.vu.entities.Savings;
import java.util.Set;

public class DefaultCount implements SavingAmount {
    public Double CountSavings(Set<Savings> saves){
        long wholeCount = 0;
        for (Savings s:saves) {
            wholeCount += s.getAmount();
        }
        return Double.valueOf(wholeCount);
    }
}