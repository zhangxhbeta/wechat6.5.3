package com.tencent.mm.plugin.freewifi;

import com.tencent.mm.plugin.freewifi.g.b;
import com.tencent.mm.plugin.freewifi.model.j;

public final class i {
    private b fWK;

    private static class a {
        private static i fWV = new i();
    }

    private i() {
        this.fWK = j.apk();
    }

    public final synchronized long tw(String str) {
        long j = 0;
        synchronized (this) {
            if (!m.ty(str)) {
                try {
                    String tN = this.fWK.tN(str);
                    if (!m.ty(tN)) {
                        j = Long.valueOf(tN).longValue();
                    }
                } catch (Exception e) {
                }
            }
        }
        return j;
    }

    public final synchronized int getInt(String str, int i) {
        if (!m.ty(str)) {
            try {
                String tN = this.fWK.tN(str);
                if (!m.ty(tN)) {
                    i = Integer.valueOf(tN).intValue();
                }
            } catch (Exception e) {
            }
        }
        return i;
    }

    public final synchronized void s(String str, long j) {
        this.fWK.bF(str, String.valueOf(j));
    }

    public final synchronized void ay(String str, int i) {
        this.fWK.bF(str, String.valueOf(i));
    }
}
