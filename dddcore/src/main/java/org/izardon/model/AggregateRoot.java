package org.izardon.model;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class AggregateRoot<ID> extends Entity<ID> {

    private final List<DomainEvent> domainEvents;

    public AggregateRoot(ID id) {
        super(id);
        this.domainEvents = new CopyOnWriteArrayList<>();
    }

    public void addDomainEvent(DomainEvent domainEvent) {
        domainEvents.add(domainEvent);
    }

    public List<DomainEvent> getDomainEvents() {
        return Collections.unmodifiableList(domainEvents);
    }

    public void clearDomainEvents(){
        domainEvents.clear();
    }
}
