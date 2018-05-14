package lt.vu.usecases.cdi.SavingAmountsAlternative;

import lt.vu.entities.Savings;

import java.util.Set;

public interface SavingAmount {
    Double CountSavings(Set<Savings> saves);
}
