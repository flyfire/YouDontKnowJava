package com.solarexsoft.kotlinlearning

import kotlin.concurrent.thread

fun main() {
    var hi = "aaa"
    thread {
        hi = "bbb"
        println(hi)
    }
    hi = "ccc"
    println(hi)
}

/**
final ObjectRef hi = new ObjectRef();
hi.element = "aaa";
ThreadsKt.thread$default(false, false, (ClassLoader)null, (String)null, 0, (Function0)(new Function0() {
// $FF: synthetic method
// $FF: bridge method
public Object invoke() {
this.invoke();
return Unit.INSTANCE;
}

public final void invoke() {
hi.element = "bbb";
String var1 = (String)hi.element;
System.out.println(var1);
}
}), 31, (Object)null);
hi.element = "ccc";
String var1 = (String)hi.element;
System.out.println(var1);
 */