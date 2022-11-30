package org.acme;

import io.quarkus.runtime.StartupEvent;
import io.quarkus.vertx.ConsumeEvent;
import io.smallrye.mutiny.Multi;
import io.vertx.mutiny.core.eventbus.EventBus;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import java.time.Duration;
import java.util.UUID;

@ApplicationScoped
@Slf4j
public class HelloService extends GreetingService<HelloEvent> {

    @Inject
    EventBus eventBus;

    void onStart(@Observes StartupEvent evt) {
        Multi.createFrom().ticks().every(Duration.ofMillis(2000))
                .subscribe().with((Long tick) -> eventBus.publish(ADDRESS, new HelloEvent(UUID.randomUUID().toString())));
    }

    @Override
    @ConsumeEvent(ADDRESS)
    public void consume(@NonNull HelloEvent event) {
        log.info("consuming HelloEvent on HelloService: {}", event.getMessage());
    }
}
