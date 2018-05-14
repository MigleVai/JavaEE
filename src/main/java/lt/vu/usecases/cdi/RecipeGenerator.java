package lt.vu.usecases.cdi;

import jdk.nashorn.internal.objects.annotations.Getter;
import lombok.extern.slf4j.Slf4j;
import org.apache.deltaspike.core.api.future.Futureable;

import javax.ejb.AsyncResult;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.concurrent.Future;

@Slf4j
@ApplicationScoped
@Named
public class RecipeGenerator implements Serializable {

    @Futureable
    public Future<String> generateFood(String name) {
        try {
            Thread.sleep(3000); // Simulate intensive work
        } catch (InterruptedException e) {
        }
        log.info(name);
        String mess = "Recipe " + name + " was made.";
        return new AsyncResult<>(mess);
    }

}