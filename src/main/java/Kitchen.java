package org.koch;

import io.quarkus.vertx.ConsumeEvent;
import io.vertx.mutiny.core.eventbus.EventBus;

import jakarta.enterprise.context.ApplicationScoped;

import jakarta.inject.Inject;

@ApplicationScoped
public class Kitchen {
    @Inject
    EventBus bus;

    @ConsumeEvent("prepareDish")
    public String PrepareDish(Dish dish)
    {
        //Do some stuff to prepare the dish...

        bus.<String>requestAndForget("dishPrepared", dish);
        //Using bus.<Void> and return null on the consuming function will cause a timeout exception
        return "1";
    }
}
