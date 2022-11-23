package org.acme;

import io.quarkus.runtime.StartupEvent;
import io.quarkus.vertx.ConsumeEvent;
import io.smallrye.mutiny.Multi;
import io.vertx.mutiny.core.eventbus.EventBus;
import lombok.NonNull;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import java.time.Duration;

@ApplicationScoped
public class GreetingService {

    private static final String ADDRESS = "hello";

    @Inject
    EventBus eventBus;

    void onStart(@Observes StartupEvent evt) {
        Multi.createFrom().ticks().every(Duration.ofMillis(2000))
                .subscribe().with((Long tick) -> eventBus.publish(ADDRESS, new HelloEvent("Hello there!")));
    }

    @ConsumeEvent(ADDRESS)
    public void consume(@NonNull HelloEvent event) {
        // Nothing here, not relevant for the reproducer
    }
}
