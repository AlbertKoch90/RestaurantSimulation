package org.koch;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;
import java.util.stream.Collectors;

@Path("/dishes")
public class DishService {
    @GET
    @Path("names")
    @Produces(MediaType.TEXT_PLAIN)
        public String names() {
        List<Dish> dishes = Dish.listAll();
        return dishes.stream().map(d->d.name).collect(Collectors.joining(", "));
    }
}
