package org.acme;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class HelloEvent {

    @Getter
    String message;
}
