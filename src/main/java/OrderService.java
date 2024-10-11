package org.koch;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

import io.quarkus.logging.Log;

import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import org.jboss.resteasy.reactive.RestQuery;


@Path("/order")
public class OrderService{

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String PlaceOrder(@RestQuery String id)
    {
        Log.info("Id " + id+ " ordered");
        return "1";
    }
}
