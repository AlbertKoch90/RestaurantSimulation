package org.koch;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;

@Entity
public class Dish extends PanacheEntity {
    public String name;
    public long preparationDuration;
}
