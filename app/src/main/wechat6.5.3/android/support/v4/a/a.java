package android.support.v4.a;

import android.os.Build.VERSION;
import android.view.View;

public final class a {
    private static final b nt;

    static {
        if (VERSION.SDK_INT >= 12) {
            nt = new d();
        } else {
            nt = new c();
        }
    }

    public static void v(View view) {
        nt.v(view);
    }
}
