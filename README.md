# Generic Abstract Parent Class Doubles Consumer invocation Project

## Actual behaviour:
Having a class extending a class with generics which has an abstract method for the consumer method, this will result in the method annotated with `@Consume` on the extending class to be called twice per eventbus message.

1. Start the application
2. You will notice duplicated outputs from consumer like `consuming HelloEvent on HelloService: ee73ab41-6b9a-465a-967c-d264046e0cc0`

## Expected behaviour
Its expected that a method annotated with `@ConsumeEvent` is invoked only once per message.

1. Remove `public abstract void consume(@NonNull T event);` from `GreetingService`
2. Start the application
3. You will notice that the consumer is invoked only once per message
