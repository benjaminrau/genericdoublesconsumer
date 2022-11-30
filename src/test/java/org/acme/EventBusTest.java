package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.eventbus.impl.HandlerHolder;
import io.vertx.core.impl.utils.ConcurrentCyclicSequence;
import io.vertx.mutiny.core.Vertx;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.lang.reflect.Field;
import java.util.concurrent.ConcurrentMap;

@QuarkusTest
class EventBusTest {

	@Inject
	Vertx vertx;

	@Test
	void handlerMap_handlersForHelloAddress_onlyOneConsumer() throws NoSuchFieldException, IllegalAccessException {
		// GIVEN
		EventBus eventBus = vertx.getDelegate().eventBus();
		Field handlerMapField = eventBus.getClass().getDeclaredField("handlerMap");
		handlerMapField.setAccessible(true);

		// WHEN
		ConcurrentMap<String, ConcurrentCyclicSequence<HandlerHolder>> handlerMap =
			(ConcurrentMap<String, ConcurrentCyclicSequence<HandlerHolder>>) handlerMapField.get(eventBus);

		// THEN
		Assertions.assertEquals(1, handlerMap.get(HelloService.ADDRESS).size());
	}
}
