# nonnullissue Project

Start the app and wait - you will see:
```
2022-11-23 10:11:12,320 ERROR [io.qua.run.Application] (Quarkus Main Thread) Failed to start application (with profile dev): java.lang.ClassNotFoundException: org.acme.@NonNull HelloEvent
	at java.base/jdk.internal.loader.BuiltinClassLoader.loadClass(BuiltinClassLoader.java:641)
	at java.base/jdk.internal.loader.ClassLoaders$AppClassLoader.loadClass(ClassLoaders.java:188)
	at java.base/java.lang.ClassLoader.loadClass(ClassLoader.java:520)
	at io.quarkus.bootstrap.classloading.QuarkusClassLoader.loadClass(QuarkusClassLoader.java:505)
	at io.quarkus.bootstrap.classloading.QuarkusClassLoader.loadClass(QuarkusClassLoader.java:455)
	at io.quarkus.bootstrap.classloading.QuarkusClassLoader.loadClass(QuarkusClassLoader.java:505)
	at io.quarkus.bootstrap.classloading.QuarkusClassLoader.loadClass(QuarkusClassLoader.java:455)
	at java.base/java.lang.Class.forName0(Native Method)
	at java.base/java.lang.Class.forName(Class.java:467)
	at io.quarkus.deployment.steps.VertxProcessor$build609260703.deploy_0(Unknown Source)
	at io.quarkus.deployment.steps.VertxProcessor$build609260703.deploy(Unknown Source)
	at io.quarkus.runner.ApplicationImpl.doStart(Unknown Source)
	at io.quarkus.runtime.Application.start(Application.java:101)
	at io.quarkus.runtime.ApplicationLifecycleManager.run(ApplicationLifecycleManager.java:110)
	at io.quarkus.runtime.Quarkus.run(Quarkus.java:70)
	at io.quarkus.runtime.Quarkus.run(Quarkus.java:43)
	at io.quarkus.runtime.Quarkus.run(Quarkus.java:123)
	at io.quarkus.runner.GeneratedMain.main(Unknown Source)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:77)
	at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.base/java.lang.reflect.Method.invoke(Method.java:568)
	at io.quarkus.runner.bootstrap.StartupActionImpl$1.run(StartupActionImpl.java:104)
	at java.base/java.lang.Thread.run(Thread.java:833)
```
