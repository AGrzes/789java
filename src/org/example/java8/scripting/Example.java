package org.example.java8.scripting;

import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import jdk.nashorn.api.scripting.ScriptObjectMirror;

public class Example {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        ScriptEngineManager factory = new ScriptEngineManager();
        ScriptEngine engine = factory.getEngineByName("nashorn");
        try {
            engine.getContext().getBindings(ScriptContext.ENGINE_SCOPE).put("test", (Supplier<String>) () -> "Test");
            engine.eval("print(test());" + "var Random=Java.type('java.util.Random'); " + "print(new Random().nextInt());" + "r = new Random().nextInt();"
                    + "var obj = { A: 'A', B: [1,2,3],C : function(d) { return d},D : function(f) { return f(obj)}}");
            System.out.println(engine.getContext().getBindings(ScriptContext.ENGINE_SCOPE).get("r"));
            ScriptObjectMirror obj = (ScriptObjectMirror) engine.getContext().getBindings(ScriptContext.ENGINE_SCOPE).get("obj");
            System.out.println(obj.get("A"));
            ScriptObjectMirror B = (ScriptObjectMirror) obj.get("B");
            System.out.println(B.values());
            ScriptObjectMirror C = (ScriptObjectMirror) obj.get("C");
            System.out.println(C.call("this", "X", "Y"));
            System.out.println(obj.callMember("C", "X", "Y"));

            System.out.println(obj.callMember("D", (Function<ScriptObjectMirror, Object>) (ScriptObjectMirror som) -> som.callMember("C", "X")));

            System.out.println(((UnaryOperator<String>) obj.callMember("D",
                    (Function<ScriptObjectMirror, UnaryOperator<String>>) (ScriptObjectMirror som) -> (String s) -> (String) som.callMember("C", s)))
                            .apply("TEST"));
        } catch (final ScriptException se) {
            se.printStackTrace();
        }

    }

}
