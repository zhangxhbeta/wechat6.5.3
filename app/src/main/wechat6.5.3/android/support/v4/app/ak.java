package android.support.v4.app;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import java.util.ArrayList;
import java.util.Iterator;

public final class ak implements Iterable<Intent> {
    private static final b sZ;
    public final ArrayList<Intent> ta = new ArrayList();
    public final Context tb;

    public interface a {
        Intent br();
    }

    interface b {
    }

    static class c implements b {
        c() {
        }
    }

    static class d implements b {
        d() {
        }
    }

    static {
        if (VERSION.SDK_INT >= 11) {
            sZ = new d();
        } else {
            sZ = new c();
        }
    }

    private ak(Context context) {
        this.tb = context;
    }

    public static ak j(Context context) {
        return new ak(context);
    }

    public final ak a(ComponentName componentName) {
        int size = this.ta.size();
        try {
            Intent a = s.a(this.tb, componentName);
            while (a != null) {
                this.ta.add(size, a);
                a = s.a(this.tb, a.getComponent());
            }
            return this;
        } catch (Throwable e) {
            throw new IllegalArgumentException(e);
        }
    }

    public final Iterator<Intent> iterator() {
        return this.ta.iterator();
    }
}
