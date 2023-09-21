
package ch.astorm;

import org.graalvm.polyglot.Engine;

public class Main {
    public static void main(String[] args) throws Exception {
        //System.setProperty("polyglotimpl.TraceClassPathIsolation", "true");
        try(Engine engine = Engine.newBuilder("js").option("engine.WarnInterpreterOnly", "false").build()) {
            System.out.println("JavaScript engine detected successfully !");
        }
    }
}
