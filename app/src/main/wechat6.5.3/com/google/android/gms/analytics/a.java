package com.google.android.gms.analytics;

import com.google.android.gms.analytics.internal.q;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class a extends c {
    private static List<Runnable> afr = new ArrayList();
    public boolean afs;
    public boolean aft;
    private Set<Object> afu = new HashSet();
    public boolean afv;
    volatile boolean afw;

    public a(q qVar) {
        super(qVar);
    }

    public static void hl() {
        synchronized (a.class) {
            if (afr != null) {
                for (Runnable run : afr) {
                    run.run();
                }
                afr = null;
            }
        }
    }
}
