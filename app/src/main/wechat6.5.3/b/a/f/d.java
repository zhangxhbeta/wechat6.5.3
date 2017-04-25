package b.a.f;

import java.util.Random;

public final class d implements c {
    private a pPB = new a();

    static class a {
        a() {
        }
    }

    public final String getNonce() {
        return String.valueOf(bRx().longValue() + ((long) Integer.valueOf(new Random().nextInt()).intValue()));
    }

    public final String bRw() {
        return String.valueOf(bRx());
    }

    private static Long bRx() {
        return Long.valueOf(Long.valueOf(System.currentTimeMillis()).longValue() / 1000);
    }
}
