package com.tencent.mm.vending.h;

import android.os.Looper;
import com.tencent.mm.vending.f.a;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import junit.framework.Assert;

public class g {
    private static Map<String, d> pib = new ConcurrentHashMap();
    private static Map<Looper, d> pic = new HashMap();
    private static boolean pie = false;

    static {
        bKR();
    }

    public static void a(String str, d dVar) {
        Assert.assertNotNull("Scheduler type is null", str);
        String toUpperCase = str.toUpperCase();
        if (pib.containsKey(toUpperCase)) {
            IllegalStateException illegalStateException = new IllegalStateException("Fatal error! Duplicate scheduler type " + str.toUpperCase());
        }
        pib.put(toUpperCase, dVar);
        if (dVar instanceof h) {
            synchronized (g.class) {
                pic.put(((h) dVar).aJl, dVar);
            }
        }
    }

    public static d PN(String str) {
        Assert.assertNotNull("Scheduler type is null", str);
        d dVar = (d) pib.get(str.toUpperCase());
        Assert.assertNotNull("Scheduler type not found: " + str.toUpperCase(), dVar);
        return dVar;
    }

    public static synchronized d bKQ() {
        d cVar;
        synchronized (g.class) {
            Looper myLooper = Looper.myLooper();
            if (myLooper == null) {
                a.w("Vending.SchedulerProvider", "This is not a handler thread! %s", Thread.currentThread());
                cVar = new c();
            } else {
                cVar = (d) pic.get(myLooper);
                if (cVar == null) {
                    cVar = new h(myLooper, myLooper.toString());
                    pic.put(myLooper, cVar);
                }
            }
        }
        return cVar;
    }

    static synchronized void bKR() {
        synchronized (g.class) {
            if (!pie) {
                a.i("Vending.SchedulerProvider", "SchedulerProvider provided.", new Object[0]);
                pie = true;
                a("Vending.UI", d.phX);
                a("Vending.LOGIC", d.phY);
                a("Vending.HEAVY_WORK", d.phZ);
            }
        }
    }
}
