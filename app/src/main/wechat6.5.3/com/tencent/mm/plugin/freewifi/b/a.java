package com.tencent.mm.plugin.freewifi.b;

import com.tencent.mm.plugin.freewifi.m;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public final class a {
    private boolean fXY;
    private Map<String, b> fXZ;

    private static class a {
        private static a fYb = new a();
    }

    public static class b {
        String aYz;
        int fXb;
    }

    private a() {
        this.fXY = false;
        this.fXZ = new LinkedHashMap<String, b>(this) {
            final /* synthetic */ a fYa;

            {
                this.fYa = r1;
            }

            protected final boolean removeEldestEntry(Entry entry) {
                return size() > 512;
            }
        };
    }

    private static String bB(String str, String str2) {
        return str + "-" + str2;
    }

    public final synchronized void b(String str, String str2, String str3, int i) {
        if (!(m.ty(str) || m.ty(str2) || m.ty(str3) || (i != 4 && i != 31))) {
            b bVar = new b();
            bVar.aYz = str3;
            bVar.fXb = i;
            this.fXZ.put(bB(str, str2), bVar);
        }
    }

    public final synchronized b bC(String str, String str2) {
        b bVar;
        if (m.ty(str) || m.ty(str2)) {
            bVar = null;
        } else {
            bVar = (b) this.fXZ.get(bB(str, str2));
        }
        return bVar;
    }

    public final synchronized int size() {
        return this.fXZ.size();
    }
}
