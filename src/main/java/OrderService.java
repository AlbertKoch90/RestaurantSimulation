package org.koch;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

import io.quarkus.logging.Log;

import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

import io.vertx.mutiny.core.eventbus.EventBus;

import org.jboss.resteasy.reactive.RestQuery;


@Path("/order")
public class OrderService{

    @Inject
    EntityManager entityManager;
    @Inject
    EventBus bus;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String PlaceOrder(@RestQuery String id)
    {
        Dish dish = entityManager.find(Dish.class, id);
        if(null == dish)
        {
            Log.info("Dish not found");
        }
        else
        {
            bus.<String>requestAndForget("prepareDish", dish);
            //Using bus.<Void> and return null on the consuming function will cause a timeout exception
        }

        return "1";
    }
}
