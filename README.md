# GraalJS assembly test

This simple project shows how there seems to be regression in GraalJS 23.1.0
when the dependencies are embedded in an assemply.

## How to test

Simply compile the project with the following command (JDK17 required):

```sh
> mvn clean package
```

Execute the jar from maven (it works):
```sh
> mvn -q exec:java
JavaScript engine detected successfully !
```

Now execute the full assembly with the embedded libraries:
```sh
>  java -jar target/polyglott-full-embedded.jar
Exception in thread "main" java.lang.IllegalStateException: No language and polyglot implementation was found on the class-path. Make sure at last one language is added on the class-path. If you put a language on the class-path and you encounter this error then there could be a problem with isolated class loading. Use -Dpolyglotimpl.TraceClassPathIsolation=true to debug class loader islation problems. For best performance it is recommended to use polyglot from the module-path instead of the class-path.
        at org.graalvm.polyglot.Engine$PolyglotInvalid.noPolyglotImplementationFound(Engine.java:2071)
        at org.graalvm.polyglot.Engine$PolyglotInvalid.createHostAccess(Engine.java:2057)
        at org.graalvm.polyglot.Engine$PolyglotInvalid.createHostAccess(Engine.java:2023)
        at org.graalvm.polyglot.Engine$Builder.build(Engine.java:753)
        at ch.astorm.Main.main(Main.java:9)
```
