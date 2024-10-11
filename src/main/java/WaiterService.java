package org.koch;

import io.quarkus.vertx.ConsumeEvent;

import jakarta.websocket.Session;
import jakarta.websocket.OnClose;
import jakarta.websocket.OnOpen;
import jakarta.websocket.server.ServerEndpoint;

import io.quarkus.logging.Log;

import jakarta.enterprise.context.ApplicationScoped;

@ServerEndpoint("/waiter")
@ApplicationScoped
public class WaiterService{

    Session session;

    @OnOpen
    public void onOpen(Session session)
    {
        this.session = session;
    }

    @OnClose
    public void onClose(Session session)
    {
        session = null;
    }

    @ConsumeEvent("dishPrepared")
    public String DishPrepared(Dish dish)
    {
        if(null == session) return null;
        session.getAsyncRemote().sendObject(dish.name);
        return "1";
    }
}
