package ct;

import android.text.TextUtils;

public final class af implements ab {
    private static af a = null;

    public static synchronized af a() {
        af afVar;
        synchronized (af.class) {
            if (a == null) {
                a = new af();
            }
            afVar = a;
        }
        return afVar;
    }

    public final void a(ag agVar) {
        if (!TextUtils.isEmpty(p.b)) {
            o.a().a(new ai(agVar));
        }
        agVar.toString();
        bd.a();
    }
}
