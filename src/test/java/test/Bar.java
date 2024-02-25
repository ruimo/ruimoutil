package test;

public class Bar {
    public final int i;
    public final String str;

    private Bar() {
        i = 123;
        str = null;
    }

    private Bar(String str) {
        i = 0;
        this.str = "Bar " + str;
    }

    private Bar(int i) {
        this.i = i;
        str = null;
    }

    private Bar(long l) throws Exception {
        throw new Exception();
    }

    private int add(int i, int j) {
        return i + j;
    }

    private void bar() throws Exception {
        throw new Exception();
    }
}
