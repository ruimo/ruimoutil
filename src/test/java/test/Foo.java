package test;

public class Foo {
    private boolean bool = true;
    private byte b = 123;
    private char c = 1234;
    private float f = 12345;
    private double d = 123456;
    private short s = 999;

    private int i = 777;
    private long l = 888;
    private String str = "hello";

    private static String hello() {
        return "Hello";
    }

    private String hello(String str) {
        return "Hello " + str;
    }

    private int inc(int i) {
        return ++i;
    }
}
