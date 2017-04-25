package com.tencent.mm.plugin.freewifi.e;

import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.sdk.platformtools.v;

public final class d {
    private String aYz;
    private String bax;
    private int fZA;

    private static class a {
        private static d fZB = new d();
    }

    private d() {
    }

    public final synchronized boolean l(int i, String str, String str2) {
        boolean z = true;
        synchronized (this) {
            boolean z2;
            v.i("MicroMsg.FreeWifi.Protocol31Locker", "threeOneStartUpType=%d, apKey=%s, ticket=%s", new Object[]{Integer.valueOf(i), str, str2});
            if (i == 1 || i == 2 || i == 3) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                if (m.ty(str) || m.ty(str2)) {
                    z = false;
                } else if (str.equals(this.aYz) && str2.equals(this.bax) && this.fZA != i) {
                    z = false;
                } else {
                    this.fZA = i;
                    this.aYz = str;
                    this.bax = str2;
                }
            }
        }
        return z;
    }
}
