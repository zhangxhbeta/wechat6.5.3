package ct;

import android.location.Location;
import android.os.Bundle;

public final class bn extends bo implements bm, bz {
    public static final bn a = new bn();

    public static bm b() {
        return a;
    }

    public static bz c() {
        return a;
    }

    private bn() {
        super("dummy", "dummy");
    }

    public final Location d() {
        return bu.b;
    }

    public final void a() {
    }

    protected final boolean a(Bundle bundle) {
        return false;
    }
}
