package org.acme;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class GreetingService<T> {
    public static final String ADDRESS = "greeting";

    public abstract void consume(T event);
}
