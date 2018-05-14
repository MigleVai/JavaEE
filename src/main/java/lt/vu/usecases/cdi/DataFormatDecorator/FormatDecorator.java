package lt.vu.usecases.cdi.DataFormatDecorator;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Any;
import javax.inject.Inject;

@Decorator
public abstract class FormatDecorator implements IDataFormat{
    @Inject @Delegate @Any
    IDataFormat formatter;

    public abstract String Format();
}
