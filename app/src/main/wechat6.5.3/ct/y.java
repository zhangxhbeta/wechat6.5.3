package ct;

public final class y {
    private static x a = null;

    public static synchronized x a() {
        x xVar;
        synchronized (y.class) {
            if (a == null) {
                a = new x();
            }
            xVar = a;
        }
        return xVar;
    }
}
